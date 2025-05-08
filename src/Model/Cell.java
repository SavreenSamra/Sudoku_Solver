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
     * @param value  Value stored at cell, where 0 represents an empty cell.
     * @param rowNumber  Index of the row this cell is located in. 
     * @param ColumnNumber  Index of the column this cell is located in. 
     * @throws IllegalArgumentException  If value is not between [0, 9], or if the rowNumber or columnNumber is not within [0, 8]
     */
    public Cell(int value, int rowNumber, int columnNumber) throws IllegalArgumentException {
        //First check validity of all inputs: 
        checkValue(value);

        if (rowNumber < 0 || rowNumber > Constants.GRID_SIZE - 1) {
            throw new IllegalArgumentException("Row number " + rowNumber + " is out of range. "); 
        }

        if (columnNumber < 0 || columnNumber > Constants.GRID_SIZE - 1) {
            throw new IllegalArgumentException("Column number " + columnNumber + " is out of range. ");
        }
    
        //If valid inputs, continue to intiialization: 
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

        /*
         * The following section calculates the boxNumber index based on which row and column the Cell is located in. 
         * To follow the logic easily, draw out a 9x9 grid with the row, column, and box indices labelled. 
         * 
         * - Logically we see that: 
         *      If the row index is between [0, 2]  ->  the box index will be between [0, 2]
         *      If the row index is between [3, 5]  ->  the box index will be between [3, 5]
         *      If the row index is between [6, 8]  ->  the box index will be between [6, 8]
         *  Using this, we can set the boxNumber be either 0, 3, or 6 depending on the rowNumber. 
         * 
         * - Then, we use the column number to set the final boxNumber. 
         *   Logically we see that:
         *      If the column index is between [0, 2]  ->  the box index does not need to be changed (it will be either 0, 3, or 6)
         *      If the column index is between [3, 5]  ->  the box index will be either 1, 4, or 7  (i.e., increment once)
         *      If the column index is between [6, 8]  ->  the box index will be either 2, 5, or 8  (i.e., increment twice) 
         */
        if (rowNumber < 3) {
            boxNumber = 0;
        }
        else if (rowNumber >=3 && rowNumber < 6) {
            boxNumber = 3;
        }
        else //if rowNumber >=6
        {
            boxNumber = 6;
        }

        if (columnNumber >=3 && columnNumber <6) {
            boxNumber += 1;
        }
        else if (columnNumber >= 6) {
            boxNumber += 2;
        }
    }
    

    //Getters:
    public boolean isComplete() { return complete; }
    public int getRowNumber() { return rowNumber; }
    public int getColumnNumber() { return columnNumber; }
    public int getBoxNumber() { return boxNumber; }


    //Setters:



    //Other:
    public boolean clear() {
        value = Constants.UNKNOWN_VALUE; 
        potentialValues.clear();
        complete = false; 
        return true; 
    }

    public boolean addPotentialValue(int value) {
        return potentialValues.add(value); 
    }

    public boolean removePotentialValue(int value) {
        return potentialValues.remove(value); 
    }

    public String toString() {
        if (value == 0) {
            return " "; 
        }
        return "" + value; 
    }


    //Helper Functions:
    /**
     * Used to check if the value given by user is valid. 
     * 
     * @param value  Value stored at cell, where 0 represents an empty cell.
     * @throws IllegalArgumentException  If value is not between [0, 9]. 
     */
    private void checkValue(int value) throws IllegalArgumentException {
        if (value < Constants.UNKNOWN_VALUE || value > Constants.MAX_VALUE) {
            throw new IllegalArgumentException("Value " + value + " is out of range. ");        //will eventually be caught by controller class, which then re-prompts user for valid input 
        } 
    }

    
}
