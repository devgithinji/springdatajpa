package com.densoft.springdatajpabestpractices.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PublisherServiceTest {

    @Autowired
    private PublisherService publisherService;

    @Test
    void findAllPublishers() {
        publisherService.findAllPublishers();
    }

    @Test
    void fetchAllIdBetween1And3() {
        publisherService.fetchAllIdBetween1And3();
    }
}