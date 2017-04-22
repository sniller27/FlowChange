/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.PriceStrategies;

import Control.PriceStrategy;

/**
 *
 * @author Soren
 */
public class Strategy_SimpleTwoChoice implements PriceStrategy {

    private boolean coin;
    private int one_Price = 90;
    private int two_Price = 300;
    private int one_qty = 50;
    private int two_qty = 180;
    private int icePrice;
    private int icePrice1;

    public Strategy_SimpleTwoChoice() {
        coin = false;
        icePrice = one_Price;
        icePrice1 = one_qty;
    }

    @Override
    public int calculateNewPrice() {

        if (coin) {
            icePrice = one_Price;
            coin = false;
        } else {
            icePrice = two_Price;
            coin = true;
        }
        return icePrice;
    }

    @Override
    public int calculateNewQty() {

        if (!coin) {
            icePrice1 = one_qty;

        } else {
            icePrice1 = two_qty;

        }
        return icePrice1;

    }

}
