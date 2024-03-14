package com.example.twitterbackend.controller;

import com.example.twitterbackend.dto.UserDTO;
import com.example.twitterbackend.dto.mapper.UserDTOMapper;
import com.example.twitterbackend.exception.UserException;
import com.example.twitterbackend.model.User;
import com.example.twitterbackend.service.UserService;
import com.example.twitterbackend.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException{
        User reqUser = userService.findUserProfileByJwt(jwt);
        User user = userService.findUserById(userId);
        UserDTO userDTO = UserDTOMapper.toUserDTO(user);
        userDTO.setReq_user(UserUtil.isReqUser(reqUser,user));
        userDTO.setFollowed(UserUtil.isFollowedByReqUser(reqUser,user));

        return  new ResponseEntity<UserDTO>(userDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> searchUser(@RequestParam String query, @RequestHeader("Authorization") String jwt) throws UserException{
        User reqUser = userService.findUserProfileByJwt(jwt);
        List<User> users = userService.searchUser(query);
        List<UserDTO> userDTOs = UserDTOMapper.toUserDTOs(users);
        return  new ResponseEntity<>(userDTOs, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> searchUser(@RequestBody User req, @RequestHeader("Authorization") String jwt) throws UserException{
        User reqUser = userService.findUserProfileByJwt(jwt);
        User user = userService.updateUser(reqUser.getId(),req);
        UserDTO userDTO = UserDTOMapper.toUserDTO(user);
        return  new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{userId}/follow")
    public ResponseEntity<UserDTO> searchUser(@PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws UserException{
        User reqUser = userService.findUserProfileByJwt(jwt);
        User user = userService.followUser(userId,reqUser);
        UserDTO userDTO = UserDTOMapper.toUserDTO(user);
        userDTO.setFollowed(UserUtil.isFollowedByReqUser(reqUser,user));
        return  new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
    }
}
