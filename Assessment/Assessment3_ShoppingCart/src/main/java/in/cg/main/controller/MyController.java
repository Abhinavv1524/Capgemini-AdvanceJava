package in.cg.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.cg.main.model.CartItem;
import in.cg.main.model.Product;
import in.cg.main.service.CartService;
import in.cg.main.service.ProductService;


@Controller
public class MyController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cartItem", new CartItem());
        return "products";
    }

    @PostMapping("/addToCart")
    public String addToCart(@ModelAttribute CartItem cartItem) {
        Product fullProduct = productService.getProductById(cartItem.getProduct().getId());
        cartItem.setProduct(fullProduct);
        cartService.addToCart(cartItem);
        return "redirect:/viewCart";
    }

    @GetMapping("/viewCart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());
        return "cart";
    }
}