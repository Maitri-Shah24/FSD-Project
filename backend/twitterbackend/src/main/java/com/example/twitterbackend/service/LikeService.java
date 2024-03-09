package com.example.twitterbackend.service;

import com.example.twitterbackend.exception.TweetException;
import com.example.twitterbackend.exception.UserException;
import com.example.twitterbackend.model.Like;
import com.example.twitterbackend.model.User;

import java.util.List;

public interface LikeService
{
    public Like likeTweet(Long tweetId, User user) throws UserException, TweetException;

    public List<Like> getAllLikes(Long tweetId) throws TweetException;
}
