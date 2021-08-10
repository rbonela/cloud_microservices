package rb.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import rb.shoppingcart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

    Cart findByCustomerId(Integer customerId);

}
