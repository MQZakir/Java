package Java.Cipher;

import java.util.Scanner;

public class substitution {
    public static void main(String[] args) {
        
        // (For bash users only) Check for atleast one argument
        if(args.length != 1){
            System.out.println("USAGE: java substitution.java KEY");
            System.exit(0);
        }
        
        String key = args[0];
        key = key.toUpperCase();

        // If key is less than 26 characters
        if(key.length() != 26){
            System.out.println("Key must contain all 26 letters of the alphabet!");
            System.exit(0);
        }

        char[] key_arr = key.toCharArray();

        // If key contains one or more digits
        for(char c : key_arr){
            if(Character.isDigit(c) == true){
                System.out.println("Key cannot contain digit/s!");
                System.exit(0);
            }
        }
        
        // If key has repeating characters
        int count = 0;
        for (char alphabets = 'A'; alphabets <= 'Z'; alphabets++){
            for(char c : key_arr){
                if(c == alphabets){
                    count++;
                }
            }
        }
        if(count != 26){
            System.out.println("Key cannot have repeating characters!");
            System.exit(0);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word you want to encrypt with the chosen cypher: ");
        String text = scanner.next();
        String cipher = text;
        char[] ciphertext = cipher.toCharArray();
        char[] text_arr = text.toCharArray();

        for(int i = 0; i < text_arr.length; i++){
            
            if(text_arr[i] == '!' || text_arr[i] == '.' || text_arr[i] == ' ' || text_arr[i] == ',' || text_arr[i] == '?'){
                // Nothing
            }
            
            if(text_arr[i] >= 65 && text_arr[i] <= 90){
                ciphertext[i] = key_arr[text_arr[i] - 65];
            } 

            else if(text_arr[i] >= 97 && text_arr[i] <= 122){
                ciphertext[i] = key_arr[text_arr[i] - 97];
                ciphertext[i] = Character.toLowerCase(ciphertext[i]);
            }
        }
        System.out.println(ciphertext);
        scanner.close();
    }
}
