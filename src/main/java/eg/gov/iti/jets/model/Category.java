package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {
    /**
     * category id is a unique identifier for the category
     * that Generated automatic by jpa framework
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
}
