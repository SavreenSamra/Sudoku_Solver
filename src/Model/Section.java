//Abstract class representing 9 cells grouped together

package Model; 

public class Section {
    private Cell[] cell; 
    private boolean complete; 

    //Constructors 
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
         * The following section calculates which row and column the first Cell of our Section is located in. 
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
            
            
        }

        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            cell[i] = new Cell(values[i], rowNumber, columnNumber); 
        }


        if (checkCompletion()) {
            complete = true; 
        }
        else {
            complete = false; 
        }

    }


    //Getters
    public boolean isComplete() { return complete; }


    //Others
    public boolean checkCompletion() {
        return true; 
    }

    public boolean clear() {
        for (int i = 0; i < Constants.GRID_SIZE; i++) {
            cell[i].clear(); 
        }
        complete = false; 
        return true; 
    }

    public boolean solve() {
        return true;
    }

    public String toString() {
        return ""; 
  
    }
    
}
