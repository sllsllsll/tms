package cn.happy.hibernate13zj;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/11.
 */
@Entity
@Table(name = "Dept1011")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abc")
    @SequenceGenerator(name = "abc", sequenceName = "SEQ_SLL", allocationSize = 1)
/* @GeneratedValue(generator = "uuidGen")
    @GenericGenerator(name="uuidGen",strategy ="uuid")*/
    private Integer deptno;
    @Column(name = "deptname")
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
