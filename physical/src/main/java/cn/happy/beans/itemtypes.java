package cn.happy.beans;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/10/18.
 */
@Entity
@Table
public class itemtypes {

    @Id
    @GeneratedValue
    private Integer typeid;
    @Column
    private String typename;
/*    @OneToMany(mappedBy ="its")
    private Set<peitems> pes=new HashSet<peitems>();*/

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
