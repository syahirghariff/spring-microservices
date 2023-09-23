package se.magnus.microservices.core.product.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


/**
 * Chapter 6: PagingAndSortingRepository supports for paging and sorting to the CrudRepository base class
 */
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, String> {

    Optional<ProductEntity> findByProductId(int productId);
}
