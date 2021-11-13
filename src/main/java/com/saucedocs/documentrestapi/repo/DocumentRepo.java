package com.saucedocs.documentrestapi.repo;

import com.saucedocs.documentrestapi.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepo extends MongoRepository<Document, String> {
}