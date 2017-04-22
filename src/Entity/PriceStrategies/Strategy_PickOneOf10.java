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
public class Strategy_PickOneOf10 implements PriceStrategy {

    Random gen = new Random();

    int tennumberlist[] = {150, 230, 180, 2350, 17, 360, 190, 440, 550};
    int tennumberlist2[] = {100, 190, 200000, 2, 95, 30, 165, 185, 250};

    @Override
    public int calculateNewPrice() {

        return tennumberlist[gen.nextInt(9)];
    }

    @Override
    public int calculateNewQty() {
        return tennumberlist2[gen.nextInt(9)];
    }

}
