package Aprendizado.NavalBattle;
import java.util.ArrayList;

public  class Startup {


    private ArrayList<String> locationCells;
    int numOfHits;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourSelf(String userInput) {
        String result = "Errou";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }
}





