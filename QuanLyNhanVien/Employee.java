package QuanLyNhanVien;

public abstract class Employee {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Hàm trừu tượng để các lớp con tự tính lương
    public abstract double tinhLuong();

    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %s | Lương: %.2f", id, name, tinhLuong());
    }
}
