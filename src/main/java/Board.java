import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class Board {
    private String[][] board;
    private WordList list;
    // constructs a new board object
    public Board(int size){

        list = new WordList("WordList.txt",1,size*size);
        board = new String[size][size];
        Random rand = new Random();
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board.length; j++) {
                String word = list.get(rand.nextInt(list.size()));
                board[i][j] = word.charAt(rand.nextInt(word.length())) + "";
            }
        }
    }
    // toString method that outputs the board a square
    @Override
    public String toString() {
        String output = "";
        for (String[] line : board){
            output += line[0];
            for (int i = 1; i < line.length; i ++){
                output += " " + line[i];
            }
            output += "\n";
        }
        return output;
    }
    // method called when you want to find all the words. starts a recursive algorithm
    public ArrayList<String> find(){
        boolean visited[][] = new boolean[board.length][board.length];
        String str = "";

        ArrayList<String> wordsFound = new ArrayList<String>();
        // starts from all possible starting positions
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board.length; j ++){
                find(visited, i, j, str, wordsFound);

            }

        }
        return wordsFound;
    }
    //recursive algorithm to find all words from a given starting point.
    public void find(boolean[][] visited, int row, int column, String currentPath, ArrayList<String> words){
        // marks the current location as visited
         visited[row][column] = true;
         currentPath += board[row][column];
    // if the current path is a new words, add it to the list of found words
         if(list.contains(currentPath) && !words.contains(currentPath)){
             words.add(currentPath);
         }
         // loops through all possible next moves
         for(int i = row-1; i >= 0 && i < board.length&& i <= row+1; i ++){
             for(int j = column -1; j >= 0&& j < board.length && j <= column +1; j++){
                // ensures that you do not double back on a previous location
                 if(!visited[i][j]){
                    find(visited, i, j, currentPath, words);
                }
             }
         }
         //removes the current location from its storage.
         visited[row][column] = false;
         currentPath = currentPath.substring(0, currentPath.length()-1);

    }
}
