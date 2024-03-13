package com.example.twitterbackend.controller;

import com.example.twitterbackend.dto.TweetDTO;
import com.example.twitterbackend.dto.mapper.TweetDTOMapper;
import com.example.twitterbackend.exception.TweetException;
import com.example.twitterbackend.exception.UserException;
import com.example.twitterbackend.model.Tweet;
import com.example.twitterbackend.model.User;
import com.example.twitterbackend.request.TweetReplyRequest;
import com.example.twitterbackend.response.ApiResponse;
import com.example.twitterbackend.service.TweetService;
import com.example.twitterbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController
{
    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<TweetDTO> createTweet(@RequestBody Tweet req, @RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        Tweet tweet = tweetService.createTweet(req,user);
        TweetDTO tweetDTO = TweetDTOMapper.toTweetDTO(tweet,user);

        return  new ResponseEntity<>(tweetDTO, HttpStatus.CREATED);
    }
    @PostMapping("/reply")
    public ResponseEntity<TweetDTO> replyTweet(@RequestBody TweetReplyRequest req, @RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        Tweet tweet = tweetService.createdReply(req,user);
        TweetDTO tweetDTO = TweetDTOMapper.toTweetDTO(tweet,user);

        return  new ResponseEntity<>(tweetDTO, HttpStatus.CREATED);
    }
    @PutMapping("/{tweetId}/retweet")
    public ResponseEntity<TweetDTO> reTweet(@PathVariable Long tweetId, @RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        Tweet tweet = tweetService.retweet(tweetId,user);
        TweetDTO tweetDTO = TweetDTOMapper.toTweetDTO(tweet,user);


        return  new ResponseEntity<>(tweetDTO, HttpStatus.OK);
    }

    @GetMapping("/{tweetId}")
    public ResponseEntity<TweetDTO> findTweetById(@PathVariable Long tweetId, @RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        Tweet tweet = tweetService.findById(tweetId);
        TweetDTO tweetDTO = TweetDTOMapper.toTweetDTO(tweet,user);


        return  new ResponseEntity<>(tweetDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<ApiResponse> deleteTweet(@PathVariable Long tweetId, @RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        tweetService.deleteTweetById(tweetId, user.getId());
       ApiResponse res = new ApiResponse();
       res.setMessage("Tweet deleted successfully");
       res.setStatus(true);
        return  new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TweetDTO>> getAllTweets(@RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        List<Tweet> tweets = tweetService.findAllTweet();
        List<TweetDTO> tweetDTO = TweetDTOMapper.toTweetDTOs(tweets,user);


        return  new ResponseEntity<>(tweetDTO, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TweetDTO>> getUsersAllTweets(@PathVariable Long userId,@RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        List<Tweet> tweets = tweetService.getUserTweet(user);

        List<TweetDTO> tweetDTO = TweetDTOMapper.toTweetDTOs(tweets,user);


        return  new ResponseEntity<>(tweetDTO, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}/likes")
    public ResponseEntity<List<TweetDTO>> findTweetByLikesContainsUser(@PathVariable Long userId,@RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        List<Tweet> tweets = tweetService.findByLikesContainsUser(user);

        List<TweetDTO> tweetDTO = TweetDTOMapper.toTweetDTOs(tweets,user);


        return  new ResponseEntity<>(tweetDTO, HttpStatus.OK);
    }


}
