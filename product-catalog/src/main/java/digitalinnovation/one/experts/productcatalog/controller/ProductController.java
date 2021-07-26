package digitalinnovation.one.experts.productcatalog.controller;

import digitalinnovation.one.experts.productcatalog.model.Product;
import digitalinnovation.one.experts.productcatalog.services.ProductService;

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

}
