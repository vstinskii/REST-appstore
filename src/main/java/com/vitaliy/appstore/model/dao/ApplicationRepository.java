package com.vitaliy.appstore.model.dao;

import com.vitaliy.appstore.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query(value = "SELECT COUNT(*) FROM application WHERE content_rate=:contentRate", nativeQuery = true)
    int getCountOfApplicationByContentRate(@Param("contentRate") int contentRate);
    
}
