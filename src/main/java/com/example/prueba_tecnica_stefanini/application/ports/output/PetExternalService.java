package com.example.prueba_tecnica_stefanini.application.ports.output;

import com.example.prueba_tecnica_stefanini.domain.model.Pet;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.request.PetRequestDTO;

public interface PetExternalService {
    Pet getPetById(Long petId);
    Pet createPet(PetRequestDTO requestDTO);
}
