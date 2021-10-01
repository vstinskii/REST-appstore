package com.vitaliy.appstore.model.dao;

import com.vitaliy.appstore.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
