package com.krzysztof.koszela.innowacyjnaksiazkakucharska;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/*@EntityListeners(AuditingEntityListener.class)*/
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Ingredient")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ing_id;

    @Column(nullable = false)
    private String ing_name;
    /*skladniki oraz kategorie*/

    @ManyToMany(cascade = {CascadeType.MERGE},fetch= FetchType.EAGER,mappedBy="ingredients")
    private Set<Recipe> recipes= new HashSet<Recipe>();


    public Long getIng_id() {
        return ing_id;
    }

    public void setIng_id(Long ing_id) {
        this.ing_id = ing_id;
    }

    public String getIng_name() {
        return ing_name;
    }

    public void setIng_name(String ing_name) {
        this.ing_name = ing_name;
    }

    public Ingredient(String ing_name) {
        this.ing_name = ing_name;
    }
    public Ingredient() {
    }
}
