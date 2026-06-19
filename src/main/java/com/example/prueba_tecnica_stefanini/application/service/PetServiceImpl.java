package com.example.prueba_tecnica_stefanini.application.service;

import com.example.prueba_tecnica_stefanini.application.ports.input.PetService;
import com.example.prueba_tecnica_stefanini.application.ports.output.PetExternalService;
import com.example.prueba_tecnica_stefanini.domain.model.Pet;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.request.PetRequestDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.response.PetCreationResponseDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.response.PetResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PetServiceImpl implements PetService {
    private final PetExternalService petExternalService;

    public PetServiceImpl(PetExternalService petExternalService){
        this.petExternalService = petExternalService;
    }

    @Override
    public PetResponseDTO getPetById(Long petId){
        Pet pet = petExternalService.getPetById(petId);
        //TODO: ESTO LO DEBO DE REEMPLAZAR CIN LOGS
        System.out.println("\n");
        System.out.println("HIIII " + pet.getName());
        System.out.println("\n");

        return new PetResponseDTO(
                pet.getId(),
                pet.getName(),
                pet.getStatus()
        );
    }

    @Override
    public PetCreationResponseDTO createPet(PetRequestDTO requestDTO){
        Pet petCreated = petExternalService.createPet(requestDTO);
        System.out.println("\n");
        System.out.println("SI SE CREI " + petCreated.getName());
        System.out.println("\n");

        String uuid = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();

        return new PetCreationResponseDTO(
                uuid,
                now,
                petCreated.getStatus(),
                petCreated.getName()
        );
    }
}
