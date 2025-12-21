package com.fitness.userservice.Service.Impl;

import com.fitness.userservice.Dto.RegisterRequest;
import com.fitness.userservice.Dto.UserResponse;
import com.fitness.userservice.Model.User;
import com.fitness.userservice.Repo.UserRepo;
import com.fitness.userservice.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserResponse register(RegisterRequest request) {

        if(userRepo.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exits");
        }
        User user=new User();
        user.setEmail(request.getEmail());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        User saveUser= userRepo.save(user);

        UserResponse userResponse=new UserResponse();
        userResponse.setId(saveUser.getId());
        userResponse.setEmail(saveUser.getEmail());
        userResponse.setPassword(saveUser.getPassword());
        userResponse.setFirstName(saveUser.getFirstName());
        userResponse.setLastName(saveUser.getLastName());
        userResponse.setCreatedAt(saveUser.getCreatedAt());
        userResponse.setUpdatedAt(saveUser.getUpdatedAt());
        return userResponse;
    }

    @Override
    public UserResponse getUserProfile(String userId) {
        User user=userRepo.findById(userId).orElseThrow(()->
                new RuntimeException("user not found with this id"));
        UserResponse userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return userResponse;
    }

}
