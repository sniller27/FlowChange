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
public class Strategy_10Percent implements PriceStrategy {

    int price = 180;
    int amount = 40;
    
    
    @Override
    public int calculateNewPrice() {
        
        price = price + ((price*10)/100);
        
        
        return price;
        
    }

    @Override
    public int calculateNewQty() {
        
        amount = amount + ((amount*10)/100);
        
        return amount;
    }
    
    
    
    
}
