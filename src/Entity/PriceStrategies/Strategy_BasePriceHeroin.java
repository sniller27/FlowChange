/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.PriceStrategies;

import Control.PriceStrategy;
import java.util.Random;

/**
 *
 * @author Soren
 */
public class Strategy_BasePriceHeroin implements PriceStrategy {

    Random gen = new Random();

    int heroinprice = 1600;
    int heroinprice1;
    int randomnumber;
    int heroinqty = 15;
    int heroinqty1;

    public boolean plusOrMinus() {

        if (gen.nextInt(2) == 0) {

            return true;
        } else {
        }

        return false;
    }

    @Override
    public int calculateNewPrice() {

        randomnumber = gen.nextInt(85) + 1;

        if (plusOrMinus()) {

            heroinprice1 = randomnumber * heroinprice / 100;

            return heroinprice - heroinprice1;
        } else {

            heroinprice1 = randomnumber * heroinprice / 100;

            return heroinprice + heroinprice1;
        }

    }

    @Override
    public int calculateNewQty() {

        randomnumber = gen.nextInt(35) + 15;

        if (plusOrMinus()) {

            heroinqty1 = randomnumber * heroinqty / 100;

            return heroinqty - heroinqty1;
        } else {

            heroinqty1 = randomnumber * heroinqty / 100;

            return heroinqty + heroinqty1;
        }

    }

}
