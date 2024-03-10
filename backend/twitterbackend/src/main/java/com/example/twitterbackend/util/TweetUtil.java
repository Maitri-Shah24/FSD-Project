package com.example.twitterbackend.util;

import com.example.twitterbackend.model.Like;
import com.example.twitterbackend.model.Tweet;
import com.example.twitterbackend.model.User;

public class TweetUtil
{
    public final static boolean isLikedByReqUser(User reqUser, Tweet tweet){
        for(Like like:tweet.getLikes()){
            if(like.getUser().getId().equals(reqUser.getId())){
                return true;
            }
        }
        return false;
    }
    public final static boolean isRetweetedByUser(User reqUser,Tweet tweet)
    {
        for(User user: tweet.getReTweetUser()){
                if(user.getId().equals(reqUser.getId()))
                {
                    return  true;
                }
        }
        return false;
    }
}
