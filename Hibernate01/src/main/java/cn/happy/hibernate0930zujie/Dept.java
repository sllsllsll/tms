package cn.happy.hibernate0930zujie;

import javax.persistence.*;

/**
 * Created by linlin on 2017/9/30.
 */
@Entity
@Table(name = "dept2")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", sequenceName = "SEQ_NUM")
    private Integer deptNo;
    private String deptName;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
