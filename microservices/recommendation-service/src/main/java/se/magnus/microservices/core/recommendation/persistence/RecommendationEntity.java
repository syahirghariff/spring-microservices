package se.magnus.microservices.core.recommendation.persistence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Chapter 6: Entity class
 * '@Document' @Id @Version documentations available at ProductEntity.java
 */

@Document(collection = "recommendations")
// Chapter 6: Unique compound index is created
@CompoundIndex(name = "prod-rec-id", unique = true, def = "{'productId': 1, 'recommendationId': 1")
@Data
public class RecommendationEntity {

    @Id
    private String id;
    @Version
    private Integer version;
    private int productId;
    private int recommendationId;
    private String author;
    private int rating;
    private String content;



}
