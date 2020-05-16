package com.example.restaurant.service;

import com.example.restaurant.domain.dto.IngredientDto;
import com.example.restaurant.domain.Ingredient;
import com.example.restaurant.exception.ElementNotFoundException;
import com.example.restaurant.mapper.IngredientMapper;
import com.example.restaurant.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository repository;

    private final IngredientMapper mapper;

    public Optional<IngredientDto> getIngredientById(Long id) throws Exception {
        return Optional.of(mapper.mapToIngredientDto(repository.findById(id).orElseThrow(ElementNotFoundException::new)));
    }

    public List<IngredientDto> getAllIngredients(){
        return mapper.mapToIngredientDtoList(repository.findAll());
    }

    public Ingredient saveIngredient(IngredientDto ingredient) throws ElementNotFoundException {
        return repository.save(mapper.mapToIngredient(ingredient));
    }

    public void deleteIngredient(Long id){
        repository.deleteById(id);
    }
}
