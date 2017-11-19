package cn.happy.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 张晓宇 on 2017/10/13.
 */
@Entity
@Table
public class Subjects {
    //id,title,totalvotes,viewtimes,createdate
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private Integer totalvotes;
    private Integer viewtimes;

    @Column(columnDefinition="date")
    private Date createdate;

    @OneToMany(mappedBy="subjects",targetEntity=Options.class,fetch=FetchType.EAGER)
    @OrderBy(value="id")
    private Set<Options> options=new HashSet<Options>();

    public Set<Options> getOptions() {
        return options;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalvotes() {
        return totalvotes;
    }

    public void setTotalvotes(Integer totalvotes) {
        this.totalvotes = totalvotes;
    }

    public Integer getViewtimes() {
        return viewtimes;
    }

    public void setViewtimes(Integer viewtimes) {
        this.viewtimes = viewtimes;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
