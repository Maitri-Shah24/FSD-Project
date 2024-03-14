package com.example.twitterbackend.dto.mapper;

import com.example.twitterbackend.dto.UserDTO;
import com.example.twitterbackend.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTOMapper {
    public static UserDTO toUserDTO(User user)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFullName(user.getFullName());
        userDTO.setImage(user.getImage());
        userDTO.setBackgroundImage(user.getBackgroundImage());
        userDTO.setBio(user.getBio());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setFollowers(toUserDTOs(user.getFollowers()));
        userDTO.setFollowing(toUserDTOs(user.getFollowings()));
        userDTO.setLogin_with_google(user.isLogin_with_google());
        userDTO.setLocation(user.getLocation());
        //userDTO.setVerified(false);
        return userDTO;
    }

    public static List<UserDTO> toUserDTOs(List<User> followers) {
        List<UserDTO> userDTOs = new ArrayList<>();

        for(User user : followers)
        {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setEmail(user.getEmail());
            userDTO.setFullName(user.getFullName());
            userDTO.setImage(user.getImage());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }
}
