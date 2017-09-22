package model;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Block{
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    private int minValue;

    private int maxValue;
    public Block(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Block(){

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

    @Override
    public String toString() {
        return "Block{" +
                "minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}
