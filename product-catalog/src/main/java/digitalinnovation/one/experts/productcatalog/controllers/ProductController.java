package digitalinnovation.one.experts.productcatalog.controllers;

import digitalinnovation.one.experts.productcatalog.models.Product;
import digitalinnovation.one.experts.productcatalog.services.ProductService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @RequestMapping
    public Iterable<Product> list() {
        return this.productService.listAll();
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.productService.listById(id).orElseThrow());
    }

    @RequestMapping(value = "/name/{name}")
    public Iterable<Product> findByName(@PathVariable("name") String name) {
        return this.productService.listByName(name);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable("id") Integer id, @RequestBody Product product) throws Exception {
        Optional<Product> productExists = this.productService.listById(id);

        if (productExists.isEmpty()) {
            throw new Exception("Product doens't exists!");
        }

        return this.productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(Integer id) {
        this.productService.delete(id);
    }

}
