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
public class Strategy_BasePriceCrystalMeth implements PriceStrategy {

    Random gen = new Random();

    int crystalmethprice = 800;
    int crystalmethprice1;
    int crystalmethqty = 38;
    int crystalmethqty1;
    int randomnumber;

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

            crystalmethprice1 = randomnumber * crystalmethprice / 100;

            return crystalmethprice - crystalmethprice1;
        } else {

            crystalmethprice1 = randomnumber * crystalmethprice / 100;

            return crystalmethprice + crystalmethprice1;
        }

    }

    @Override
    public int calculateNewQty() {

        randomnumber = gen.nextInt(35) + 15;

        if (plusOrMinus()) {

            crystalmethqty1 = randomnumber * crystalmethqty / 100;

            return crystalmethqty - crystalmethqty1;
        } else {

            crystalmethqty1 = randomnumber * crystalmethqty / 100;

            return crystalmethqty + crystalmethqty1;
        }

    }
}
