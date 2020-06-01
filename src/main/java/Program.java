import java.util.ArrayList;
// My Boggle Project By Noam Arie
// APCS Period 3 Mr. Peterson
// This program creates a boggle board of size 4, then finds all the words and outputs them from largest to smallest.
public class Program {
    public static void main(String[] args) {

        System.out.println("Welcome to Boggle by Noam Arie.");
        Board board = new Board(4);
        System.out.print(board.toString());
        ArrayList<String>  wordsFound= board.find();
        System.out.println("found " + wordsFound.size() + " word(s)");
        WordComparator wordComparator = new WordComparator();
        wordComparator.sort(wordsFound);
    }
}
