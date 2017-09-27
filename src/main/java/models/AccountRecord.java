package models;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

import java.util.List;

/**
 * The models of Accounts Responsibility record -> one admin for 1 or more accounts records
 * starting with non-recursive models for the simplicity example -> going to be tree structured recursive models
 */
@Entity("accounts")
public class AccountRecord extends BaseEntity {

    private String accountName;
    private String adminName;

    private int minValue;
    private int maxValue;

    private int moneyChannel;

    private String additionalNotes;

    @Reference
    private List<AccountRecord> supervisedAccounts;

    public AccountRecord(){

    }

    public AccountRecord(String accountName, String adminName, int minValue, int maxValue, int moneyChannel, String additionalNotes, List<AccountRecord> supervisedAccounts) {
        this.accountName = accountName;
        this.adminName = adminName;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.moneyChannel = moneyChannel;
        this.additionalNotes = additionalNotes;
        this.supervisedAccounts = supervisedAccounts;
    }

    public String getAccountsName() {
        return accountName;
    }

    public void setAccountsName(String accountsName) {
        this.accountName = accountsName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMoneyChannel(int moneyChannel) {
        this.moneyChannel = moneyChannel;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getAdminName() {
        return adminName;
    }

    public int getMoneyChannel() {
        return moneyChannel;
    }

    public List<AccountRecord> getSupervisedAccounts(){
        return supervisedAccounts;
    }

    @Override
    public String toString() {
        return "AccountRecord{" +
                "accountsName='" + accountName + '\'' +
                ", adminName='" + adminName + '\'' +
                ", minValue=" + minValue + '\'' +
                ", maxValue=" + maxValue + '\'' +
                ", moneyChannel=" + moneyChannel +
                ", additionalNotes='" + additionalNotes + '\'' +
                ", id=" + id + supervisedAccounts.stream().map(s->s.toString()).reduce("" , (a , b) -> a + b) +
                '}';
    }

}
