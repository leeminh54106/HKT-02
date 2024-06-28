package HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.model;

import java.util.Scanner;

public class CartItem {
    private int cartItemId;
    private String product;
    private double price;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int cartItemId, double price, String product, int quantity) {
        this.cartItemId = cartItemId;
        this.price = price;
        this.product = product;
        this.quantity = quantity;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner sc) {
//        private int cartItemId;
//        private String product;
//        private double price;
//        private int quantity;
        System.out.println("Nhập mã sản phẩm:");
        this.cartItemId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sản phẩm:");
        this.product = sc.nextLine();
        System.out.println("Nhập giá sản phẩm:");
        this.price = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập số lượng sản phẩm:");
        this.quantity = Integer.parseInt(sc.nextLine());
    }

    public void displayData() {
        System.out.printf("Mã: %d - Tên: %s - Giá: %f - Số lượng: %d \n",
                this.cartItemId, this.product, this.price, this.quantity);
    }
}
