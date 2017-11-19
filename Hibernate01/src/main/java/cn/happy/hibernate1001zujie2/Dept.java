package cn.happy.hibernate1001zujie2;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/10/1.
 */

@Entity(name="Dept02")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Dept {
    @Id
    @GeneratedValue
    private Integer did;
    @Column
    private String dname;
    @OneToMany(mappedBy = "dept",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Emp> emps=new HashSet<Emp>();

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
