package com.bae.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bae.entity.AuthLog;

public interface LogRepository extends JpaRepository<AuthLog, Long> {

}
