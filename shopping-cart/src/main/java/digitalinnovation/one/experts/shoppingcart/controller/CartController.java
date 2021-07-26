package digitalinnovation.one.experts.shoppingcart.controller;

import digitalinnovation.one.experts.shoppingcart.model.Cart;
import digitalinnovation.one.experts.shoppingcart.model.Item;
import digitalinnovation.one.experts.shoppingcart.services.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(value = "/{id}")
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        return this.cartService.save(id, item);
    }

    @GetMapping(value = "/{id}")
    public Optional<Cart> listById(@PathVariable("id") Integer id) {
        return this.cartService.listById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.cartService.delete(id);
    }

}
