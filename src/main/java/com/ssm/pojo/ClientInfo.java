package com.ssm.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author HMY
 * @date 2018/12/29-23:44
 */
public class ClientInfo {
    private int clientId;
    private String name;
    private String sex;
    private Date birthday;
    private String idCard;
    private String phoneNumber;
    private List<BankCardInfo> bankCardInfo;

    @Override
    public String toString() {
        return "ClientInfo{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", bankCardInfo=" + bankCardInfo +
                '}';
    }

    public List<BankCardInfo> getBankCardInfo() {
        return bankCardInfo;
    }

    public void setBankCardInfo(List<BankCardInfo> bankCardInfo) {
        this.bankCardInfo = bankCardInfo;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
