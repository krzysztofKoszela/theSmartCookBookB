package com.krzysztof.koszela.innowacyjnaksiazkakucharska;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;
import javax.persistence.CascadeType;

/*@EntityListeners(AuditingEntityListener.class)*/
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "RECIPE")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rec_id;

    @Column(nullable = false)
    private String rec_name;
    @Column(nullable=false)
    private String prep_descript;
    @Column(nullable=false)
    private Integer prep_time;
    @Column(nullable = false)
    private String ingredient_text;
    @Column
    private String diff_lv;
    @Column
    private Integer rating;
    @Column
    private Timestamp load_dte;
    @Lob
    @Column
    private byte[] rec_picture;
    /*skladniki oraz kategorie*/

    public Long getRec_id() {
        return rec_id;
    }

    public void setRec_id(Long rec_id) {
        this.rec_id = rec_id;
    }

    public String getRec_name() {
        return rec_name;
    }

    public void setRec_name(String rec_name) {
        this.rec_name = rec_name;
    }

    public String getPrep_descript() {
        return prep_descript;
    }

    public void setPrep_descript(String prep_descript) {
        this.prep_descript = prep_descript;
    }

    public Integer getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(Integer prep_time) {
        this.prep_time = prep_time;
    }

    public String getIngredient_text() {
        return ingredient_text;
    }

    public void setIngredient_text(String ingredient_text) {
        this.ingredient_text = ingredient_text;
    }

    public String getDiff_lv() {
        return diff_lv;
    }

    public void setDiff_lv(String diff_lv) {
        this.diff_lv = diff_lv;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Timestamp getLoad_dte() {
        return load_dte;
    }

    public void setLoad_dte(Timestamp load_dte) {
        this.load_dte = load_dte;
    }

    public byte[] getRec_picture() {
        return rec_picture;
    }

    public void setRec_picture(byte[] rec_picture) {
        this.rec_picture = rec_picture;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Recipe() {}

    public Recipe(String rec_name,String prep_descript,String diff_lv,Integer prep_time,String ingredient_text, Timestamp load_dte,Set<Category> categories,Set<Ingredient> ingredients){
        this.rec_name = rec_name;
        this.prep_descript = prep_descript;
        this.prep_time = prep_time;
        this.diff_lv = diff_lv;
        this.ingredient_text = ingredient_text;
        this.rating = rating;
        this.load_dte = load_dte;
        this.rec_picture = rec_picture;
        this.categories = categories;
        this.ingredients = ingredients;
    }

   @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "rel_cat_rec",
            joinColumns = { @JoinColumn(name = "rec_id") },
            inverseJoinColumns = { @JoinColumn(name = "cat_id") })
    private Set<Category> categories = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "rel_ing_rec",
            joinColumns = { @JoinColumn(name = "rec_id") },
            inverseJoinColumns = { @JoinColumn(name = "ing_id") })
    private Set<Ingredient> ingredients = new HashSet<>(0);
/*
    @ManyToMany(targetEntity=Category.class,mappedBy = "recipe", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name = "rel_cat_rec", joinColumns = { @JoinColumn(name = "rec_id") }, inverseJoinColumns = { @JoinColumn(name = "cat_id") })
    public Set<Category> getCategories() {
        return this.categories;
    }
*/
}
