package HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.model;

import HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.service.ProductService;

import java.security.spec.EdECPoint;
import java.util.Scanner;

public class CartItem {
    private int cartItemId;
    private Product product;
    private double price;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int cartItemId, double price, Product product, int quantity) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner sc) {


        this.cartItemId = autoCartItemId();
        this.product = inputProductOfCart(sc);
        this.price = this.product.getProductPrice();
        this.quantity = inputQuantity(sc);
    }

    public int inputQuantity(Scanner sc) {
        System.out.println("Nhập số lượng sản phẩm");
      do {
          int quantity = Integer.parseInt(sc.nextLine());
          if(quantity < 0){
              System.err.println("số lương phải lớn hơn 0!");
          }else {
              return quantity;
          }
      }while (true);
    }

    public Product inputProductOfCart(Scanner sc) {
        for(Product pro: ProductService.productList){
            System.out.println(pro.toString());
        }
        System.out.println("Nhập Id sản phẩm muốn thêm vào giỏ hàng:");
        do {
            String productId = sc.nextLine();
            Product newProduct = null;
            for(Product pro: ProductService.productList){
                if(pro.getProductId().equals(productId)){
                    newProduct = pro;
                    break;
                }
            }
            if(newProduct == null){
                System.err.println("Id không đúng!");
            }else {
                return newProduct;
            }
        }while (true);
    }

    public int autoCartItemId() {
        int max = 0;
        for (CartItem ca : CartService.cartItemList) {
            if (ca.getCartItemId() > max) {
                max = ca.getCartItemId();
            }
        }
        return max + 1;
    }

    public void displayData() {
        System.out.printf("Mã: %d - Tên: %s - Giá: %f - Số lượng: %d \n",
                this.cartItemId, this.product, this.price, this.quantity);
    }
}
