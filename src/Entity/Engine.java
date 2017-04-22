/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.PriceStrategies.Strategy_10Percent;
import Entity.PriceStrategies.Strategy_BasePriceCrystalMeth;
import Entity.PriceStrategies.Strategy_BasePriceHeroin;
import Entity.PriceStrategies.Strategy_Exchange;
import Entity.PriceStrategies.Strategy_OldMemory;
import Entity.PriceStrategies.Strategy_PickOneOf10;
import Entity.PriceStrategies.Strategy_SecondsOfTheClock;
import Entity.PriceStrategies.Strategy_SimpleTwoChoice;
import Entity.PriceStrategies.Strategy_Stock;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Soren
 */
public class Engine {

    //attributter
    private ArrayList<Drugs> list;
    private ArrayList<String> highscorelist;
    private ArrayList<Countries> countrylist;
    private String playername;
    private int Cash = 5000;
    private Score score = new Score();
    private int day = 1;

    public Engine() {
        //vi instantierer
        list = new ArrayList<Drugs>();
        highscorelist = new ArrayList<String>();
        countrylist = new ArrayList<Countries>();

        //vi laver pricestrategy objekter
        Strategy_BasePriceCrystalMeth price1 = new Strategy_BasePriceCrystalMeth();
        Strategy_SimpleTwoChoice price2 = new Strategy_SimpleTwoChoice();
        Strategy_SecondsOfTheClock price3 = new Strategy_SecondsOfTheClock();
        Strategy_10Percent price4 = new Strategy_10Percent();
        Strategy_PickOneOf10 price5 = new Strategy_PickOneOf10();
        Strategy_BasePriceHeroin price6 = new Strategy_BasePriceHeroin();
        Strategy_OldMemory price7 = new Strategy_OldMemory();
        Strategy_Stock price8 = new Strategy_Stock();
        Strategy_Exchange price9 = new Strategy_Exchange();

        //laver drugobjekter med info
        Drugs drugs0 = new Drugs("Cocaine", 1200, 30, 0, 1200, 30, price7);
        Drugs drugs1 = new Drugs("Heroin", 1600, 15, 0, 1600, 15, price6);
        Drugs drugs2 = new Drugs("Amphetamine", 1200, 50, 0, 1200, 50, price8);
        Drugs drugs3 = new Drugs("Acid", 550, 33, 0, 550, 33, price9);
        Drugs drugs4 = new Drugs("Angel Dust", 400, 60, 0, 400, 60, price4);
        Drugs drugs5 = new Drugs("Crystal Meth", 800, 38, 0, 800, 38, price1);
        Drugs drugs6 = new Drugs("Hash", 180, 100, 0, 180, 100, price2);
        Drugs drugs7 = new Drugs("Weed", 150, 115, 0, 150, 115, price5);
        Drugs drugs8 = new Drugs("Mushrooms", 120, 95, 0, 120, 95, price3);

//        //tilføjer drugs til liste
        list.add(drugs0);
        list.add(drugs1);
        list.add(drugs2);
        list.add(drugs3);
        list.add(drugs4);
        list.add(drugs5);
        list.add(drugs6);
        list.add(drugs7);
        list.add(drugs8);

        //tilføjer lande
        Countries countries0 = new Countries("Denmark");
        countrylist.add(countries0);
        Countries countries1 = new Countries("Colombia");
        countrylist.add(countries1);
        Countries countries2 = new Countries("Germany");
        countrylist.add(countries2);
        Countries countries3 = new Countries("USA");
        countrylist.add(countries3);
        Countries countries4 = new Countries("France");
        countrylist.add(countries4);
        Countries countries5 = new Countries("Afghanistan");
        countrylist.add(countries5);

    }

    public String highscore1(String file) {
        //Henter highscoren fra fil
        highscorelist = Filehandler.ReadFromFile(file);
        //sorterer highscoren
        score.sortMethod(highscorelist);
        //udskriver highscore
        return score.highscore();

    }

