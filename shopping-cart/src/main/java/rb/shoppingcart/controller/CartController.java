package rb.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rb.shoppingcart.model.Cart;
import rb.shoppingcart.model.Item;
import rb.shoppingcart.service.CartService;

import java.util.Optional;


@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Long id, @RequestBody Item item) {
        return cartService.addItemtoCart(id,item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Long id) {
        return cartService.findByIdInCart(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable("id") Long id) {
        cartService.clearIdInCart(id);
    }

}
