package com.example.twitterbackend.service;

import com.example.twitterbackend.exception.TweetException;
import com.example.twitterbackend.exception.UserException;
import com.example.twitterbackend.model.Tweet;
import com.example.twitterbackend.model.User;
import com.example.twitterbackend.request.TweetReplyRequest;

import java.util.List;

public interface TweetService
{
    public Tweet createTweet(Tweet req, User user) throws UserException;
    public List<Tweet> findAllTweet();
    public Tweet retweet(Long tweetId,User user) throws UserException, TweetException;
    public Tweet findById(Long tweetId) throws TweetException;
    public void deleteTweetById(Long tweetId,Long userId) throws TweetException,UserException;
    public Tweet removeFromRetweet(Long tweetId,User user) throws TweetException,UserException;
    public Tweet createdReply(TweetReplyRequest req, User user) throws TweetException;
    public List<Tweet> getUserTweet(User user);
    public List<Tweet> findByLikesContainsUser(User user);

}
