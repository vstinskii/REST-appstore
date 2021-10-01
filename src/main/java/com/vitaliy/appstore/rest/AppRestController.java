package com.vitaliy.appstore.rest;

import com.vitaliy.appstore.model.entity.Application;
import com.vitaliy.appstore.model.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppRestController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping("/applications")
    public Application saveApplication(@RequestBody Application application) {

        application.setId(0);

        applicationService.saveApplication(application);

        return application;
    }

    @GetMapping("/applications/{applicationId}")
    public Application getApplicationById(@PathVariable int applicationId) {

        return applicationService.getApplicationById(applicationId);
    }
}
