package com.saucedocs.documentrestapi.model;

import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
@org.springframework.data.mongodb.core.mapping.Document
public class Document {

    @Id
    @Builder.Default
    private String uid = RandomStringUtils.randomNumeric(8);
    @NonNull
    private String title;
    @Builder.Default
    @NonNull
    private String[] images = null;
    private String teacher;
    private String school;
    private String description;
    @NonNull
    private String author;
    @com.mongodb.lang.NonNull
    private int grade;
    @NonNull
    @Builder.Default
    private String[] tags = null;
    @NonNull
    @Builder.Default
    private Boolean ap = false;
    @NonNull
    private String thumbnail;
    private String subject;
    private Views[] views;
    @Builder.Default
    @NonNull
    private LocalDateTime date = LocalDateTime.now();
    private Ratings ratings;
    @Builder.Default
    private String[] attachments = null;

}


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
@org.springframework.data.mongodb.core.mapping.Document
class Views {
    @Id
    @Builder.Default
    private String uid = RandomStringUtils.randomNumeric(8);
    @Builder.Default
    private String user = null;
    @Builder.Default
    @NonNull
    private LocalDateTime date = LocalDateTime.now();

}


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
@org.springframework.data.mongodb.core.mapping.Document
class Ratings {
    @Id
    @Builder.Default
    private String uid = RandomStringUtils.randomNumeric(8);
    private Up[] up;
    @Builder.Default
    private int totalUp = 0;
    private Down[] down;
    @Builder.Default
    private int totalDown = 0;

}


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
@org.springframework.data.mongodb.core.mapping.Document
class Up {
    @Id
    @Builder.Default
    private String uid = RandomStringUtils.randomNumeric(8);
    @NonNull
    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();

}


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Builder
@org.springframework.data.mongodb.core.mapping.Document
class Down {
    @Id
    @Builder.Default
    private String uid = RandomStringUtils.randomNumeric(8);
    @NonNull
    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();

}