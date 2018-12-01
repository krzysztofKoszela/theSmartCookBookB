package com.krzysztof.koszela.innowacyjnaksiazkakucharska;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RecipeController {

    private final
    RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    //Get all Recipes
    @GetMapping("/Recipes")
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    //Get one Recipe
    @GetMapping("/Recipes/{REC_ID}")
    public Recipe getRecipeById(@PathVariable Long REC_ID) {
        System.out.println(" Customer with ID = " + REC_ID + "...");

        return recipeRepository.findById(REC_ID).orElseThrow(() -> new ResourceNotFoundException("RECIPE", "REC_ID", REC_ID));
    }

    //Post
    @PostMapping("/Recipes")
    public Recipe createRecipe(@RequestBody Recipe recipe) {


            recipe = recipeRepository.save(new Recipe(recipe.getRec_name(),recipe.getPrep_descript(),recipe.getDiff_lv(),recipe.getPrep_time(),recipe.getIngredient_text(),recipe.getLoad_dte(),recipe.getCategories(),recipe.getIngredients()));
            System.out.println(" w post = " + recipe + "...");

        return recipeRepository.save(recipe);
    }

    //Update a Recipe information
    @PutMapping("/Recipes/{REC_ID}")
    public Recipe updateRecipe(@PathVariable(value = "REC_ID") Long RecipeId, @Valid @RequestBody Recipe RecipeDetails) {
        Recipe Recipe = recipeRepository.findById(RecipeId).orElseThrow(() -> new ResourceNotFoundException("RECIPE", "REC_ID", RecipeId));

        return recipeRepository.save(Recipe);
    }

    // Delete a Recipe
    @DeleteMapping("/Recipes/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable(value = "id") Long RecipeId) {
        Recipe Recipe = recipeRepository.findById(RecipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", RecipeId));

        recipeRepository.delete(Recipe);
        return ResponseEntity.ok().build();
    }
}
