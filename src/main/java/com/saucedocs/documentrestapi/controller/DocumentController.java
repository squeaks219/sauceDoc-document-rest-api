package com.saucedocs.documentrestapi.controller;

import com.saucedocs.documentrestapi.model.Document;
import com.saucedocs.documentrestapi.repo.DocumentRepo;
import com.saucedocs.documentrestapi.service.DocumentService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/document")
public class DocumentController {

    private final DocumentService documentService;
    public final DocumentRepo documentRepo;

    @Autowired
    public DocumentController(DocumentService documentService, DocumentRepo documentRepo) {
        this.documentService = documentService;
        this.documentRepo = documentRepo;
    }

    @GetMapping("/all")
    public List<Document> getDocuments() {
        return documentService.getDocuments();
    }

    @GetMapping(path = "/findById/{documentId}")
    public Optional<Document> getDocumentById(@PathVariable String documentId) {
       return documentService.getDocumentById(documentId);
    }

    @PostMapping
    public void addNewDocument(@RequestBody Document document) {
        documentService.addNewDocument(document);
    }

    @DeleteMapping(path = "{documentId}")
    public void deleteDocument(@PathVariable("documentId") String documentId) {
        documentService.deleteDocument(documentId);
    }

    @PutMapping(path = "{documentId}")
    public ResponseEntity<Document> updateDocument(
            @PathVariable(value = "documentId") String documentId,
            @Validated @RequestBody Document documentDetails) throws ResourceNotFoundException {
        Document document =  documentRepo.findById(documentId)
                .orElseThrow(() -> new ResourceNotFoundException("Document not found on :: "+ documentId));

        document.setTitle(documentDetails.getTitle());

        final Document updateDocument = documentRepo.save(document);
        return ResponseEntity.ok(updateDocument);
    }
}
