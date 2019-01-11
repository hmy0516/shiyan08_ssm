package com.ssm.pojo;

public class Transfer {
    private String inAccount;//入账卡号
    private Double balance;//金额

    @Override
    public String toString() {
        return "Transfer{" +
                "inAccount='" + inAccount + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getInAccount() {
        return inAccount;
    }

    public void setInAccount(String inAccount) {
        this.inAccount = inAccount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
