package model;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

/**
 * The model of Accounts Responsibility record -> one admin for 1 or more accounts records
 * starting with non-recursive model for the simplicity example -> going to be tree structured recursive model
 */
@Entity("accounts")
public class AccountRecord extends BaseEntity {

    private String accountsName;
    private String adminName;

    @Embedded
    private Block creditBlock;

    private int moneyChannel;

    private String additionalNotes;

    public AccountRecord(){

    }

    public AccountRecord(String accountsName, String adminName, Block creditBlock, int moneyChannel, String additionalNotes) {
        this.accountsName = accountsName;
        this.adminName = adminName;
        this.creditBlock = creditBlock;
        this.moneyChannel = moneyChannel;
        this.additionalNotes = additionalNotes;
    }

    public String getAccountsName() {
        return accountsName;
    }

    public void setAccountsName(String accountsName) {
        this.accountsName = accountsName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Block getCreditBlock() {
        return creditBlock;
    }

    public void setCreditBlock(Block creditBlock) {
        this.creditBlock = creditBlock;
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

    @Override
    public String toString() {
        return "AccountRecord{" +
                "accountsName='" + accountsName + '\'' +
                ", adminName='" + adminName + '\'' +
                ", creditBlock=" + creditBlock +
                ", moneyChannel=" + moneyChannel +
                ", additionalNotes='" + additionalNotes + '\'' +
                ", id=" + id +
                '}';
    }

}
