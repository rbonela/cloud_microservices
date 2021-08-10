package rb.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rb.shoppingcart.model.Cart;
import rb.shoppingcart.model.Item;
import rb.shoppingcart.repository.CartRepository;

import java.util.Optional;


@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addItemtoCart(Long id, Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        }
        else {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public Optional<Cart> findByIdInCart(Long id) {
        return cartRepository.findById(id);
    }

    public void clearIdInCart(Long id) {
        cartRepository.deleteById(id);
    }

}