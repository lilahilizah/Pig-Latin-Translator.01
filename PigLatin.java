import java.util.Scanner;
import java.util.ArrayList;
//Pig Latin Program//
//Synopsis: Take a sentence string input from the user and from this split up the words in the sentence and than translate
//each word to what it is in pig latin//
//Lila Hilizah//
//Refernces: Jalen Smith//

public class PigLatin{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Fail safe//
        String original = "";
        //Continues asking for a sentence util it is given the command "quit" in which it stops//
        while(!original.equalsIgnoreCase("quit")){
            System.out.print("Enter a sentence ('quit' to quit):");
            original = sc.nextLine();
            if(original.equalsIgnoreCase("quit")){
                break;
            }
            ArrayList<String> words = parseLine(original);
            //  Goes through each word in the sentence and translates//
            // Adds the translated word to a new string//
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                StringBuilder result = new StringBuilder();
                result.append(translate(word));
                System.out.print(result.toString() + " ");
            }
            System.out.println();
        }
        sc.close();
    }
    //Dont know how to return a list//
    static ArrayList<String> parseLine(String original){
        String [] words = original.split("");
        ArrayList<String> arr = new ArrayList();
        for(int b = 0; b < words.length;b++){
            arr.add(b,words[b]);
        }

        return arr;

    }
    static String translate(String word) {
        char[] vowels = {'A', 'a', 'E', 'e', 'O', 'o', 'U', 'u', 'I', 'i', 'Y', 'y'};
        //Keeps track of all the words before the first vowel//
        StringBuilder consonants = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        //If the words first letter is  a vowel put "yay" to the end of it.//
        if (is_vowel(word.charAt(0))) {
            sb.append(word).append("yay");
            return sb.toString();
        } else {
            // Going through  each letter in the word util it gets to the first vowel in which it stores all
            // the letters before the vowel into a substring and adds it to the end of the word and then adds "ay" to
            // the end of that.
            for(int i = 0; i < word.length();i++){
                char letter = word.charAt(i);
                if(is_vowel(letter)){
                    String restOf = word.substring(i, word.length());
                    sb.append(restOf).append(consonants).append("ay");
                    return sb.toString();
                }
                consonants.append(letter);
            }
            //Fail safe for if the the first letter in the word is not a vowel and the word is only one character//
            sb.append(word).append("ay");
            if(!is_vowel(sb.charAt(0))){
                for(int i = 0; i < vowels.length; i ++){
                    if(sb.charAt(0) != vowels[i]){
                        continue;
                    }
                }
                //Example for fail safe//
                sb.delete(1, sb.length());
            }
            return sb.toString();
        }
    }

    //Going through a checking if any of the vowels in the list of vowels matches the letter//
    static Boolean is_vowel(char letter) {
        char[] vowels = {'A', 'a', 'E', 'e', 'O', 'o', 'U', 'u', 'I', 'i', 'Y', 'y'};
        for (int i = 0; i < vowels.length; i++) {
            if (letter == vowels[i]) {
                return true;
            }
        }
        return false;
    }
}
