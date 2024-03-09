package com.example.twitterbackend.controller;

import com.example.twitterbackend.dto.TweetDTO;
import com.example.twitterbackend.service.TweetService;
import com.example.twitterbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tweets")
public class TweetController
{
    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;

    public ResponseEntity<TweetDTO> replyTweets;


}
