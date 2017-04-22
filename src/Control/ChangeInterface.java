/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Soren
 */
public interface ChangeInterface {

    public String askname1();

    public int getCash1();

    public String highscore2(String file);

    public int getDay1();

    public String getDrugType1(int number);

    public int getBasePrice1(int number);

    public int getBaseQty1(int number);

    public int getDrugListSize1();

    public String getCountry(int number);

    public int getSizeCountries1();

    public int getMyQty1(int number);

    public void turn1(String file, String country1, String country2);

    public void buy1(int selectedvalue);

    public void sell1(int selectedvalue);

    public void calculateNewPrices1();

    public void calculateNewQty1();

}
