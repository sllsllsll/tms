package cn.happy.hibernate1001manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/10/1.
 */
@Entity(name="PlayHome")
public class PlayHome {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sql_Play")
    @SequenceGenerator(name = "sql_Play",sequenceName = "sql_Play",allocationSize = 1,initialValue = 1)
    private Integer pid;
    @Column
    private String pname;
    @ManyToMany(cascade = CascadeType.ALL)
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
