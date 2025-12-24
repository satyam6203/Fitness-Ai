package com.fitness.userservice.Service;

import com.fitness.userservice.Dto.RegisterRequest;
import com.fitness.userservice.Dto.UserResponse;

public interface UserService {
    public UserResponse register(RegisterRequest request);
    public UserResponse getUserProfile(String userId);
    public boolean existByUserId(String userId);
}
