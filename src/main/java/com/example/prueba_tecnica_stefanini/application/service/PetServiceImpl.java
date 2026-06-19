package com.example.prueba_tecnica_stefanini.application.service;

import com.example.prueba_tecnica_stefanini.application.ports.input.PetService;
import com.example.prueba_tecnica_stefanini.application.ports.output.PetExternalService;
import com.example.prueba_tecnica_stefanini.domain.model.Pet;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.request.PetRequestDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.response.PetCreationResponseDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.response.PetResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PetServiceImpl implements PetService {
    private final PetExternalService petExternalService;
    private final Logger LOGGER = LoggerFactory.getLogger(PetServiceImpl.class);

    public PetServiceImpl(PetExternalService petExternalService){
        this.petExternalService = petExternalService;
    }

    @Override
    public PetResponseDTO getPetById(Long petId){
        Pet pet = petExternalService.getPetById(petId);

        this.LOGGER.info("Pet fetched successfully: id={}, name={}, status={}",
                pet.getId(),
                pet.getName(),
                pet.getStatus());

        return new PetResponseDTO(
                pet.getId(),
                pet.getName(),
                pet.getStatus()
        );
    }

    @Override
    public PetCreationResponseDTO createPet(PetRequestDTO requestDTO){
        Pet petCreated = petExternalService.createPet(requestDTO);

        this.LOGGER.info("Pet created successfully: id={}, name={}, status={}",
                petCreated.getId(),
                petCreated.getName(),
                petCreated.getStatus());

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
