package QuanLyNhanVien;

public class Tester extends Employee {
    private int soLoiPhatHien;

    public Tester(String id, String name, double baseSalary, int soLoiPhatHien) {
        super(id, name, baseSalary);
        this.soLoiPhatHien = soLoiPhatHien;
    }

    @Override
    public double tinhLuong() {
        return baseSalary + soLoiPhatHien * 200000;
    }
}
