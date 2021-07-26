package digitalinnovation.one.experts.productcatalog.repositories;

import org.springframework.data.repository.CrudRepository;

import digitalinnovation.one.experts.productcatalog.models.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByName(String name);

}
