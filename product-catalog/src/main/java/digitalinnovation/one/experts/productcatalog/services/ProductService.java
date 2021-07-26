package digitalinnovation.one.experts.productcatalog.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalinnovation.one.experts.productcatalog.models.Product;
import digitalinnovation.one.experts.productcatalog.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product save(Product product) {
    return this.productRepository.save(product);
  }

  public Iterable<Product> listAll() {
    return this.productRepository.findAll();
  }

  public Optional<Product> listById(Integer id) {
    return this.productRepository.findById(id);
  }

  public Iterable<Product> listByName(String name) {
    return this.productRepository.findByName(name);
  }

  public Product update(Product product) {
    return this.productRepository.save(product);
  }

  public void delete(Integer id) {
    this.productRepository.deleteById(id);
  }

}
