package product.repository.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToOne
    //@JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "phone")
    private String phone;
    @OneToMany(
            mappedBy = "shop",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Employee> employee = new ArrayList<>();

    public Shop() {
    }


    public Shop(String name, Address address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Shop(Integer id, String name, Address address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Shop(Integer shopId) {

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Collection<Employee> getEmployees() {
        return employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(id, shop.id) && Objects.equals(name, shop.name) && Objects.equals(address, shop.address) && Objects.equals(phone, shop.phone) && Objects.equals(employee, shop.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, employee);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", employee=" + employee +
                '}';
    }

}
