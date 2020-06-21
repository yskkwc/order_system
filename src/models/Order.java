package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "orders")
@NamedQueries({
    @NamedQuery(
            name = "getAllOrders",
            query = "SELECT o FROM Order AS o ORDER BY o.id DESC"
            ),
    @NamedQuery(
            name = "getAllOrdersCount",
            query = "SELECT COUNT(o) FROM Order AS o"
            ),
    @NamedQuery(name = "getMyAllOrdersReceive", query = "SELECT o FROM Order AS o WHERE o.shop "
            + "= :shop ORDER BY o.id DESC"),

    @NamedQuery(name = "getMyOrdersReceiveCount", query = "SELECT COUNT(o) FROM Order AS o WHERE o.shop "
            + "= :shop"),
})
@Entity
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_date", nullable = false)
    private Timestamp order_date;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "denwa", nullable = false)
    private String denwa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDenwa() {
        return denwa;
    }

    public void setDenwa(String denwa) {
        this.denwa = denwa;
    }

}
