/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Soren
 */
public class Score {

    private ArrayList<CompareClass> scorelist = new ArrayList();
    private int difference = 0;
    private String scoreboard;

    public void sortMethod(ArrayList<String> list) {

        for (String p : list) {
            String splitarray[] = p.split(" ");
            //     System.out.println(scorelist.add(new CompareClass(splitarray[0], splitarray[1])));
            int parsearray = Integer.parseInt(splitarray[1]);

            scorelist.add(new CompareClass(splitarray[0], parsearray));

        }

        Collections.sort(scorelist);

        for (CompareClass o : scorelist) {
            System.out.println(o);
        }

    }

    public String highscore() {

        scoreboard = "Highscores: \n";

        if (scorelist.size() < 10) {
            difference = scorelist.size();
        } else {
            difference = 10;
        }

        for (int i = 0; i < difference; i++) {
            scoreboard = scoreboard + (i + 1) + ". " + scorelist.get(i) + "\n";

        }

        return scoreboard;
    }
}
