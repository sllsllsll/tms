package cn.happy.hibernateManytoManyDouble;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/9/26.
 */
public class Employee {
    private Integer empid;
    private String ename;
    //员工记忆项目集合
    private Set<Project> pros=new HashSet<Project>();

    public Set<Project> getPros() {
        return pros;
    }

    public void setPros(Set<Project> pros) {
        this.pros = pros;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
