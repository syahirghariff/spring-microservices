package se.magnus.microservices.core.product.persistence;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Chapter 6: Entity class
 */

// Chapter 6: Annotation to mark the class as entity class in MongoDB, mapped to a collection on MongoDB with name products
@Document(collection = "products")
@Data
public class ProductEntity {

    // Chapter 6: Primary key. Value is not exposed in the API for security purposes.
    @Id
    private String id;

    // Chapter 6: Implement optimistic locking.
    // Allowing Spring Data to verify updates of an entity in the database do not overwrite concurrent update
    // If value in version in DB is higher than value in update request, indicates update is performed on stale data
    // information has been updated by someone else since it was read from the database
    @Version
    private Integer version;

    // Chapter 6: To get unique index created for the business key
    @Indexed(unique = true)
    private int productId;

    private String name;

    private int weight;

    public ProductEntity(int productId, String name, int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }
}
