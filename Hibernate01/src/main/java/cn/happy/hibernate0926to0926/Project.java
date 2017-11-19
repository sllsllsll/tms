package cn.happy.hibernate0926to0926;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/9/24.
 */
public class Project {
    private Integer proid;
    private String proname;
    //记忆员工集合
    Set<Employee> emps=new HashSet<Employee>();

    public Set<Employee> getEmps() {
        return emps;
    }

    public void setEmps(Set<Employee> emps) {
        this.emps = emps;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

}
