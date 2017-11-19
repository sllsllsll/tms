package cn.happy.beans;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/18.
 */
@Entity
@Table
public class peitems {

    @Id
    @GeneratedValue
    private Integer itemid;
    @Column
    private String itemname;
    @Column
    private Integer typeid;
    @Column
    private Integer necessary;
    @Column
    private String ref;
    @Column
    private Integer price;
    @Column
    private String info;
    @Column
    private String typename;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

  /*  @ManyToOne
    private itemtypes its;*/

/*    public itemtypes getIts() {
        return its;
    }

    public void setIts(itemtypes its) {
        this.its = its;
    }*/

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getNecessary() {
        return necessary;
    }

    public void setNecessary(Integer necessary) {
        this.necessary = necessary;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
