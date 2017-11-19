package cn.happy.hibernate01;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by linlin on 2017/9/22.
 */
public class Cat {
    private Integer id;
    private String name;
    private Integer age;

    public Cat() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
