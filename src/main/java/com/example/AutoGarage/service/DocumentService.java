package com.example.AutoGarage.service;

import com.example.AutoGarage.entity.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {
    List<Document>getAllDocuments();
//    Document saveDocuments(Long customerId, Document document);
    Document saveDocuments(Long customerId, MultipartFile file) throws IOException;
    Document store(Long customerId, MultipartFile file) throws IOException;
}
