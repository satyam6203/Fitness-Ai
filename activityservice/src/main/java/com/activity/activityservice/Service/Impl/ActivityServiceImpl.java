package com.activity.activityservice.Service.Impl;

import com.activity.activityservice.Constant.ActivityType;
import com.activity.activityservice.Dto.ActivityRequest;
import com.activity.activityservice.Dto.ActivityResponse;
import com.activity.activityservice.Model.Activity;
import com.activity.activityservice.Repo.ActivityRepo;
import com.activity.activityservice.Service.ActivityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepo activityRepo;

    @Override
    public ActivityResponse trackActivity(ActivityRequest req) {
        Activity activity=Activity.builder()
                .userId(req.getUserId())
                .type(req.getType())
                .duration(req.getDuration())
                .caloriesBurned(req.getCaloriesBurned())
                .startTime(req.getStatedTime())
                .additionalMetrics(req.getAdditionalMetrics())
                .build();
        Activity saveActivity=activityRepo.save(activity);
        return mapToResponse(saveActivity);
    }

    private ActivityResponse mapToResponse(Activity activity){
        ActivityResponse response=new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUserId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setStartTime(activity.getStartTime());
        return response;
    }

    @Override
    public List<ActivityResponse> getUserActivity(String userId) {
        List<Activity> activity=activityRepo.findByUserId(userId);
        return activity.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ActivityResponse getActivityById(String activityId) {
        return activityRepo.findById(activityId).map(this::mapToResponse)
                .orElseThrow(()->new RuntimeException("Activity not find By this id"+activityId));
    }
}
