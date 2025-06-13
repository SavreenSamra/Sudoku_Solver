//Abstract class representing 9 cells grouped together

package Model;

public class Section {
    private Cell[] cell; 
    private boolean complete; 



    //Constructors 
    /**
     * Constructor for a Section, which are 9 Cells grouped together in the puzzle. 
     * 
     * @param type  A string representing what type of section this is. "R" = row, "C" = column, "B" = box.
     * @param index An int representing the index of this Section. 
     * @param values  An int[] holding the values stores at each Cell in Section.
     * @throws IllegalArgumentException If type is not "R", "C", or "B", if index is not within [0, 8], if int[] does not have 9 values, or if the Cell constructor throws an IllegalArguementException.
     */
    public Section(String type, int index, int[] values) throws IllegalArgumentException {
        //First check validity of all inputs: 
        if (type != "R" || type != "C" || type != "B") {
            throw new IllegalArgumentException("Type " + type + " is not valid. ");
        }

        if (index < 0 || index > Constants.GRID_SIZE - 1) {
            throw new IllegalArgumentException("Index " + index + " is out of range. ");
        }

        if (values.length != Constants.GRID_SIZE) {
            throw new IllegalArgumentException("Number of values inputted, " + values.length + ", is invalid. ");
        }

        //If valid inputs, continue to intiialization: 
        cell = new Cell[Constants.GRID_SIZE]; 

        /*
         * The following section calculates the row and column index that the first Cell of our Section is located in. 
         * To follow the logic easily, draw out a 9x9 grid with the row, column, and box indices labelled. 
         * 
         * - Logically we see that: 
         *      If our Section is a row  ->  the first Cell starts with a rowNumber equal to the inputted index and the columnNumber is 0. 
         *      If our Section is a column  ->  the first Cell starts with a columnNumber equal to the inputted index and the rowNumber is 0.  
         * 
         * - If our section is a box, we must do some extra work to get this information. 
         *   Logically we see that:
         *      If the box index is between [0, 2]  ->  the starting rowNumber is equal to 0 
         *      If the box index is between [3, 5]  ->  the starting rowNumber is equal to 3
         *      If the box index is between [6, 8]  ->  the starting rowNumber is equal to 6
         *      If the box index divided by 3 has a remainder of 0  ->  the starting columnNumber is equal to 0
         *      If the box index divided by 3 has a remainder of 1  ->  the starting columnNumber is equal to 3
         *      If the box index divided by 3 has a remainder of 2  ->  the starting columnNumber is equal to 6
         */
        int rowNumber, columnNumber; 

        if (type == "R") {
            rowNumber = index; 
            columnNumber = 0; 
        }
        else if (type == "C") {
            columnNumber = index; 
            rowNumber = 0; 
        }
        else {
            if (index < 3) {
                rowNumber = 0; 
            }
            else if (index >= 3 && index < 6) {
                rowNumber = 3; 
            }
            else {
                rowNumber = 6; 
            }

            if (index % 3 == 0) {
                columnNumber = 0; 
            }
            else if (index % 3 == 1) {
                columnNumber = 3; 
            }
            else {
                columnNumber = 6; 
            }
        }

        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            cell[i] = new Cell(values[i], rowNumber, columnNumber); 

            /*
             * The following section calculates how to increment the row and column indicies as we iterate through the Cells in our Section. 
             * To follow the logic easily, draw out a 9x9 grid with the row, column, and box indices labelled. 
             * 
             * - Logically we see that: 
             *      If our Section is a row  ->  all Cells will have the same rowNumber, but the columnNumber increments for each Cell. 
             *      If our Section is a column  ->  all Cells will have the same columnNumber, but the rowNumber increments for each Cell. 
             * 
             * - If our section is a box, we must do some extra work to get this information. 
             *   Logically we see that:
             *      If i (the iterator counter) is divisible by 3 with a remainder of either 1 or 2  ->  only the columnNumber is incremented.
             *      If i (the iterator counter) is divisible by 3 with 0 remainders  ->  we have started a new row and will only increment rowNumber then. 
             *      If i (the iterator counter) is divisible by 3 with 0 remainders  ->  the columnNumber goes back to it's initial value (i.e., remove the last 2 iterations it went through)
             */
            if (type == "R") {
                columnNumber++; 
            }
            else if (type == "C") {
                rowNumber++; 
            }
            else {
                if (i % 3 == 0) {
                    rowNumber++; 
                    columnNumber -= 2; 
                }
                else {
                    columnNumber++; 
                }

            }
        }

        checkCompletion(); 
    }



    //Getters
    public boolean isComplete() { return complete; }
    public Cell getCell(int index) { return cell[index]; }


    
    //Others
    /**
     * Edit the value of a single Cell in the Section. 
     * 
     * @param value An int representing the new value of the Cell. 
     * @param index An int representing the index of the Cell to be changed. 
     * @return  true if task was completed successfully. 
     */
    public boolean edit(int value, int index) {
        //Function that calls this function will do all error checks on inputs, thus no need to check input validity here.
        
        cell[index].setValue(value);
        checkCompletion(); 
        return true; 
    }

    /**
     * Check if all Cells in our Section have their final value, in which case our Section can be labelled as complete. 
     * 
     * @return true if Section is complete, and false otherwise.
     */
    public boolean checkCompletion() {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (cell[i].isComplete()) {
                complete = true; 
                return true; 
            }
        }

        complete = false; 
        return false; 
    }

    /**
     * Clear all Cells in our Section by removing their values.
     * 
     * @return true if task was completed successfully. 
     */
    public boolean clear() {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            cell[i].setValue(0);; 
        }
        complete = false; 
        return true; 
    }


    /**
     * For all Cells in our Section with an unknown value, remove a value from their potentialValue set. 
     * 
     * @param value An int representing the value to remove from potentialValue sets. 
     * @return true if task completed successfully. 
     */
    public boolean removePotentialValue(int value) {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (!cell[i].isComplete()) {
                cell[i].removePotentialValue(value); 
            }
        }
        return true; 
    }

    /**
     * Represents the Section as a String. 
     * 
     * @return The value at all Cells in the Section in string format, with a 2-space gap between each Cell value and a 4-space gap between each subsection of 3 Cells.  
     * 
     */
    public String toString() {
        String toReturn = ""; 

        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                toReturn += "  "; 
            }

            toReturn += cell[i].getValue() + "  "; 
        }

        return toReturn; 
    }
    
}
