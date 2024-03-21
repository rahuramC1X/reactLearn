package com.rtr.boot.mongoBoot.repsository;

import com.rtr.boot.mongoBoot.dto.ProductDto;
import com.rtr.boot.mongoBoot.entity.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<ProductDto> findByQtyBetween(Range<Double> IdRange);
}
