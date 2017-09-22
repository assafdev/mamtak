package models;

public class Account {
    private int id;
    private String area;
    private String name;
    private int sectionMin;
    private int sectionMax;
    private int moneyChannel;
    private Account parentAccount;

    public Account(int id, String area, String name, int sectionMin, int sectionMax, int moneyChannel){
        this.id = id;
        this.area = area;
        this.name = name;
        this.sectionMin = sectionMin;
        this.sectionMax = sectionMax;
        this.moneyChannel = moneyChannel;
    }

    private int getId(){
        return id;
    }

    private String getArea(){
        return area;
    }

    private String getName(){
        return name;
    }

    private int getSectionMin(){
        return sectionMin;
    }

    private int getSectionMax(){
        return sectionMax;
    }

    private int getMoneyChannel(){
        return moneyChannel;
    }

    private Account getParentAccount(){
        return parentAccount;
    }

    private void setArea(String newArea){
        this.area = newArea;
    }

    private void setMoneyChannel(int newMoneyChannel){
        this.moneyChannel = newMoneyChannel;
    }

    private void setParentAccount(Account parentAccount){
        this.parentAccount = parentAccount;
    }


}