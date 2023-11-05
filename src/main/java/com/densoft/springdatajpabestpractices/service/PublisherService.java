package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.repository.PublisherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepo publisherRepo;

    public void findAllPublishers() {
        publisherRepo.findAll();
    }

    public void fetchAllIdBetween1And3() {
        publisherRepo.fetchAllIdBetween1And3();
    }
}
