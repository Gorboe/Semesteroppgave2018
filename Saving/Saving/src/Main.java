import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.*;

public class Main {
    private static int score = 1;
    private static int level = 2;

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) throws IOException {
                int[] anArray = {Main.score, Main.level};
                List<Integer> aList = new ArrayList();
                for (int i = 0; i < anArray.length; i++) {
                    aList.add(anArray[i]);
                }
                File file = new File("./Storage.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < aList.size(); i++) {
                    bw.write(aList.get(i).toString());

                }
                bw.flush();
                bw.close();


            }

/*

        try {
            int[] score = {1, 1};
            List<Integer> scoreList = new ArrayList();
            for (int i = 0; i < score.length; i++) {
                scoreList.add(score[i]);
            }
            File file = new File("/save.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < scoreList.size(); i++) {
                bw.write(scoreList.get(i).toString());
            }
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    */

}
