package com.example.prueba_tecnica_stefanini.infrastructure.adapters.output;

import com.example.prueba_tecnica_stefanini.application.ports.output.PetExternalService;
import com.example.prueba_tecnica_stefanini.domain.model.Pet;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.request.PetRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class PetExternalAdapter implements PetExternalService {
    private final RestTemplate restTemplate;

    public PetExternalAdapter(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Pet getPetById(Long petId){
        String urlPet = "https://petstore.swagger.io/v2/pet/" + petId;
        return restTemplate.getForObject(urlPet, Pet.class);
    }

    @Override
    public Pet createPet(PetRequestDTO requestDTO){
        String urlPet = "https://petstore.swagger.io/v2/pet";
        return restTemplate.postForObject(urlPet, requestDTO, Pet.class);
    }
}
