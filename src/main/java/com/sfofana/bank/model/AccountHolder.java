package com.sfofana.bank.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class AccountHolder {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String title;
    private String address;
    private String dob;
    private Integer ssn;
    private String activeDate;
    private String email;
    private String password;
    private boolean loggedin;
    @OneToMany
    private List<Account> accounts;

    public AccountHolder(Integer id, String firstname, String lastname, String title, String address, String dob,
            Integer ssn, String activeDate, String email, String password, boolean loggedin, List<Account> accounts) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.address = address;
        this.dob = dob;
        this.ssn = ssn;
        this.activeDate = activeDate;
        this.email = email;
        this.password = password;
        this.loggedin = loggedin;
        this.accounts = accounts;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getSsn() {
        return this.ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getActiveDate() {
        return this.activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedin() {
        return this.loggedin;
    }

    public boolean getLoggedin() {
        return this.loggedin;
    }

    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "{" + " id='" + id + "'" + ", firstname='" + firstname + "'" + ", lastname='" + lastname + "'"
                + ", title='" + title + "'" + ", address='" + address + "'" + ", dob='" + dob + "'" + ", ssn='" + ssn
                + "'" + ", activeDate='" + activeDate + "'" + ", email='" + email + "'" + ", password='" + password
                + "'" + ", loggedin='" + loggedin + "'" + ", accounts='" + accounts + "'" + "}";
    }

}
