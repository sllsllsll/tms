package cn.happy.beans;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/19.
 */
@Entity
@Table
public class product {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String productname;
    @Column
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
