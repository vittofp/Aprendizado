package Aprendizado.NavalBattle;
import java.util.ArrayList;

public class StartupBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    void setUpGame() {
        Startup one = new Startup();
        one.setName("meta");
        Startup two = new Startup();
        two.setName("aws");
        Startup three = new Startup();
        three.setName("x");

        startups.add(one);
        startups.add(two);
        startups.add(three);

        // Estrutura incompleta (Não soube dar continuidade)
        for (Startup startup : startups) {


        }
    }

    void startPlaying() {
        while (!startups.isEmpty()) {
            helper.getUserInput("Enter a guess");
            

        }
    }

    void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Miss";

        for (Startup StartupToTest : startups) {
            result = StartupToTest.checkYourSelf(userGuess);

            if (result.equals("Hit")){
                break;
            }
                if (result.equals("Kill")) ;
                {
                    startups.remove(StartupToTest);
                    break;
                }
            }
        System.out.println(result);

        }
        void finishGame(){
            System.out.println("Game Over");
            if (numOfGuesses < 15){
                System.out.println("Congrats");
            }
            else {
                System.out.println("You should have surrended");
        }
    }
}
