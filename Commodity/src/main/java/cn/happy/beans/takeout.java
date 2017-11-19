package cn.happy.beans;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.Date;

/**
 * Created by linlin on 2017/10/19.
 */
@Entity
@Table
public class takeout {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer quantity;
    @Column
    private Date outdate;
    @Column
    private String handler;
    @Column
    private Integer productid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}
