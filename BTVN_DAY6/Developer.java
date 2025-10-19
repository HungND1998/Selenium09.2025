package QuanLyNhanVien;

public class Developer extends Employee {
    private int soDuAn;

    public Developer(String id, String name, double baseSalary, int soDuAn) {
        super(id, name, baseSalary);
        this.soDuAn = soDuAn;
    }

    @Override
    public double tinhLuong() {
        return baseSalary + soDuAn * 500000;
    }
}
