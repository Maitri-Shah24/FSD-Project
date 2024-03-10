package com.example.twitterbackend.dto.mapper;

import com.example.twitterbackend.dto.TweetDTO;
import com.example.twitterbackend.dto.UserDTO;
import com.example.twitterbackend.model.Tweet;
import com.example.twitterbackend.model.User;
import com.example.twitterbackend.util.TweetUtil;

import java.util.ArrayList;
import java.util.List;

public class TweetDTOMapper
{
    public static TweetDTO toTweetDTO(Tweet tweet, User reqUser)
    {
        UserDTO user = UserDTOMapper.toUserDTO(tweet.getUser());
        boolean isLiked = TweetUtil.isLikedByReqUser(reqUser,tweet);
        boolean isRetweeted = TweetUtil.isRetweetedByUser(reqUser,tweet);

        List<Long> retweetUserId = new ArrayList<>();
        for(User user1:tweet.getReTweetUser())
        {
            retweetUserId.add(user1.getId());
        }
        TweetDTO tweetDTO = new TweetDTO();
        tweetDTO.setId(tweet.getId());
        tweetDTO.setContent(tweet.getContent());
        tweetDTO.setCreatedAt(tweet.getCreatedAt());
        tweetDTO.setImage(tweet.getImage());
        tweetDTO.setTotalLikes(tweet.getLikes().size());
        tweetDTO.setTotalReplies(tweetDTO.getReplyTweets().size());
        tweetDTO.setUser(user);
        tweetDTO.setLiked(isLiked);
        tweetDTO.setRetweet(isRetweeted);
        tweetDTO.setRetweetUsersId(retweetUserId);
        tweetDTO.setReplyTweets(toTweetDTOs(tweet.getReplyTweets(),reqUser));
        tweetDTO.setVideo(tweet.getVideo());

        return tweetDTO;
    }
    public static List<TweetDTO> toTweetDTOs(List<Tweet> tweets,User reqUser)
    {
        List<TweetDTO> tweetDTOS = new ArrayList<>();

        for (Tweet tweet:tweets)
        {
            TweetDTO tweetDTO = toReplyTweetDTO(tweet,reqUser);
            tweetDTOS.add(tweetDTO);
        }
        return tweetDTOS;
    }

    private static TweetDTO toReplyTweetDTO(Tweet tweet, User reqUser) {
        UserDTO user = UserDTOMapper.toUserDTO(tweet.getUser());
        boolean isLiked = TweetUtil.isLikedByReqUser(reqUser,tweet);
        boolean isRetweeted = TweetUtil.isRetweetedByUser(reqUser,tweet);

        List<Long> retweetUserId = new ArrayList<>();
        for(User user1:tweet.getReTweetUser())
        {
            retweetUserId.add(user1.getId());
        }
        TweetDTO tweetDTO = new TweetDTO();
        tweetDTO.setId(tweet.getId());
        tweetDTO.setContent(tweet.getContent());
        tweetDTO.setCreatedAt(tweet.getCreatedAt());
        tweetDTO.setImage(tweet.getImage());
        tweetDTO.setTotalLikes(tweet.getLikes().size());
        tweetDTO.setTotalReplies(tweetDTO.getReplyTweets().size());
        tweetDTO.setUser(user);
        tweetDTO.setLiked(isLiked);
        tweetDTO.setRetweet(isRetweeted);
        tweetDTO.setRetweetUsersId(retweetUserId);
        tweetDTO.setVideo(tweet.getVideo());

        return tweetDTO;
    }
}
