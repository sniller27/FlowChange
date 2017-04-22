/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Soren
 */
public class Countries {

    private String countyname;

    public Countries(String countyname) {
        this.countyname = countyname;
    }

    public String getCountyname() {
        return countyname;
    }

    public void setCountyname(String countyname) {
        this.countyname = countyname;
    }

    @Override
    public String toString() {
        return "Countries{" + "countyname=" + countyname + '}';
    }

}
