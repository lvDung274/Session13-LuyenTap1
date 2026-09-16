package vn.edu.rikkei.Session13.LuyenTap1;

import vn.edu.rikkei.Session13.ex4.Product;

import java.util.List;

public class CartService {
    public void removeOutOfStock(List<Product> cart) {
        if (cart == null || cart.isEmpty()) {
            return;
        }
        cart.removeIf(p -> p.getQuantity() == 0);
}
