package cn.happy.hql;

import java.util.Date;

/**
 * Created by linlin on 2017/9/24.
 */
public class News {
    private Integer nid;
    private String ntitle;
    private String ncontent;
    private Date ndate;

    public News() {
    }

    public News(Integer nid, String ntitle) {
        this.nid = nid;
        this.ntitle = ntitle;
    }

    public News(Integer nid, String ntitle, String ncontent, Date ndate) {
        this.nid = nid;
        this.ntitle = ntitle;
        this.ncontent = ncontent;
        this.ndate = ndate;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }
}
