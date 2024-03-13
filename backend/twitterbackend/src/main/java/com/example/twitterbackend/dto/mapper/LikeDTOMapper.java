package com.example.twitterbackend.dto.mapper;

import com.example.twitterbackend.dto.LikeDTO;
import com.example.twitterbackend.dto.TweetDTO;
import com.example.twitterbackend.dto.UserDTO;
import com.example.twitterbackend.model.Like;
import com.example.twitterbackend.model.User;

import java.util.ArrayList;
import java.util.List;

public class LikeDTOMapper
{
    public  static LikeDTO toLikeDTO(Like like, User reqUser)
    {
        UserDTO user = UserDTOMapper.toUserDTO(like.getUser());
        UserDTO reqUserDto = UserDTOMapper.toUserDTO(reqUser);
        TweetDTO tweet = TweetDTOMapper.toTweetDTO(like.getTweet(),reqUser);


        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setId(like.getId());
        likeDTO.setTweet(tweet);
        likeDTO.setUser(user);

        return likeDTO;
    }
    public static List<LikeDTO> tolikeDTOS(List<Like> likes,User reqUser)
    {
        List<LikeDTO> likeDTOS = new ArrayList<>();

        for(Like like:likes)
        {
            UserDTO user = UserDTOMapper.toUserDTO(like.getUser());
            TweetDTO tweet = TweetDTOMapper.toTweetDTO(like.getTweet(),reqUser);

            LikeDTO likeDTO = new LikeDTO();
            likeDTO.setId(like.getId());
            likeDTO.setTweet(tweet);
            likeDTO.setUser(user);
            likeDTOS.add(likeDTO);


        }
        return  likeDTOS;
    }
}
