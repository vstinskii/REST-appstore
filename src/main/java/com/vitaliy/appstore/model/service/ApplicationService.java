package com.vitaliy.appstore.model.service;

import com.vitaliy.appstore.model.entity.Application;

import java.util.List;

public interface ApplicationService {

    void saveApplication(Application application);

    Application getApplicationById(int id);

    List<Application> getAllApplication();

    void deleteApplicationById(int id);

    Application applicationsCompare(int[] ids);

    int getCountOfApplicationByContentRate(int contentRate);
}
