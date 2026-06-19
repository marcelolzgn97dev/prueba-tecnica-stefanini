package com.example.prueba_tecnica_stefanini.infrastructure.adapters.input;

import com.example.prueba_tecnica_stefanini.application.ports.input.PetService;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.request.PetRequestDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.response.PetCreationResponseDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.response.PetResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/pet")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping("{petId}")
    public ResponseEntity<PetResponseDTO> getPet(@PathVariable Long petId){
        return ResponseEntity.ok(petService.getPetById(petId));
    }


    @PostMapping()
    public ResponseEntity<PetCreationResponseDTO> createPet(
            @RequestBody PetRequestDTO requestDTO){
        return ResponseEntity.ok(petService.createPet(requestDTO));
    }
}
