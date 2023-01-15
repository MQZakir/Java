package Java.WordGuesser;

// Regular imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

// File related imports
import java.io.FileNotFoundException;


public class WordGuesser {

    public static List<String> words = new ArrayList<String>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        
        try 
        {
            File file = new File("words.txt");
            Scanner reader = new Scanner(file);
            System.out.println(file);
            while(reader.hasNextLine())
            {
                String word = reader.nextLine();
                words.add(word.toUpperCase());
            } 
            reader.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found...\n");
            e.printStackTrace();
        }
        
        System.out.println("\nYou have 6 attemps to guess the word correctly\n");
        
        String playword = words.get((int)(Math.random() * words.size()));
  
        String guess = "";
        Scanner keyboard = new Scanner(System.in);
        boolean notdone = true;

        System.out.print("WORD: ");
        int count = 6;

        while(count >= 1 && guess != playword){
            notdone = false;
            for(char letter : playword.toCharArray()){
                if(guess.indexOf(letter) == -1){
                    System.out.print("_");
                    notdone = true;
                }
                else{
                    System.out.print(letter);
                }
            }
            System.out.println();

            if(!notdone){
                break;
            }
            
            System.out.print("\nEnter your guess letter: ");
            char inletter = keyboard.next().charAt(0);
            inletter = Character.toUpperCase(inletter);
            int flag = 0;
            int i = 0;
            while(i < playword.length()){
                if(inletter == playword.charAt(i)){
                    flag = 1;
                }
                i++;
            }
            if(flag == 1){
                System.out.println("\nCorrect guess!");
                System.out.println("Chances left: "+count);
            }
            else{
                System.out.println("\nWrong Guess!");
                count--;
                System.out.println("Chances left: "+count);
            }
            
            guess += inletter;

            if(count < 1)
            {
                System.out.println("\nYou failed to guess the word!");
                System.out.println("\nThe word was: "+playword+"\n");
                break;
            }
            else{
                System.out.println("\nYou guess the word correctly :)");
            } 
        }
        keyboard.close();
        scanner.close();
    }
}
