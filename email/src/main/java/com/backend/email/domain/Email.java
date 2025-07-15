package com.backend.email.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "emails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    private UUID id;
    private UUID from;
    private UUID to;
    private String subject;

    @Column(columnDefinition = "BODY")
    private String body;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
