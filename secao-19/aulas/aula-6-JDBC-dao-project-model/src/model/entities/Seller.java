package model.entities;

import java.util.Date;
import java.util.Objects;

public class Seller {

    private Integer id;
    private String name;
    private String email;
    private Date birhtDate;
    private Double salary;
    private Department department;

    public Seller() {
    }

    public Seller(Integer id, String name, String email, Date birhtDate, Double salary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birhtDate = birhtDate;
        this.salary = salary;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirhtDate() {
        return birhtDate;
    }

    public void setBirhtDate(Date birhtDate) {
        this.birhtDate = birhtDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birhtDate=" + birhtDate +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
