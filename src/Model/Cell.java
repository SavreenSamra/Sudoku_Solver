//Concrete class representing the smallest piece of information in the puzzle 

package Model; 

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cell {
    private int value; 
    private int rowNumber; 
    private int columnNumber; 
    private int boxNumber; 
    private Set<Integer> potentialValues; 
    private boolean complete; 


    
    //Constructors:
    /**
     * Constructor for a single cell. 
     * 
     * @param value  An int representing value stored at cell, where 0 represents an empty cell.
     * @param rowNumber  An int representing the index of the row this cell is located in. 
     * @param ColumnNumber  An int representing the index of the column this cell is located in. 
     * @throws IllegalArgumentException  If value is not between [0, 9], or if the rowNumber or columnNumber is not within [0, 8]
     */
    public Cell(int value, int rowNumber, int columnNumber) throws IllegalArgumentException {
        //First check validity of all inputs: 
        Constants.checkValue(value);
        Constants.checkRowIndex(rowNumber);
        Constants.checkColumnIndex(columnNumber);
    
        //If valid inputs, continue to initialization: 
        this.value = value; 
        this.rowNumber = rowNumber; 
        this.columnNumber = columnNumber; 
        potentialValues = new HashSet<>(); 

        if (value == Constants.UNKNOWN_VALUE) {
            complete = false;  
        }
        else {
            complete = true; 
        }

        boxNumber = Constants.calculateBoxIndex(rowNumber, columnNumber); 
    }
    


    //Getters:
    public boolean isComplete() { return complete; }
    public int getRowNumber() { return rowNumber; }
    public int getColumnNumber() { return columnNumber; }
    public int getBoxNumber() { return boxNumber; }
    public int getValue() { return value; }
    public Set<Integer> getPotentialValues() { return potentialValues; }



    //Setters:
    public void setValue(int value) { 
        /*
        Best practice is to check that the arguement is valid by calling Constants.checkValue(value)
        However, this method is only used by developers and users do not have access to it, thus I excluded the safety check
        */

        if (value == 0) {
            complete = false; 
        }
        else {
            complete = true; 
        }

        this.value = value; 
        potentialValues.clear();
    }



    //Other:
    /**
     * Return, but do not set, the final value of a Cell (if known final value). 
     * 
     * @return 0 to represent unknown final Value, or an int between [1, 9] representing the final value of the Cell. 
     */
    public int finalValue() {
        if (complete || potentialValues.size() != 1) {
            return 0; 
        }
        else {
            return potentialValues.iterator().next(); //only 1 element in set, which represents the only value the Cell can be 
        }

    }

    /**
     * Adds a value to the set representing the potential values this Cell could possibly be. 
     * 
     * @param value An int representing a possible value that could be stored at cell.
     * @return  true if value was added successfully, and false otherwise. 
     */
    public boolean addPotentialValue(int value) {
        if (complete) {
            return false; 
        }

        /*
        Best practice is to check that the arguement is valid by calling Constants.checkValue(value)
        However, this method is only used by developers and users do not have access to it, thus I excluded the safety check
        */

        return potentialValues.add(value); 
    }

    /**
     * Deletes a value from the set representing the potential values this Cell could possibly be.
     * 
     * @param value An int representing the value to be removed from set. 
     * @return  true if value was removed successfully, and false otherwise. 
     */
    public boolean removePotentialValue(int value) {
        return potentialValues.remove(value); 
    }


    /**
     * Fill potentialValues variable with all possible numbers that the Cell could potentially be. 
     * 
     * @param s1 The first Section that the Cell exists in (i.e., its row Section). 
     * @param s2 The second Section that the Cell exists in (i.e., its column Section). 
     * @param s3 The third Section that the Cell exists in (i.e., its box Section). 
     * @return true if task was completed successfully, and false otherwise. 
     */
    public boolean fillPotentalValues(Section s1, Section s2, Section s3) {
        if (complete) {
            return false; 
        }

        potentialValues.clear();
        Set<Integer> unusedValues = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5, 7, 8, 9)); 

        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (s1.getCell(i).isComplete()) {
                unusedValues.remove(s1.getCell(i).getValue()); 
            }

            if (s2.getCell(i).isComplete()) {
                unusedValues.remove(s2.getCell(i).getValue());
            }

            if (s3.getCell(i).isComplete()) {
                unusedValues.remove(s3.getCell(i).getValue());
            }
        }

        potentialValues = unusedValues; 
        return true; 
    }

    /**
     * Represents the Cell as a String. 
     * 
     * @return The value at the Cell in string format. 
     */
    public String toString() {
        return "" + value; 
    }    
}
