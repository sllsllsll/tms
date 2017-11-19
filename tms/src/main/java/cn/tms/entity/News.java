package cn.tms.entity;

import java.util.Date;

/**
 * Created by linlin on 2017/11/6.
 */
public class News {
    private Integer nid;
    private String ccode;
    private String ntitle;
    private Integer djid;
    private Integer start;
    private  Integer createId;
    private Date updateTime;
    private String onePicPath;
    private String twoPicPath;
    private String Description;
    private cm_column cmColumn;
    private UserInfo user;

    public String getOnePicPath() {
        return onePicPath;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setOnePicPath(String onePicPath) {
        this.onePicPath = onePicPath;
    }

    public String getTwoPicPath() {
        return twoPicPath;
    }

    public void setTwoPicPath(String twoPicPath) {
        this.twoPicPath = twoPicPath;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }


    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public cm_column getCmColumn() {

        return cmColumn;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public void setCmColumn(cm_column cmColumn) {
        this.cmColumn = cmColumn;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public Integer getDjid() {
        return djid;
    }

    public void setDjid(Integer djid) {
        this.djid = djid;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }



    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
