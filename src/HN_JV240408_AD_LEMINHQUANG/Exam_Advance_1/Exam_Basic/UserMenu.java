package HN_JV240408_AD_LEMINHQUANG.Exam_Advance_1.Exam_Basic;

import HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.model.CartItem;
import HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.model.CartService;

import java.util.Scanner;

public class UserMenu {

    private static final CartService cartService = new CartService();
    public static void userMenu(Scanner sc){
        boolean quit = true;
        do {
            System.out.println("**************************MENU-USER**************************\n" +
                    "1. Xem danh sách sản phẩm\n" +
                    "2. Thêm vào giỏ hàng\n" +
                    "3. Xem tất cả sản phẩm giỏ hàng\n" +
                    "4. Thay đổi số lượng sản phẩm trong giỏ hàng\n" +
                    "5. Xóa 1 sản phẩm trong giỏ hàng\n" +
                    "6. Xóa toàn bộ sản phẩm trong giỏ hàng\n" +
                    "7. Quay lại");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    cartService.showAll();
                    break;
                case 2:
                    cartService.addItem(sc);
                    break;
                case 3:
                    cartService.showCart();
                    break;
                case 4:
                    cartService.updateQuantityById(sc);
                    break;
                case 5:
                    cartService.deleteProductOfCart(sc);
                    break;
                case 6:
                    cartService.deleteAll(sc);
                    break;
                case 7:
                    quit = false;
                    break;
                default:
                    System.err.println("Lựa chọn từ 1 ->7");
            }
        }while (quit);
    }
}
