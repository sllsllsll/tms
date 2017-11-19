package cn.happy.beans;

import javax.persistence.*;

/**
 * Created by linlin on 2017/10/13.
 */
@Entity
@Table
public class account {
    @Id
    private String account_number;
    @Column
    private String password;
    @Column
    private Integer status;
    @Column
    private Integer balance;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

}
