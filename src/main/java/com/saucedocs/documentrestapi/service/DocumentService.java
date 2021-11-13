package com.saucedocs.documentrestapi.service;

import com.saucedocs.documentrestapi.model.Document;
import com.saucedocs.documentrestapi.repo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepo documentRepo;


    @Autowired
    public DocumentService(DocumentRepo documentRepo) {
        this.documentRepo = documentRepo;
    }

    public List<Document> getDocuments() {
        return documentRepo.findAll();
    }

    public void addNewDocument(Document document) {
        documentRepo.save(document);
    }

    public void deleteDocument(String documentId) {
        boolean exist = documentRepo.existsById(documentId);
        if (!exist) {
            throw new IllegalStateException("student with " + documentId + " dose not exist");
        }
        documentRepo.deleteById(documentId);
    }

    public Optional<Document> getDocumentById(String documentId) {
        return documentRepo.findById(documentId);

    }
}