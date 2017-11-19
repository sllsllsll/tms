package cn.happy.k_action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * Created by linlin on 2017/10/12.
 */
public class StudentAction extends ActionSupport {
    private String name;
    private int age;
    private Date birth;



    @Override
    public String execute() throws Exception {
        System.out.println(name);
        System.out.println(age);
        System.out.println(birth);
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

}
