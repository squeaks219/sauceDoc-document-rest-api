package com.saucedocs.documentrestapi;

import com.saucedocs.documentrestapi.model.Document;
import com.saucedocs.documentrestapi.repo.DocumentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DocumentRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentRestApiApplication.class, args);
    }
}
