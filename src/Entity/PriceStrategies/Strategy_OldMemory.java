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
public class Strategy_OldMemory implements PriceStrategy {

    Random gen = new Random();

    int cocaineprice = 1200;
    int cocaineprice1;
    int randomnumber;
    int therightcocian;
    int cocaineqty = 30;
    int cocaineqty1;
    int therightcocian_qty;

    public boolean plusOrMinus() {

        if (gen.nextInt(2) == 0) {

            return true;
        } else {
        }

        return false;
    }

    @Override
    public int calculateNewPrice() {

        randomnumber = gen.nextInt(55) + 10;

        if (plusOrMinus()) {

            cocaineprice1 = randomnumber * cocaineprice / 100;

            therightcocian = cocaineprice - cocaineprice1 + 75;

            return therightcocian;
        } else {

            cocaineprice1 = randomnumber * cocaineprice / 100;

            therightcocian = cocaineprice + cocaineprice1 + 75;

            return therightcocian;
        }

    }

    @Override
    public int calculateNewQty() {

        randomnumber = gen.nextInt(25) + 10;

        if (plusOrMinus()) {

            cocaineqty1 = randomnumber * cocaineqty / 100;

            therightcocian_qty = cocaineqty - cocaineqty1 + 15;

            return therightcocian_qty;
        } else {

            cocaineqty1 = randomnumber * cocaineqty / 100;

            therightcocian_qty = cocaineqty + cocaineqty1 + 15;

            return therightcocian_qty;
        }

    }

}
