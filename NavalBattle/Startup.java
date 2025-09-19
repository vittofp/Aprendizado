package Aprendizado.NavalBattle;
import java.util.ArrayList;

public  class Startup {

    private String name;
    private ArrayList<String> locationCells;


    public void setName(String name) {
        this.name = name;
    }
    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }


    public String checkYourSelf(String userInput) {
        String result = "Miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

        if (locationCells.isEmpty()) {
            result = "Kill";
            System.out.println("You sunk " + name + " !!");
            } else {
            result = "Hit";
            }
        }
        return result;
    }
}





