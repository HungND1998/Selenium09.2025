package QuanLyNhanVien;

public class BA extends Employee {
    private int soKhachHang;

    public BA(String id, String name, double baseSalary, int soKhachHang) {
        super(id, name, baseSalary);
        this.soKhachHang = soKhachHang;
    }

    @Override
    public double tinhLuong() {
        return baseSalary + soKhachHang * 300000;
    }
}
