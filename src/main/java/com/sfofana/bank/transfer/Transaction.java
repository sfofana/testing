package com.sfofana.bank.transfer;

public class Transaction {

    private String email;
    private boolean isLoggedin;
    private Integer holderId;
    private Double amount;
    private Integer accountNumber;
    private String accountName;
    private String reciverEmail;

    public Transaction(String email, boolean isLoggedin, Integer holderId, Double amount, Integer accountNumber,
            String accountName, String reciverEmail) {
        this.email = email;
        this.isLoggedin = isLoggedin;
        this.holderId = holderId;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.reciverEmail = reciverEmail;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsLoggedin() {
        return this.isLoggedin;
    }

    public boolean getIsLoggedin() {
        return this.isLoggedin;
    }

    public void setIsLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }

    public Integer getHolderId() {
        return this.holderId;
    }

    public void setHolderId(Integer holderId) {
        this.holderId = holderId;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getReciverEmail() {
        return this.reciverEmail;
    }

    public void setReciverEmail(String reciverEmail) {
        this.reciverEmail = reciverEmail;
    }

    @Override
    public String toString() {
        return "{" + " email='" + email + "'" + ", isLoggedin='" + isLoggedin + "'" + ", holderId='" + holderId + "'"
                + ", amount='" + amount + "'" + ", accountNumber='" + accountNumber + "'" + ", accountName='"
                + accountName + "'" + ", reciverEmail='" + reciverEmail + "'" + "}";
    }

}
