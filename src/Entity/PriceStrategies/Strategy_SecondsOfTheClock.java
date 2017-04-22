/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.PriceStrategies;

import Control.PriceStrategy;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Soren
 */
public class Strategy_SecondsOfTheClock implements PriceStrategy {

    @Override
    public int calculateNewPrice() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        int calendercount;
        if (cal.get(Calendar.SECOND) == 0) {

            calendercount = 1;

        } else {

            calendercount = cal.get(Calendar.SECOND) * 2;
        }
        return calendercount;

    }

    @Override
    public int calculateNewQty() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        int calendercount = cal.get(Calendar.SECOND);

        return calendercount;

    }

}
