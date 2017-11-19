package cn.happy.hibernate16manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linlin on 2017/10/11.
 */
@Entity
@Table(name="GameNew")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sql_Game")
    @SequenceGenerator(name="sql_Game",sequenceName = "sql_Game",allocationSize = 1,initialValue = 1)
    private  Integer gid;
    @Column
    private  String gname;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="PGNew",joinColumns ={@JoinColumn(name="gid")},
            inverseJoinColumns = {@JoinColumn(name="pid")})
    private Set<Player> player=new HashSet<Player>();

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

    public Set<Player> getPlayer() {
        return player;
    }

    public void setPlayer(Set<Player> player) {
        this.player = player;
    }
}
