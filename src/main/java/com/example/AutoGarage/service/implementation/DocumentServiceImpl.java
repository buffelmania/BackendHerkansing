package com.example.AutoGarage.service.implementation;

import com.example.AutoGarage.entity.Customer;
import com.example.AutoGarage.entity.Document;
import com.example.AutoGarage.repository.DocumentRepository;
import com.example.AutoGarage.service.DocumentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;
    private CustomerServiceImpl customerService;

    public DocumentServiceImpl(DocumentRepository documentRepository, CustomerServiceImpl customerService){
        this.documentRepository = documentRepository;
        this.customerService = customerService;
    }

    @Override
    public List<Document> getAllDocuments(){return documentRepository.findAll();}

//    @Override
//    public Document saveDocuments(Long customerId, Document document){
//        return documentRepository.save(document);
//    }

    @Override
    public Document saveDocuments(Long customerId, MultipartFile file) throws IOException{
        Customer getCustomerForInvoice = customerService.getCustomer(customerId);
        try{
            Document document = new Document(file.getBytes(),getCustomerForInvoice);

            return documentRepository.save(document);

        }catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public Document store(Long customerId, MultipartFile file) throws IOException {
        Customer getCustomerForInvoice = customerService.getCustomer(customerId);
        try{
            Document document = new Document(file.getBytes(),getCustomerForInvoice);

            return documentRepository.save(document);

        }catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }


}
