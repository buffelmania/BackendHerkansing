package com.example.AutoGarage.controller;


import com.example.AutoGarage.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class DocumentController {

private final DocumentService documentService;

@Autowired
    public DocumentController(DocumentService documentService){
    this.documentService = documentService;
}



    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/documents/new/{customerId}")
    public String createDocumentsFrom(@RequestParam("file") MultipartFile file, @PathVariable("customerId") Long customerId) throws IOException {
        documentService.saveDocuments(customerId,file);
        return "documents";
    }



}
