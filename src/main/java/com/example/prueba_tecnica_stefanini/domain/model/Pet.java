package com.example.prueba_tecnica_stefanini.domain.model;

public class Pet {
    private Long id;
    private String name;
    private String status;

    public Pet() { }
    public Pet(Long id, String name, String status) {
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
