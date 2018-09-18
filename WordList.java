import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordList extends ArrayList<String> {
    public WordList(String filename){
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while(fileScanner.hasNext()){
                add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist. ");
            e.printStackTrace();
        }
    }

    public String getRandom(){
        Random random = new Random();
        return get(random.nextInt(size()));
    }
}
