package model;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Block{

    private int minValue;
    private int maxValue;



    public Block(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Block(){

    }

    @Override
    public String toString() {
        System.out.println(this.getClass().getCanonicalName());
        return "Block{" +
                "minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
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

}
