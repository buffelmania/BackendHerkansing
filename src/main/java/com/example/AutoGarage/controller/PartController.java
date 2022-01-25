package com.example.AutoGarage.controller;


import com.example.AutoGarage.entity.Part;
import com.example.AutoGarage.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("")
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }


    @GetMapping("/{partId")
    public Part getPart(@PathVariable("partId") Long partId) {
        return partService.getPart(partId);
    }

}



