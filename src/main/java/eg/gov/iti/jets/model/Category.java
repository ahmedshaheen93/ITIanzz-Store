package eg.gov.iti.jets.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CATEGORIES")
public class Category {
    /**
     * category id is a unique identifier for the category that Generated automatic
     * by jpa framework
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID", nullable = false)
    private Long categoryId;
    /**
     * category name represent
     */
    @Column(name = "CATEGORY_NAME", nullable = false)
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return Objects.requireNonNullElse(products, new HashSet<>(0));
    }

}
