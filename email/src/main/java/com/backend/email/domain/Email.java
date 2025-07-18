package com.backend.email.domain;

import com.backend.email.enums.EmailStatus;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userId;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String body;
    private EmailStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