    public String askName() {

        do {

            playername = JOptionPane.showInputDialog("Name: ");

        } while (playername.isEmpty());

        return playername;

    }

    public int getCash() {

        return Cash;

    }

    public int getDay() {

        return day;
    }

    public void turn(String file, String country1, String country2) {
        if (country1.equalsIgnoreCase(country2)) {
            JOptionPane.showMessageDialog(null, "You are already in " + country1);
        } else {
            day++;
            if (day == 20) {

                highscorelist = Filehandler.ReadFromFile(file);
                //Tilføjer player og score
                highscorelist.add(playername + " " + Cash);
                //Gemmerhighscore
                Filehandler.SaveToFile(highscorelist, "ord.txt");
                //sorterer highscoren
                score.sortMethod(highscorelist);
                //udskriver highscore
                JOptionPane.showMessageDialog(null, score.highscore());

            } else {
            }
        }
    }

    public String getDrugType(int number) {

        return list.get(number).getType();

    }

    public int getBasePrice(int number) {

        return list.get(number).getBASE_PRICE();

    }

    public int getBaseQty(int number) {

        return list.get(number).getBASE_QTY();

    }

    public int getDrugListSize() {

        return list.size();

    }

    public int getMyQty(int number) {

        return list.get(number).getMy_qty();

    }

    public String getCountryName(int number) {

        return countrylist.get(number).getCountyname();

    }

    public int getSizeCountries() {

        return countrylist.size();
    }

    public void buy(int selectedvalue) {

        if (selectedvalue >= list.size() || selectedvalue < 0) {
            JOptionPane.showMessageDialog(null, "You must choose a drug from the list");
        } else {
            String stack = JOptionPane.showInputDialog("How much do you want to buy?");
            //jeg konverterer string til int.
            try {
                int stack1 = Integer.parseInt(stack);
                int stack2 = stack1 * list.get(selectedvalue).getBASE_PRICE();

                if (Cash < stack2) {
                    JOptionPane.showMessageDialog(null, "You don't have enough money");
                } else if (0 > stack2) {
                    JOptionPane.showMessageDialog(null, "My must insert a positive number");
                } else {
                    Cash = Cash - stack2;
                    System.out.println(list.get(selectedvalue).getBASE_QTY());
                    list.get(selectedvalue).setBASE_QTY(list.get(selectedvalue).getBASE_QTY() - stack1);
                    System.out.println(list.get(selectedvalue).getBASE_QTY());
                    list.get(selectedvalue).setMy_qty(list.get(selectedvalue).getMy_qty() + stack1);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Du skal indsætte et tal");
            }

        }

    }

    public void sell(int selectedvalue) {

        if (selectedvalue >= list.size() || selectedvalue < 0) {
            JOptionPane.showMessageDialog(null, "You must choose a drug from the list");
        } else {
            String stack = JOptionPane.showInputDialog("How much do you want to sell?");

            try {

                int stack1 = Integer.parseInt(stack);
                int stack2 = stack1 * list.get(selectedvalue).getBASE_PRICE();

                if (getMyQty(selectedvalue) < stack1) {
                    JOptionPane.showMessageDialog(null, "You cannot sell that much");
                } else if (0 > stack2) {
                    JOptionPane.showMessageDialog(null, "My must insert a positive number");
                } else {

                    Cash = Cash + stack2;
                    System.out.println(list.get(selectedvalue).getMy_qty());
                    list.get(selectedvalue).setMy_qty(list.get(selectedvalue).getMy_qty() - stack1);
                    System.out.println(list.get(selectedvalue).getMy_qty());

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Du skal indsætte et tal");
            }
        }

    }

    public void calculateNewPrices() {
        for (Drugs drug : list) {
            drug.calculateNewPrice();
        }
    }

    public void calculateNewQty() {
        for (Drugs drug : list) {
            drug.calculateNewQty();
        }
    }

}
