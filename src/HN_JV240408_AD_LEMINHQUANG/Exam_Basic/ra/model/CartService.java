package HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.model;

import HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartService {
    public static List<CartItem> cartItemList = new ArrayList<>();

    public void showAll() {
        if (ProductService.productList.isEmpty()) {
            System.err.println("Không có sản phẩm!");
            return;
        }
        for (Product product : ProductService.productList) {
            System.out.println(product.toString());
        }
    }

    public void addItem(Scanner sc) {
        CartItem newCartItem = new CartItem();
        newCartItem.inputData(sc);

        CartItem newCartItem1 = null;
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getProduct().getProductId().equals(newCartItem.getProduct().getProductId())) {
                newCartItem1 = cartItem;
                break;
            }
        }
        if (newCartItem1 == null) {
            if (newCartItem.getProduct().getStock() >= newCartItem.getQuantity()) {
                cartItemList.add(newCartItem);
            } else {
                System.err.println("vượt quá số lượng trong kho!");
            }
        } else {
            newCartItem1.setQuantity(newCartItem1.getQuantity() + newCartItem.getQuantity());
        }
        Product changeStock = newCartItem1.getProduct();
        changeStock.setStock(changeStock.getStock() - newCartItem.getQuantity());
    }


    public int findIndexById(String idProduct) {
        for (int i = 0; i < ProductService.productList.size(); i++) {
            if (ProductService.productList.get(i).getProductId().equals(idProduct)) {
                return i;
            }
        }
        return -1;
    }

    public void showCart() {
        if (cartItemList.isEmpty()) {
            System.err.println("Giỏ hàng rỗng");
        }
        for (CartItem cartItem : cartItemList) {
            cartItem.displayData();
        }
    }

    public void updateQuantityById(Scanner sc) {
        System.out.println("Nhập Mã sản phẩn cần thay đổi số lượng:");
        do {
            int cartId = Integer.parseInt(sc.nextLine());
            CartItem cartItem1 = null;
            for (CartItem cartItem : cartItemList) {
                if (cartItem.getCartItemId() == cartId) {
                    cartItem1 = cartItem;
                    break;
                }
            }
            if (cartItem1 == null) {
                System.err.println("Không tìm thấy sản phẩm này!");
            } else {
                System.out.println("Nhập số lượng sản phẩm:");
                int quantity = Integer.parseInt(sc.nextLine());
                cartItem1.setQuantity(quantity);
            }

        } while (true);
    }

    public void deleteProductOfCart(Scanner sc) {
        System.out.println("Nhập Mã giỏ hàng cần xóa:");
        do {
            int cartId = Integer.parseInt(sc.nextLine());
            CartItem newCartItem = null;
            for (CartItem cartItem : cartItemList) {
                if (cartItem.getCartItemId() == cartId) {
                    newCartItem = cartItem;
                    break;
                }
            }
            if (newCartItem == null) {
                System.err.println("Không tồn tại sản phẩm này!");
            } else {
                Product changeStock = newCartItem.getProduct();
                changeStock.setStock(changeStock.getStock() + newCartItem.getQuantity());
                cartItemList.remove(newCartItem);
                break;
            }
        } while (true);
    }

    public void deleteAll(Scanner sc) {
        if (cartItemList.isEmpty()) {
            System.err.println("Giỏ hàng trống!");
            return;
        }
        for (CartItem cartItem : cartItemList) {
            Product changeStock = cartItem.getProduct();
            changeStock.setStock(changeStock.getStock() + cartItem.getQuantity());
        }
        cartItemList.clear();
        System.out.println("Xóa giỏ hàng thành công!");

    }

}
