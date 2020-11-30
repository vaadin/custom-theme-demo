package com.vaadin.demo.apptheme.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.demo.apptheme.backend.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
