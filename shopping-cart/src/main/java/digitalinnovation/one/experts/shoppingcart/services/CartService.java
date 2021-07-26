package digitalinnovation.one.experts.shoppingcart.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digitalinnovation.one.experts.shoppingcart.model.Cart;
import digitalinnovation.one.experts.shoppingcart.model.Item;
import digitalinnovation.one.experts.shoppingcart.repository.CartRepository;

@Service
public class CartService {

  @Autowired
  private CartRepository cartRepository;

  public Cart save(Integer id, Item item) {
    Optional<Cart> cartExists = this.cartRepository.findById(id);
    Cart cart;

    if (cartExists.equals(Optional.empty())) {
      cart = new Cart(id);
    }

    cart = cartExists.get();
    cart.getItems().add(item);

    return this.cartRepository.save(cart);
  }

  public Optional<Cart> listById(Integer id) {
    return this.cartRepository.findById(id);
  }

  public void delete(Integer id) {
    this.cartRepository.deleteById(id);
  }
}
