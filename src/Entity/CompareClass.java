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
public class CompareClass implements Comparable<CompareClass> {

    private String name;
    private int score;

    public CompareClass(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + ", " + score;
    }

    @Override
    public int compareTo(CompareClass o) {
        CompareClass compareclass = o;

        return compareclass.score - this.score;
    }
}
