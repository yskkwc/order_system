package models;

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

@Table(name = "menus")
@NamedQueries({
    @NamedQuery(
            name = "getAllMenus",
            query = "SELECT m FROM Menu AS m ORDER BY m.id DESC"
            ),
    @NamedQuery(
            name = "getMenusCount",
            query = "SELECT COUNT(m) FROM Menu AS m"
            ),
    @NamedQuery(name = "getMyAllMenus", query = "SELECT m FROM Menu AS m WHERE m.shop "
            + "= :shop ORDER BY m.id DESC"),

    @NamedQuery(name = "getMyMenusCount", query = "SELECT COUNT(m) FROM Menu AS m WHERE m.shop "
            + "= :shop"),

    @NamedQuery(name = "getOrderMenus", query = "SELECT s FROM Menu AS s WHERE s.id "
            + "= :shop ORDER BY s.id DESC"),

    @NamedQuery(name = "getOrdersCount", query = "SELECT COUNT(s) FROM Menu AS s WHERE s.id "
            + "= :shop"),
})
@Entity

public class Menu {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "content", nullable = true)
    private String content;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
