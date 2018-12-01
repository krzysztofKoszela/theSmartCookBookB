package com.krzysztof.koszela.innowacyjnaksiazkakucharska;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoryController {

    private final
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/Categories")
    public List<Category> getAllCategory() {
        System.out.println(" w get = " + "...");

        return categoryRepository.findAll();
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
