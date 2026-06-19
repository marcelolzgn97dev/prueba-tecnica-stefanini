package com.example.prueba_tecnica_stefanini.infrastructure.dto.response;

public class PetResponseDTO {
    private Long id;
    private String name;
    private String status;

    public PetResponseDTO(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
