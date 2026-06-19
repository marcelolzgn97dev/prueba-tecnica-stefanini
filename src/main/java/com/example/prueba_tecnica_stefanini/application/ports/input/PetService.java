package com.example.prueba_tecnica_stefanini.application.ports.input;

import com.example.prueba_tecnica_stefanini.infrastructure.dto.request.PetRequestDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.response.PetCreationResponseDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.response.PetResponseDTO;

public interface PetService {
    PetResponseDTO getPetById(Long petId);
    PetCreationResponseDTO createPet (PetRequestDTO requestDto);
}