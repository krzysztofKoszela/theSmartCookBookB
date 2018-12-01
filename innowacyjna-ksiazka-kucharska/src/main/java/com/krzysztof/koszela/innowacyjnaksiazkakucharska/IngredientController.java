package com.krzysztof.koszela.innowacyjnaksiazkakucharska;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IngredientController {

    private final
    IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/Ingredients")
    public List<Ingredient> getAllIngredient() {
        System.out.println(" w get = " + "...");

        return ingredientRepository.findAll();
    }
/*
    //Get one Recipe
    @GetMapping("/Recipes/{REC_ID}")
    public Recipe getRecipeById(@PathVariable Long REC_ID) {
        System.out.println(" Customer with ID = " + REC_ID + "...");

        return categoryRepository.findById(REC_ID).orElseThrow(() -> new ResourceNotFoundException("RECIPE", "REC_ID", REC_ID));
    }
    */
}
