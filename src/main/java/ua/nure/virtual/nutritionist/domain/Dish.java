package ua.nure.virtual.nutritionist.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "recipe", nullable = false, length = 800)
    private String recipe;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private DishType dishType;

    @ManyToMany
    @JoinTable(name = "ingredient",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> dishes;
}
