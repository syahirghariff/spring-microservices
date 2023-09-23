package se.magnus.microservices.core.recommendation.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Chapter 6: Repository
 */
public interface RecommendationRepository extends CrudRepository<RecommendationEntity, String> {

    List<RecommendationEntity> findByProductId (int productId);

}
