//Concrete class that holds magic numbers shared by various other classes 

package Model; 

public final class Constants {
    public static final int GRID_SIZE = 9; 
    public static final int UNKNOWN_VALUE = 0; 
    public static final int MIN_VALUE = 1; 
    public static final int MAX_VALUE = 9; 


    /**
     * Used to check if the value given by user is valid. 
     * 
     * @param value  An int representing value stored at cell, where 0 represents an empty cell.
     * @throws IllegalArgumentException  If value is not between [0, 9]. 
     */
    public static void checkValue(int value) throws IllegalArgumentException {
        if (value < Constants.UNKNOWN_VALUE || value > Constants.MAX_VALUE) {
            throw new IllegalArgumentException("Value " + value + " is out of range. ");        //will eventually be caught by controller class, which then re-prompts user for valid input 
        } 
    }

    /**
     * Used to check if the index representing row index is valid. 
     * 
     * @param rowNumber An int representing index of a row in the Puzzle. 
     * @throws IllegalArgumentException If rowNumber is not within [0, 8]
     */
    public static void checkRowIndex(int rowNumber) throws IllegalArgumentException {
        if (rowNumber < 0 || rowNumber > Constants.GRID_SIZE - 1) {
            throw new IllegalArgumentException("Row number " + rowNumber + " is out of range. "); 
        }
    }

    /**
     * Used to check if the index representing column index is valid. 
     * 
     * @param columnNumber An int representing index of a column in the Puzzle.
     * @throws IllegalArgumentException If columnNumber is not within [0, 8]
     */
    public static void checkColumnIndex(int columnNumber) throws IllegalArgumentException {
        if (columnNumber < 0 || columnNumber > Constants.GRID_SIZE - 1) {
            throw new IllegalArgumentException("Column number " + columnNumber + " is out of range. ");
        }
    }

    /**
     * Calculate the index of the box that a Cell is located in based on it's row and column.
     * 
     * @param rowNumber An int representing the index of the row the Cell is located in.
     * @param columnNumber An int representing the index of the column the Cell is located in. 
     * @return An int representing the index of the box the Cell is located in. 
     */
    public static int calculateBoxIndex(int rowNumber, int columnNumber) {
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

        int boxNumber; 

        if (rowNumber < 3) {
            boxNumber = 0;
        }
        else if (rowNumber >=3 && rowNumber < 6) {
            boxNumber = 3;
        }
        else {
            boxNumber = 6;
        }

        if (columnNumber >=3 && columnNumber < 6) {
            boxNumber += 1;
        }
        else if (columnNumber >= 6) {
            boxNumber += 2;
        }

        return boxNumber; 
    }
    
}
