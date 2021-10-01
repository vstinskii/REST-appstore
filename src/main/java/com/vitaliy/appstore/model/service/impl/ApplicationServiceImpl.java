package com.vitaliy.appstore.model.service.impl;

import com.vitaliy.appstore.model.dao.ApplicationRepository;
import com.vitaliy.appstore.model.entity.Application;
import com.vitaliy.appstore.model.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }

}
