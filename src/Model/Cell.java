//Concrete class representing the smallest piece of information in the puzzle 

package Model; 

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


    //Setters:
    public void setValue(int value) { 
        if (value == 0) {
            complete = false; 
        }
        else {
            complete = true; 
        }

        this.value = value; 
    }



    //Other:
    /**
     * Clear the Cell of it's value. 
     * 
     * @return  true if task was completed successfully. 
     */
    public boolean clear() {
        value = Constants.UNKNOWN_VALUE; 
        potentialValues.clear();
        complete = false; 
        return true; 
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

        //Could check value is between [1, 9]; however users will not have direct access to this function, thus not necessary. 

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
     * Represents the Cell as a String. 
     * 
     * @return The value at the Cell in string format. 
     */
    public String toString() {
        return "" + value; 
    }    
}
