package digitalinnovation.one.experts.shoppingcart.repositories;

import org.springframework.data.repository.CrudRepository;

import digitalinnovation.one.experts.shoppingcart.models.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    Cart findByCustomerId(Integer customerId);

}
