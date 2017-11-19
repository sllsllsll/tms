package cn.happy.hibernate16manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/10/11.
 */
@Entity
@Table(name="PlayerNew")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sql_Player")
    @SequenceGenerator(name="sql_Player",sequenceName = "sql_Player",allocationSize = 1,initialValue = 1)
    private Integer pid;

    private String pname;
    @ManyToMany(mappedBy = "player")
    private Set<Game> game=new HashSet<Game>();

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Set<Game> getGame() {
        return game;
    }

    public void setGame(Set<Game> game) {
        this.game = game;
    }
}
