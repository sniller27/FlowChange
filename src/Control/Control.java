/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.Engine;

/**
 *
 * @author Soren
 */
public class Control implements ChangeInterface {

    private Engine engine;

    public Control() {

        engine = new Engine();

    }

    @Override
    public String askname1() {

        return engine.askName();
    }

    @Override
    public int getCash1() {

        return engine.getCash();

    }

    @Override
    public String highscore2(String file) {

        return engine.highscore1(file);

    }

    @Override
    public int getDay1() {

        return engine.getDay();
    }

    @Override
    public String getDrugType1(int number) {

        return engine.getDrugType(number);

    }

    @Override
    public int getBasePrice1(int number) {

        return engine.getBasePrice(number);

    }

    @Override
    public int getBaseQty1(int number) {

        return engine.getBaseQty(number);

    }

    @Override
    public int getDrugListSize1() {

        return engine.getDrugListSize();

    }

    @Override
    public String getCountry(int number) {

        return engine.getCountryName(number);

    }

    @Override
    public int getSizeCountries1() {

        return engine.getSizeCountries();
    }

    @Override
    public int getMyQty1(int number) {

        return engine.getMyQty(number);

    }

    @Override
    public void turn1(String file, String country1, String country2) {

        engine.turn(file, country1, country2);
    }

    @Override
    public void buy1(int selectedvalue) {

        engine.buy(selectedvalue);

    }

    @Override
    public void sell1(int selectedvalue) {

        engine.sell(selectedvalue);

    }

    @Override
    public void calculateNewPrices1() {

        engine.calculateNewPrices();

    }

    @Override
    public void calculateNewQty1() {

        engine.calculateNewQty();

    }

}
