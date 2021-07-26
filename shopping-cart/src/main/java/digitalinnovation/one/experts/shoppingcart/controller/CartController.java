package digitalinnovation.one.experts.shoppingcart.controller;

import digitalinnovation.one.experts.shoppingcart.model.Cart;
import digitalinnovation.one.experts.shoppingcart.model.Item;
import digitalinnovation.one.experts.shoppingcart.repository.CartRepository;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable("id") Integer id) {
        cartRepository.deleteById(id);
    }

}
