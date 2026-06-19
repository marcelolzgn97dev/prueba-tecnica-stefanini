package com.example.prueba_tecnica_stefanini.infrastructure.adapters.output;

import com.example.prueba_tecnica_stefanini.application.ports.output.PetExternalService;
import com.example.prueba_tecnica_stefanini.domain.model.Pet;
import com.example.prueba_tecnica_stefanini.infrastructure.dto.request.PetRequestDTO;
import com.example.prueba_tecnica_stefanini.infrastructure.exception.PetCreationException;
import com.example.prueba_tecnica_stefanini.infrastructure.exception.PetNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Component
public class PetExternalAdapter implements PetExternalService {
    private final RestTemplate restTemplate;
    private final String petStoreUrl;

    public PetExternalAdapter(RestTemplate restTemplate, @Value("${external.api.petstore.base-url}") String petStoreUrl){
        this.restTemplate = restTemplate;
        this.petStoreUrl = petStoreUrl;
    }

    @Override
    public Pet getPetById(Long petId){
        try {
        String urlGetPet = petStoreUrl + "/" + petId;
            ResponseEntity<Pet> response = restTemplate.getForEntity(urlGetPet, Pet.class);
            if(response.getBody() == null){
                throw new PetNotFoundException("Pet not found");
            }
        return response.getBody();
        } catch (HttpClientErrorException.NotFound ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Pet createPet(PetRequestDTO requestDTO){
        try {
            ResponseEntity<Pet> response = restTemplate.postForEntity(petStoreUrl, requestDTO, Pet.class);
            if(!response.getStatusCode().is2xxSuccessful()){
                throw new PetCreationException("Failed to create pet in external API.");
            }

            if(response.getBody() == null){
                throw new PetCreationException("Pet creation returned empty response.");
            }
            return response.getBody() ;
        } catch (Exception e) {
            throw new PetCreationException(e.getMessage());
        }

    }
}
