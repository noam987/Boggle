import java.util.ArrayList;
// the word comparator class that takes in an arraylist of words, and outputs them in order based on length and then alphabetically
// Mr. Peterson P3 APCS By Noam Arie
public class WordComparator {
    // constructor for WordComparator
    public WordComparator(){

    }

    public void sort(ArrayList<String> words){

        ArrayList<Integer> wordLengths = new ArrayList<Integer>();
        // finds all word lengths greater than 2
        for(String word: words){
            if(!wordLengths.contains(word.length()) && word.length() > 2){
                wordLengths.add(word.length());
            }
        }
        // sorts the word lengths from smallest to largest
        wordLengths.sort(Integer::compareTo);
        // loops through each word length from largest to smallest
        for(Integer length = wordLengths.size()-1; length >= 0; length --){
            ArrayList<String> wordsofLength = new ArrayList<String>();
            // finds all words of that length
            for(String word:words){
                if(wordLengths.get(length) == word.length()){
                    wordsofLength.add(word);
                }
            }
            //sorts the words alphabetically
            wordsofLength.sort(String::compareTo);
            //outputs the words
            System.out.println(wordLengths.get(length)+ " letter words");
            for(String word: wordsofLength){
                System.out.println(word);
            }
            System.out.println();
        }


    }
}
