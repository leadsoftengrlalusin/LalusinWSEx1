package org.gcash.training.codes.controller;

import org.gcash.training.codes.model.Sailor;
import org.gcash.training.codes.repository.SailorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sailors")
public class SailorController {

    private final SailorRepository repository;

    public SailorController(SailorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Sailor> getAllSailors() {
        return repository.findAll();
    }
}
