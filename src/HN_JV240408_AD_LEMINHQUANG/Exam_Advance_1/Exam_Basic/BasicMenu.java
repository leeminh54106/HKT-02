package HN_JV240408_AD_LEMINHQUANG.Exam_Advance_1.Exam_Basic;

import HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.run.CatalogManagement;
import HN_JV240408_AD_LEMINHQUANG.Exam_Basic.ra.run.ProductManagament;

import java.util.Scanner;

public class BasicMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**************************BASIC-MENU**************************\n" +
                    "1. Quản lý danh mục\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Dành cho người dùng (***)\n" +
                    "4. Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    CatalogManagement.catalogMenu(sc);
                    break;
                case 2:
                    ProductManagament.productMenu(sc);
                    break;
                case 3:
                    UserMenu.userMenu(sc);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn từ 1 -> 4");
            }
        }while (true);
    }
}
