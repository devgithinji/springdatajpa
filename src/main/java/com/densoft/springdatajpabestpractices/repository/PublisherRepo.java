package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Long> {
}
