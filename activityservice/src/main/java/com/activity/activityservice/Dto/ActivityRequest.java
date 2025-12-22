package com.activity.activityservice.Dto;

import com.activity.activityservice.Constant.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRequest {
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime statedTime;
    private Map<String,Object> additionalMetrics;
}
