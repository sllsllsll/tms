package cn.happy.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/10/17.
 */
@Entity
public class DriverSchool {
      @Id
    private Integer id;
      @Column
    private String name;
    @Column
    private Integer cityAreaId;
    @Column
    private String address;
    @Column
    private String phone;
   /* private CityArea cityArea;
    @ManyToOne
    public CityArea getCityArea() {
        return cityArea;
    }

    public void setCityArea(CityArea cityArea) {
        this.cityArea = cityArea;
    }*/

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

    public Integer getCityAreaId() {
        return cityAreaId;
    }

    public void setCityAreaId(Integer cityAreaId) {
        this.cityAreaId = cityAreaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
