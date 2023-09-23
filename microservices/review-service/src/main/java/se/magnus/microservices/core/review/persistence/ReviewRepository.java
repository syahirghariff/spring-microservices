package se.magnus.microservices.core.review.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Chapter 6: Repository
 */
public interface ReviewRepository extends CrudRepository<ReviewEntity, Integer> {

    // Chapter 6: Since SQL databases are transactional, we have to specify the default transaction type—read-only in our case
    @Transactional(readOnly = true)
    List<ReviewEntity> findByProductId(int productId);
}
