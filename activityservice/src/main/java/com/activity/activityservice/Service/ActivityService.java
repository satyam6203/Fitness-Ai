package com.activity.activityservice.Service;

import com.activity.activityservice.Dto.ActivityRequest;
import com.activity.activityservice.Dto.ActivityResponse;

import java.util.List;

public interface ActivityService {
    public ActivityResponse trackActivity(ActivityRequest req);
    public List<ActivityResponse> getUserActivity(String userId);
    public ActivityResponse getActivityById(String activityId);
}
