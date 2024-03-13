package com.example.twitterbackend.controller;

import com.example.twitterbackend.dto.LikeDTO;
import com.example.twitterbackend.dto.mapper.LikeDTOMapper;
import com.example.twitterbackend.exception.TweetException;
import com.example.twitterbackend.exception.UserException;
import com.example.twitterbackend.model.Like;
import com.example.twitterbackend.model.User;
import com.example.twitterbackend.service.LikeService;
import com.example.twitterbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController
{
    @Autowired
    private UserService userService;
    @Autowired
    private LikeService likeService;
    @PostMapping("/{tweetId}/likes")
    public ResponseEntity<LikeDTO> likeTweet(@PathVariable Long tweetId,
    @RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        Like like = likeService.likeTweet(tweetId,user);

        LikeDTO likeDTO = LikeDTOMapper.toLikeDTO(like,user);
        return  new ResponseEntity<LikeDTO>(likeDTO, HttpStatus.CREATED);
    }

    @PostMapping("/tweet/{tweetId}")
    public ResponseEntity<List<LikeDTO>> getAllLikes(@PathVariable Long tweetId,
                                                     @RequestHeader("Authorization") String jwt) throws UserException, TweetException
    {
        User user = userService.findUserProfileByJwt(jwt);
        List<Like> like = likeService.getAllLikes(tweetId);

        List<LikeDTO> likeDTO = LikeDTOMapper.tolikeDTOS(like,user);
        return  new ResponseEntity<>(likeDTO, HttpStatus.CREATED);
    }


}
