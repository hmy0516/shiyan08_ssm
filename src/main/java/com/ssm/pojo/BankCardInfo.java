package com.ssm.pojo;

import java.util.Date;

/**
 * @author HMY
 * @date 2018/12/29-23:41
 */
public class BankCardInfo {
    private int bankId;
    private long cardNumber;
    private Date cardDate;
    private double balance;
    private int clientId;

    @Override
    public String toString() {
        return "BankCardInfo{" +
                "bankId=" + bankId +
                ", cardNumber=" + cardNumber +
                ", cardDate=" + cardDate +
                ", balance=" + balance +
                ", clientId=" + clientId +
                '}';
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getCardDate() {
        return cardDate;
    }

    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
