package QuanLyNhanVien;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Nhập số lượng nhân viên: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin nhân viên thứ " + (i + 1));
            System.out.println("Chọn loại nhân viên (1. Developer | 2. Tester | 3. BA): ");
            int loai = sc.nextInt();
            sc.nextLine(); // bỏ qua dòng trống

            System.out.print("Nhập ID: ");
            String id = sc.nextLine();
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("Nhập lương cơ bản: ");
            double baseSalary = sc.nextDouble();

            Employee e = null;

            switch (loai) {
                case 1:
                    System.out.print("Nhập số dự án: ");
                    int soDuAn = sc.nextInt();
                    e = new Developer(id, name, baseSalary, soDuAn);
                    break;
                case 2:
                    System.out.print("Nhập số lỗi phát hiện: ");
                    int soLoi = sc.nextInt();
                    e = new Tester(id, name, baseSalary, soLoi);
                    break;
                case 3:
                    System.out.print("Nhập số khách hàng: ");
                    int soKH = sc.nextInt();
                    e = new BA(id, name, baseSalary, soKH);
                    break;
                default:
                    System.out.println("Loại không hợp lệ, bỏ qua nhân viên này!");
                    break;
            }

            if (e != null) {
                employees.add(e);
            }
        }

        // In danh sách
        System.out.println("\n=== DANH SÁCH NHÂN VIÊN ===");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Tính và in nhân viên có lương cao hơn trung bình
        inNhanVienLuongCaoHonTrungBinh(employees);

        // Tính tổng chi phí lương (thêm 10%)
        tinhTongChiPhi(employees);

        sc.close();
    }

    public static void inNhanVienLuongCaoHonTrungBinh(ArrayList<Employee> employees) {
        double tongLuong = 0;
        for (Employee e : employees) {
            tongLuong += e.tinhLuong();
        }

        double luongTB = tongLuong / employees.size();
        System.out.println("\nMức lương trung bình: " + luongTB);
        System.out.println("Nhân viên có lương cao hơn trung bình:");

        for (Employee e : employees) {
            if (e.tinhLuong() > luongTB) {
                System.out.println(e);
            }
        }
    }

    public static void tinhTongChiPhi(ArrayList<Employee> employees) {
        double tong = 0;
        for (Employee e : employees) {
            tong += e.tinhLuong();
        }
        double tongChiPhi = tong * 1.1; // thêm 10% thưởng trung bình
        System.out.println("\nTổng chi phí lương (gồm thưởng 10%): " + tongChiPhi);
    }
}
