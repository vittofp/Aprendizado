package Aprendizado.NavalBattle;
import java.util.*;

public class GameHelper {
    private static final String ALPHABET = "abcdefg";
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = 49;
    private static final int MAX_ATTEMPTS = 200;
    static final int HORIZONTAL_INCREMENT = 1;
    static final int VERTICAL_INCREMENT = GRID_LENGTH;

    private final int[] grid = new int[GRID_SIZE];
    private final Random random = new Random();
    private int startupCount = 0;

    Scanner sc = new Scanner(System.in);

    public String getUserInput(String prompt) {
        System.out.print(prompt + " : ");
        return sc.nextLine().toLowerCase();
    }

    public ArrayList<String> placeStartup(int startupSize) {
        int[] startupCoord = new int[startupSize];
        int attempts = 0;
        boolean sucess = false;

        startupCount++;
        int increment = getIncrement();

        while (!sucess & attempts++ < MAX_ATTEMPTS) {
            int local = random.nextInt(GRID_SIZE);

            for (int i = 0; i < startupCoord.length; i++) {
                startupCoord[i] = local;
                local += increment;
            }
            if (startupFits(startupCoord, increment)){
                sucess = coordDisponivel(startupCoord);
            }
        }
        savePositionToGrid(startupCoord);
        ArrayList<String> alfaCells = convertCoordToAlfaFormat(startupCoord);
        return alfaCells;
    }
    private boolean startupFits(int[] startupCoord, int increment){
        int finalLocal = startupCoord[startupCoord.length - 1];
        if (increment == HORIZONTAL_INCREMENT) {
            return  calcRowDoIndex(startupCoord[0]) == calcRowDoIndex(finalLocal);
        }
        else {
            return finalLocal < GRID_SIZE;
        }
    }
    private boolean coordDisponivel(int[] startupCoord){
        for (int coord : startupCoord){
            if (grid[coord] != 0) {
                return false;
            }
        }
        return true;
    }
    private void savePositionToGrid(int[] startupCoord){
        for (int index : startupCoord){
            grid[index] = 1;
        }
    }
    private ArrayList<String> convertCoordToAlfaFormat(int[] startupCoords){
        ArrayList<String> alfaCells = new ArrayList<String>();
        for (int index : startupCoords){
            String alfaCoord = getAlfaCoordsFromIndex(index);
            alfaCells.add(alfaCoord);
        }
        return alfaCells;
    }
    private String getAlfaCoordsFromIndex(int index) {
        int row = calcRowDoIndex(index);
        int coluna = index % GRID_LENGTH;
        String letra = ALPHABET.substring(coluna, coluna + 1);
        return letra + row;
    }
    private int calcRowDoIndex(int index){
        return index / GRID_LENGTH;
    }
    private int getIncrement(){
        if (startupCount % 2 == 0) {
            return HORIZONTAL_INCREMENT;
        }
        else {
            return VERTICAL_INCREMENT;
        }
    }
}
    
