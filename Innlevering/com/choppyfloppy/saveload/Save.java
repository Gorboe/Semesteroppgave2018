
package com.choppyfloppy.saveload;

public class Save {
/*
    static int playerHp = 1;
    static int playerScore = 2000;
    static int currentLevel = 3;


    int[] savePlayer = {playerHp, playerScore, currentLevel};
*/

    public Save() {

    }
/*
    public static void createfile() {
        //Dette skriver en fil til mappen savefolder.txt
        try {
            //Hvordan får vi fikset path når spillet flyttes til en annen pc?
            PrintWriter saveFile = new PrintWriter("C:\\Users\\krist\\IdeaProjects\\choppyfloppy\\saveFolder\\save.txt", "UTF-8");
            saveFile.println(playerHp);
            saveFile.println(playerScore);
            saveFile.println(currentLevel);
            saveFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

/*
                try {
                    Files.createFile(Paths.get("saveFolder"));
                } catch (IOException e){
                e.printStackTrace();
                }
    */


    public static void main(String[] args) {

        createsavefolder.createDirectoryIfNotExists();
        createsavefile.saveFile();
        loadgame.readFile();


        // Klarer jeg å hente datafelt fra game?

    }
}




