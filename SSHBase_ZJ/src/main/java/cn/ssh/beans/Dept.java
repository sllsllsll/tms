package cn.ssh.beans;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/13.
 */
@Entity
@Table(name="Dept")
public class Dept {
    @Id
    @GeneratedValue
    private Integer deptno;
    @Column
    private String deptname;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}
