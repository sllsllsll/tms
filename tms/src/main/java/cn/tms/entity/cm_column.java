package cn.tms.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linlin on 2017/11/6.
 */
public class cm_column {

    private String syscode;
    private int columncode;
    private String columnname;
    private int sort;
    private String parentcode;
    private int status;
    private String remark;

    private String  parent; //父权限对象
    //子权限集合
    private List<cm_column> children=new ArrayList<cm_column>();

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<cm_column> getChildren() {
        return children;
    }

    public void setChildren(List<cm_column> children) {
        this.children = children;
    }

    public String getSyscode() {
        return syscode;
    }

    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

    public int getColumncode() {
        return columncode;
    }

    public void setColumncode(int columncode) {
        this.columncode = columncode;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
