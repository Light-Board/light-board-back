package com.lb.lightboard.repository;

import com.lb.lightboard.model.entity.Configuration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
}
