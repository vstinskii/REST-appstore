package com.vitaliy.appstore.model.service.impl;

import com.vitaliy.appstore.model.dao.ApplicationRepository;
import com.vitaliy.appstore.model.entity.Application;
import com.vitaliy.appstore.model.exceptions.ApplicationNotFoundException;
import com.vitaliy.appstore.model.exceptions.BadParametersException;
import com.vitaliy.appstore.model.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Application getApplicationById(int id) {
        Optional<Application> result = applicationRepository.findById(id);

        Application application = null;
        if(result.isPresent()) {
            application = result.get();
        } else {
            throw new ApplicationNotFoundException("Application is not found - " + id);
        }

        return application;
    }

    @Override
    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

    @Override
    public void deleteApplicationById(int id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public Application applicationsCompare(int[] ids) {

        if(ids.length < 2) {
            throw new BadParametersException("This request must have 2 ids or more");
        }

        ArrayList<Application> applications = new ArrayList<>();

        for (int applicationsId : ids) {
            applications.add(getApplicationById(applicationsId));
        }

        Collections.sort(applications);

        return applications.get(applications.size()-1);
    }

}
