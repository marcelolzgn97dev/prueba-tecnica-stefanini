package com.example.prueba_tecnica_stefanini.infrastructure.dto.response;

import java.time.LocalDateTime;

public class PetCreationResponseDTO {
    private String transactionId;
    private LocalDateTime dateCreated;
    private String status;
    private String name;

    public PetCreationResponseDTO(
            String transactionId,
            LocalDateTime dateCreated,
            String status,
            String name) {
        this.transactionId = transactionId;
        this.dateCreated = dateCreated;
        this.status = status;
        this.name = name;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
}