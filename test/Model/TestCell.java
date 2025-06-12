//Unit testing for the Cell class 

package test.Model;

import Model.Cell; 

public class TestCell {
    public static void main(String[] args) {

        //Test Contructors 
        System.out.println("Testing Cell Constructors - - 7 Tests"); 

        try {
            //Valid Cells - - should produce no exceptions
            Cell c1 = new Cell(0, 1, 1); //testing lower bounds for value input 
            Cell c2 = new Cell(1, 0, 2); //testing lower bounds for row input 
            Cell c3 = new Cell(2, 2, 0); //testing lower bounds for column input 

            Cell c4 = new Cell(9, 3, 3); //testing upper bounds for value input
            Cell c5 = new Cell(3, 8, 4); //testing upper bounds for row input 
            Cell c6 = new Cell(4, 4, 8); //testing upper bounds for column input 

            Cell c7 = new Cell(5, 5, 5); //testing middle values 
            Cell c8 = new Cell(0, 2, 1); //testing unknown value set-up 

            System.out.println("Passed Test 1: Cell Constructors did not throw an exception when inputs were valid. ");   
        } catch (Exception e) {
            System.out.println("Failed Test 1: Cell Constructors threw exception when inputs were valid. "); 
        }

        //Series of Invalid Cell Constructors calls (they should all throw exceptions )
        try {
            Cell invalc1 = new Cell(-1, 0, 0); //invalid value input (< 0)

            System.out.println("Failed Test 2: Cell Constructor did not throw an exception when value input was < 0. "); 
        } catch (Exception e) {
            System.out.println("Passed Test 2: Cell Constructor threw exception when value input was < 0. "); 
        }

        try {
            Cell invalc2 = new Cell(10, 7, 8); //invalid value input (> 9)

            System.out.println(("Failed Test 3: Cell Constructor did not throw an exception when value input was > 9. "));
        } catch (Exception e) {
            System.out.println("Passed Test 3: Cell Constructor threw an exception when value input was > 9. "); 
        }

        try {
            Cell invalc3 = new Cell(0, -1, 8); //invalid row input (< 0)

            System.out.println("Failed Test 4: Cell Constructor did not throw an exception when row input was < 0. "); 
            
        } catch (Exception e) {
            System.out.println("Passed Test 4: Cell Constructor threw an exception when row input was < 0. "); 
        }

        try {
            Cell invalc4 = new Cell(3, 9, 3); //invalid row input (> 8)  

            System.out.println("Failed Test 5: Cell Constructor did not throw an exception when row input was > 8. "); 
        } catch (Exception e) {
            System.out.println("Passed Test 5: Cell Constructor threw an exception when row input was > 8. "); 
        }

        try {
            Cell invalc5 = new Cell(0, 0, -1); //invalid column input (< 0)

            System.out.println("Failed Test 6: Cell Constructor did not throw an exception when column input was < 0. "); 
        } catch (Exception e) {
            System.out.println("Passed Test 6: Cell Constructor threw an exception when column input was < 0. "); 
        }

        try {
            Cell invalc6 = new Cell(1, 8, 9); //invalid column input (> 8)

            System.out.println("Failed Test 7: Cell Constructor did not throw an exception when column input was > 8. "); 
        } catch (Exception e) {
            System.out.println("Passed Test 7: Cell Constructor threw an exception when column input was > 8. "); 
        }
        



        //Test Getters 
        System.out.println("Testing Cell Getter Methods - - X Tests"); 




        //Test Setters 


        //



    }
    
}
