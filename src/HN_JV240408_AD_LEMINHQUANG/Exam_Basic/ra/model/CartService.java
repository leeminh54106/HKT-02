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
        System.out.println("nhập mã sản phẩm để thêm sản phẩm:");
        String idProduct = sc.nextLine();
        int indexItem = findIndexById(idProduct);
        if (indexItem < 0) {
            System.err.println("Mã sản phẩm không tồn tại!");
        } else {
            CartItem newCartItem = new CartItem();
            newCartItem.inputData(sc);
            cartItemList.add(newCartItem);
        }

    }


    public int findIndexById(String idProduct) {
        for (int i = 0; i < ProductService.productList.size(); i++) {
            if (ProductService.productList.get(i).getProductId().equals(idProduct)) {
                return i;
            }
        }
        return -1;
    }

    public void showCart(){
        if (cartItemList.isEmpty()) {
            System.err.println("Giỏ hàng rỗng");
        }
        for(CartItem cartItem : cartItemList){
           cartItem.displayData();
        }
    }


}
