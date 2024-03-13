package com.example.twitterbackend.controller;

import com.example.twitterbackend.dto.UserDTO;
import com.example.twitterbackend.dto.mapper.UserDTOMapper;
import com.example.twitterbackend.exception.UserException;
import com.example.twitterbackend.model.User;
import com.example.twitterbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile(@RequestHeader("Authorization") String jwt) throws UserException{
        User user = userService.findUserProfileByJwt(jwt);
        UserDTO userDTO = UserDTOMapper.toUserDTO(user);
        userDTO.setReq_user(true);
        return  new ResponseEntity<UserDTO>(userDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@RequestHeader("Authorization") String jwt) throws UserException{
        User user = userService.findUserProfileByJwt(jwt);
        UserDTO userDTO = UserDTOMapper.toUserDTO(user);
        userDTO.setReq_user(true);
        return  new ResponseEntity<UserDTO>(userDTO, HttpStatus.ACCEPTED);
    }
}
