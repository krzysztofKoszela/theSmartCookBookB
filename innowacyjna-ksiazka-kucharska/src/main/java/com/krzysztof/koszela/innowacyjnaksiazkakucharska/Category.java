package com.krzysztof.koszela.innowacyjnaksiazkakucharska;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*@EntityListeners(AuditingEntityListener.class)*/
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id;

    @Column(nullable = false)
    private String cat_name;
    /*skladniki oraz kategorie*/

    @ManyToMany(cascade = {CascadeType.MERGE},fetch= FetchType.EAGER,mappedBy="categories")
    private Set<Recipe> recipes= new HashSet<Recipe>();

    public Category() {
    }
    public Category(String cat_name) {
        this.cat_name = cat_name;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

}
