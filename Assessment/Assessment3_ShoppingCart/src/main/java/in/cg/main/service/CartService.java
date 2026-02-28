package in.cg.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import in.cg.main.model.CartItem;

@Service
public class CartService {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(CartItem newItem) {

        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == newItem.getProduct().getId()) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                return;
            }
        }

        cartItems.add(newItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }
}