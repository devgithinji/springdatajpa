package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepo extends JpaRepository<Magazine, Long> {
}
