package automation.testsuite;

import org.testng.annotations.Test;
import java.util.Scanner;

public class BTVN_Day7 {

    @Test
    public void NhapTenNhanVien() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
        sc.nextLine(); // bỏ dòng trống

        String[] dsNhanVien = new String[n];

        // Nhập danh sách
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập tên nhân viên thứ " + (i + 1) + ": ");
            dsNhanVien[i] = sc.nextLine();
        }

        System.out.println("\nDanh sách nhân viên:");
        // In bằng for-each
        for (String ten : dsNhanVien) {
            System.out.println("- " + ten);
        }

        sc.close();
    }
}
