/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity.PriceStrategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Soren
 */
public class TEST {
    public static void main(String[] args) {
        
        System.out.println(getExchangeRate("USD", "DKK"));
        
        System.out.println(getExchangeRate("USD", "JPY"));
        
    }
        public static double getExchangeRate(String fromCurrency, String toCurrency)
    {
        double result = 100.0;
        
        try {
            // Open a connection to bloomberg to get exchange rates  
            URL bloombergCurrency = new URL("http://www.bloomberg.com/quote/" + fromCurrency + toCurrency + ":CUR");
            URLConnection bc = bloombergCurrency.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(bc.getInputStream()) );

            String inputLine;  //Used to read in lines from webpage
            boolean found = false;  //Flag set true if the exchange rate is found in all the lines            
            // 1) read in line and if it's not null and the default result has not been changed...
            while ( (inputLine = in.readLine()) != null && result == 100.0) {
                if (found) {  //..2) if found == true then we have got the correct exchange rate
                    result = Double.parseDouble(inputLine);
                }
                //..3) looking for the exchange rate in the lines. It's right after this string
                if (inputLine.trim().equals("<span class=\" price\">")) {
                    found = true;
                }
            }
            in.close(); //DONE. Closing connection.          
            
            if(!found) { System.out.println("Error: Never found the currency you asked for!"); }  //Message if currency not found
        } catch (MalformedURLException ex) {
            System.out.println("MalformedURLException in getExchangeRate(): Invalid URL.");
        } catch (NumberFormatException ex) {
            System.out.println("NumberFormatException in getExchangeRate(): Invalid response from server.");            
        } catch (IOException ex) {
            System.out.println("IOException in getExchangeRate(): Cannot connect to server.");            
        }
        

        return result;
    }
}
