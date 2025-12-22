package com.activity.activityservice.Controller;

import com.activity.activityservice.Dto.ActivityRequest;
import com.activity.activityservice.Dto.ActivityResponse;
import com.activity.activityservice.Service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity")
@AllArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest req){
        return ResponseEntity.ok(activityService.trackActivity(req));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivity(
            @RequestHeader("X-User-ID") String userId) {
        return ResponseEntity.ok(activityService.getUserActivity(userId));
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getUserActivityById(
            @PathVariable String activityId) {
        return ResponseEntity.ok(activityService.getActivityById(activityId));
    }

}
