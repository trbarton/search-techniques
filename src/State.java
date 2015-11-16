import java.util.ArrayList;

/**
 * Created by Tom on 15/11/2015.
 */
public class State {

    private char[] puzzleArray;
    private int noOfElements;
    private int puzzleSize;

    private int agentIndex;

    private boolean atLeftBoundary = false;
    private boolean atRightBoundary = false;
    private boolean atTopBoundary = false;
    private boolean atBottomBoundary = false;

    private ArrayList<Integer> leftBoundary;
    private ArrayList<Integer> rightBoundary;

    public State(char[] puzzle, int agentIndex){
        puzzleArray = puzzle;
        this.agentIndex = agentIndex;
        puzzleSize();
        calculateLRBoundaries();
        atBoundaries();
    }

    public State(char[] puzzle, int agentIndex, ArrayList<Integer> left, ArrayList<Integer> right){
        puzzleArray = puzzle;
        this.agentIndex = agentIndex;
        puzzleSize();
        leftBoundary = left;
        rightBoundary = right;
        atBoundaries();
    }

    public void puzzleSize(){
        noOfElements = puzzleArray.length;
        puzzleSize = (int) Math.sqrt(noOfElements);
    }

    public void calculateLRBoundaries(){
        leftBoundary = new ArrayList<>();
        rightBoundary = new ArrayList<>();
        for(int i=0; i<puzzleSize; i++){
            leftBoundary.add(i*puzzleSize);
            rightBoundary.add((puzzleSize*(i+1))-1);
        }
    }

    public void atBoundaries(){
        if(agentIndex < puzzleSize){
            atTopBoundary = true;
        }else if (agentIndex >= (puzzleSize * (puzzleSize-1))){
            atBottomBoundary = true;
        }
        if(leftBoundary.contains(agentIndex)){
            atLeftBoundary = true;
        }else if (rightBoundary.contains(agentIndex)){
            atRightBoundary = true;
        }

    }

    public char[] getPuzzleArray() {
        return puzzleArray;
    }

    public boolean isAtLeftBoundary() {
        return atLeftBoundary;
    }

    public boolean isAtRightBoundary() {
        return atRightBoundary;
    }

    public boolean isAtTopBoundary() {
        return atTopBoundary;
    }

    public boolean isAtBottomBoundary() {
        return atBottomBoundary;
    }
}