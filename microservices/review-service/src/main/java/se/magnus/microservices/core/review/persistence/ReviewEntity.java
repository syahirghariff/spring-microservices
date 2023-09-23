package se.magnus.microservices.core.review.persistence;

import javax.persistence.*;

/**
 * Chapter 6: Entity class
 * @Id @Version explained in ProductEntity.java
 */
// Chapter 6: @Entity @Table to mark the class as entity class used for JPA
@Entity
// Chapter 6: Unique compound index to be created for the compound business key
@Table(name="reviews",
        indexes = {
            @Index(name="review_unique_idx", unique = true, columnList = "productId, reviewId")
        })
public class ReviewEntity {

    @Id @GeneratedValue
    private int id;

    @Version
    private int version;
    private int productId;
    private int reviewId;
    private String author;
    private String subject;
    private String content;
}
