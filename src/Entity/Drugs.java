/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Control.PriceStrategy;

/**
 *
 * @author Soren
 */
public class Drugs {

    private String type;
    private int BASE_PRICE;
    private int BASE_QTY;
    private int my_qty;
    private int current_price;
    private int current_qty;
    private PriceStrategy priceStrategy;

    public Drugs(String type, int BASE_PRICE, int BASE_QTY, int my_qty, int current_price, int current_qty, PriceStrategy priceStrategy) {
        this.type = type;
        this.BASE_PRICE = BASE_PRICE;
        this.BASE_QTY = BASE_QTY;
        this.my_qty = my_qty;
        this.current_price = current_price;
        this.current_qty = current_qty;
        this.priceStrategy = priceStrategy;

        calculateNewPrice();
        calculateNewQty();
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBASE_PRICE() {
        return BASE_PRICE;
    }

    public void setBASE_PRICE(int BASE_PRICE) {
        this.BASE_PRICE = BASE_PRICE;
    }

    public int getBASE_QTY() {
        return BASE_QTY;
    }

    public void setBASE_QTY(int BASE_QTY) {
        this.BASE_QTY = BASE_QTY;
    }

    public int getMy_qty() {
        return my_qty;
    }

    public void setMy_qty(int my_qty) {
        this.my_qty = my_qty;
    }

    public int getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(int current_price) {
        this.current_price = current_price;
    }

    public int getCurrent_qty() {
        return current_qty;
    }

    public void setCurrent_qty(int current_qty) {
        this.current_qty = current_qty;
    }

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public void calculateNewPrice() {
        BASE_PRICE = priceStrategy.calculateNewPrice();
    }

    public void calculateNewQty() {
        BASE_QTY = priceStrategy.calculateNewQty();
    }

    @Override
    public String toString() {
        return "Drugs{" + "type=" + type + ", BASE_PRICE=" + BASE_PRICE + ", BASE_QTY=" + BASE_QTY + ", my_qty=" + my_qty + ", current_price=" + current_price + ", current_qty=" + current_qty + ", priceStrategy=" + priceStrategy + '}';
    }

}
