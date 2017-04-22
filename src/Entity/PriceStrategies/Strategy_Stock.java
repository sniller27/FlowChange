/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.PriceStrategies;

import Control.PriceStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Soren
 */
public class Strategy_Stock implements PriceStrategy {

    /**
     * The class contains helper method to get prices (stock quotes) for stocks.
     *
     * Example of use:
     *
     *       //Create a new ArrayList to hold stock names: ArrayList<String>
     * stockNames = new ArrayList(); //Adding stock names stockNames.add("Z");
     * //Zillow stockNames.add("GOOG"); //Google.com stockNames.add("MSDN");
     * //Microsoft
     *
     *       //New ArrayList to hold the answer: ArrayList<Double> result; result =
     * StockFinder.getStockData(stockNames); //Getting the answer
     *
     *       //Running through the answer arraylist for (Double price : result) {
     * System.out.println("Price: " + price); }
     *
     * @author Peter Lorensen
     */
    /**
     * The method gets a list of stock names and returns the price for each one.
     *
     * @param stockShortNames ArrayList<String> of stock names. These must be
     * the short names used by NASDAQ (like GOOG for google.com).
     * @return ArrayList<Double> the corosponding prices from each stock.
     *
     * A default of 1.0 is used if the price for a stock cannot be found and
     * this is also printed: System.out.println("Could not get stock quote and
     * used default value of 1.0 instead.");
     */
    private Random gen = new Random();
    private ArrayList<String> jogo = new ArrayList<>();
    private ArrayList<Integer> jogo1 = new ArrayList<>();
    private ArrayList<String> jogo3 = new ArrayList<>();
    private ArrayList<Integer> jogo4 = new ArrayList<>();

    public static ArrayList<Double> getStockData(ArrayList<String> stockShortNames) {
        ArrayList<Double> answer = new ArrayList<Double>();
        String infoToGet = "g";  //Changing this will change the info you get.
        String allStocks = "";
        String temp = "";

        //Running through the parameter and getting all the stock names into a format that Yahoo finance needs                
        for (String stock : stockShortNames) {
            allStocks += stock + "+";
        }
        allStocks = allStocks.substring(0, allStocks.length() - 1); //Cutting of the last, extra '+'-sign

        try {
            //Creating a connection and support object and getting the stock prices from yahoo finance:
            URL yahoofinance = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + allStocks + "&f=" + infoToGet);
            URLConnection yc = yahoofinance.openConnection();  //Opening a connection
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream())); //Creating a bufferedreader to hold stuff and loading it up

            //Running through the answer            
            while ((temp = in.readLine()) != null) {
                if (temp.equalsIgnoreCase("N/A")) //If price is not there, then...
                {
                    temp = "1.0";                   //..default value of 1.0 is used instead
                    System.out.println("Could not get stock quote and used default value of 1.0 instead.");
                }
                answer.add(Double.parseDouble(temp));  //Adding price to result arraylist
            }
            in.close(); //Closing the stream
            //Error handling:
        } catch (IOException ex) {
            System.out.println("Oops something went wrong in method getStockData(). Sorry. Try again.");
            System.out.println("Message from Exception: " + ex.getMessage());
            ex.printStackTrace();
        } catch (NumberFormatException n) {
            System.out.println("Oops something went wrong in method getStockData(): A NumberFormatException was thrown because Double.parseDouble() tried to pass this: " + temp);
            System.out.println("Message from Exception: " + n.getMessage());
        }

        return answer;
    }

    @Override
    public int calculateNewPrice() {

        if (jogo1.isEmpty()) {

            jogo.add("ASUR");
            jogo.add("ATAI");
            jogo.add("ATHN");
            jogo.add("AFCB");
            jogo.add("ATHX");
            jogo.add("AAME");
            jogo.add("ACFC");
            //
            jogo.add("CDTI");
            jogo.add("CLNE");
            jogo.add("CLNT");
            jogo.add("CLFD");
            jogo.add("CLRO");
            jogo.add("CLIR");
            jogo.add("CBLI");
            jogo.add("CKSW");
            jogo.add("CSBK");
            jogo.add("CLVS");
            jogo.add("CME");
            jogo.add("CCNE");
            jogo.add("CSBK");

            System.out.println("IF!");
            for (Double string : getStockData(jogo)) {

                double netdata = string;
                int TheRealData = (int) netdata;

                jogo1.add(TheRealData);

            }
            System.out.println(jogo1);
            return jogo1.get(gen.nextInt(jogo1.size()));

        } else {
        }

        return jogo1.get(gen.nextInt(jogo1.size()));
    }

    @Override
    public int calculateNewQty() {

        if (jogo4.isEmpty()) {

            //jogo3
            jogo3.add("CLDX");
            jogo3.add("ICEL");
            
            jogo3.add("CPSS");
            jogo3.add("CTRL");
            jogo3.add("CPRT");
            jogo3.add("CORT");
            jogo3.add("BVA");
            jogo3.add("CORE");
            jogo3.add("COCO");
            jogo3.add("CSOD");
            jogo3.add("CBSTZ");
            jogo3.add("CNDO");
            jogo3.add("CRRS");
            jogo3.add("CRVL");
            jogo3.add("COSI");
            jogo3.add("CVV");
            jogo3.add("CSGP");
            jogo3.add("COST");
            jogo3.add("CYBX");
            jogo3.add("CRRC");
            
    
            System.out.println("OF!");
            for (Double string : getStockData(jogo3)) {

                double netdata = string;
                int TheRealData = (int) netdata;

                jogo4.add(TheRealData);

            }
            System.out.println(jogo4);
            return jogo4.get(gen.nextInt(jogo4.size()));

        } else {
        }

        return jogo4.get(gen.nextInt(jogo4.size()));

    }
}
