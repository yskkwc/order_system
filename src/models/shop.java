package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "shops")
@NamedQueries({
    @NamedQuery(
            name = "getAllShops",
            query = "SELECT s FROM Shop AS s ORDER BY s.id DESC"
            ),
    @NamedQuery(
            name = "getShopsCount",
            query = "SELECT COUNT(s) FROM Shop AS s"
            ),
    @NamedQuery(
            name = "checkRegisteredNameAndPassword",
            query = "SELECT s FROM Shop AS s WHERE s.name = :name AND s.password = :pass"
            ),

    @NamedQuery(name = "getMyAllShops", query = "SELECT s FROM Shop "
            + "AS s WHERE s.name = :name ORDER BY s.id DESC"),

    @NamedQuery(name = "getMyShopsCount", query = "SELECT COUNT(s) FROM Shop "
            + "AS s WHERE s.name = :name"),
})

@Entity
public class Shop {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "denwa", nullable = false)
    private String denwa;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "area", nullable = false)
    private Integer area;

    @Lob
    @Column(name = "info", nullable = true)
    private String info;

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

    public String getDenwa() {
        return denwa;
    }

    public void setDenwa(String denwa) {
        this.denwa = denwa;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
