package cn.happy.hibernate06mapping;

/**
 * Created by linlin on 2017/9/24.
 */
public class Emp {
    private Integer empno;
    private String enmae;

    private Dept dept;

    public Dept getDept() {
        return dept;
    }



    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEnmae() {
        return enmae;
    }

    public void setEnmae(String enmae) {
        this.enmae = enmae;
    }

   }