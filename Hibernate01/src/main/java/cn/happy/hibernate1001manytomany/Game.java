package cn.happy.hibernate1001manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/10/1.
 */
@Entity(name="Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sql_Game")
    @SequenceGenerator(name = "sql_Game",sequenceName = "sql_Game",allocationSize = 1,initialValue = 1)

    private Integer gid;
    @Column
    private String gname;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "games")
/*    @JoinTable(name="PG",joinColumns = {@JoinColumn(name="gid")},inverseJoinColumns ={@JoinColumn(name="pid")} )*/
    private Set<PlayHome> playHomes=new HashSet<PlayHome>();

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Set<PlayHome> getPlayHomes() {
        return playHomes;
    }

    public void setPlayHomes(Set<PlayHome> playHomes) {
        this.playHomes = playHomes;
    }
}
