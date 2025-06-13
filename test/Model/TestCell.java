//Unit testing for the Cell class 

package test.Model;

import Model.Cell; 

public class TestCell {
    public static void main(String[] args) {
        int totalTests = 0; 
        int passedTests = 0; 
        String exceptionVariable = null; // will hold name of variable that caused an exception 

        //Test Contructors 
        System.out.println(); 
        System.out.println("Testing Cell Constructors:"); 

        try {
            //Valid Cells - - should produce no exceptions
            totalTests++; 
            exceptionVariable = "constructorC1"; 
            Cell constructorC1 = new Cell(0, 1, 1); //testing lower bounds for value input 
            passedTests++; 

            totalTests++; 
            exceptionVariable = "constructorC2"; 
            Cell constructorC2 = new Cell(1, 0, 2); //testing lower bounds for row input 
            passedTests++; 

            totalTests++; 
            exceptionVariable = "constructorC3"; 
            Cell constructorC3 = new Cell(2, 2, 0); //testing lower bounds for column input 
            passedTests++; 

            totalTests++; 
            exceptionVariable = "constructorC4"; 
            Cell constructorC4 = new Cell(9, 3, 3); //testing upper bounds for value input
            passedTests++; 

            totalTests++; 
            exceptionVariable = "constructorC5"; 
            Cell constructorC5 = new Cell(3, 8, 4); //testing upper bounds for row input
            passedTests++; 

            totalTests++; 
            exceptionVariable = "constructorC6"; 
            Cell constructorC6 = new Cell(4, 4, 8); //testing upper bounds for column input 
            passedTests++; 

            totalTests++; 
            exceptionVariable = "constructorC7"; 
            Cell constructorC7 = new Cell(5, 5, 5); //testing middle values 
            passedTests++; 

            totalTests++; 
            exceptionVariable = "constructorC8"; 
            Cell constructorC8 = new Cell(0, 2, 1); //testing unknown value set-up 
            passedTests++; 

            System.out.println("Passed Conductor Test 1: Cell Constructors did not throw an exception when inputs were valid. ");   

        } catch (Exception e) {
            System.out.println("Failed Conductor Test 1: Cell Constructors threw exception when inputs were valid. Refer to variable " + exceptionVariable + " for debugging purposes. \n"); 
    
            System.out.println("Total tests conducted: " + totalTests);
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1);
        }

        //Series of Invalid Cell Constructors calls (they should all throw exceptions )
        try {
            totalTests++; 
            exceptionVariable = "invalConstructorC1"; 
            Cell invalConstructorC1 = new Cell(-1, 0, 0); //invalid value input (< 0)

            System.out.println("Failed Conductor Test 2: Cell Constructor did not throw an exception when value input was < 0. Refer to variable " + exceptionVariable + " for debugging purposes. \n"); 

            System.out.println("Total tests conducted: " + totalTests);
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1);

        } catch (Exception e) {
            passedTests++; 
            System.out.println("Passed Conductor Test 2: Cell Constructor threw exception when value input was < 0. "); 
        }

        try {
            totalTests++; 
            exceptionVariable = "invalConstructorC2"; 
            Cell invalConstructorC2 = new Cell(10, 7, 8); //invalid value input (> 9)

            System.out.println(("Failed Conductor Test 3: Cell Constructor did not throw an exception when value input was > 9. Refer to variable " + exceptionVariable + " for debugging purposes. \n"));

            System.out.println("Total tests conducted: " + totalTests);
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1);

        } catch (Exception e) {
            passedTests++; 
            System.out.println("Passed Conductor Test 3: Cell Constructor threw an exception when value input was > 9. "); 
        }

        try {
            totalTests++; 
            exceptionVariable = "invalConstructorC3"; 
            Cell invalConstructorC3 = new Cell(0, -1, 8); //invalid row input (< 0)

            System.out.println("Failed Conductor Test 4: Cell Constructor did not throw an exception when row input was < 0. Refer to variable " + exceptionVariable + " for debugging purposes. \n"); 
            
            System.out.println("Total tests conducted: " + totalTests);
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1);

        } catch (Exception e) {
            passedTests++; 
            System.out.println("Passed Conductor Test 4: Cell Constructor threw an exception when row input was < 0. "); 
        }

        try {
            totalTests++; 
            exceptionVariable = "invalConstructorC4"; 
            Cell invalConstructorC4 = new Cell(3, 9, 3); //invalid row input (> 8)  

            System.out.println("Failed Conductor Test 5: Cell Constructor did not throw an exception when row input was > 8. Refer to variable " + exceptionVariable + " for debugging purposes. \n");
            
            System.out.println("Total tests conducted: " + totalTests);
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1);

        } catch (Exception e) {
            passedTests++; 
            System.out.println("Passed Conductor Test 5: Cell Constructor threw an exception when row input was > 8. "); 
        }

        try {
            totalTests++; 
            exceptionVariable = "invalConstructorC5"; 
            Cell invalConstructorC5 = new Cell(0, 0, -1); //invalid column input (< 0)

            System.out.println("Failed Conductor Test 6: Cell Constructor did not throw an exception when column input was < 0. Refer to variable " + exceptionVariable + " for debugging purposes. \n"); 

            System.out.println("Total tests conducted: " + totalTests);
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1);

        } catch (Exception e) {
            passedTests++; 
            System.out.println("Passed Conductor Test 6: Cell Constructor threw an exception when column input was < 0. "); 
        }

        try {
            totalTests++; 
            exceptionVariable = "invalConstructorC6"; 
            Cell invalConstructorC6 = new Cell(1, 8, 9); //invalid column input (> 8)

            System.out.println("Failed Conductor Test 7: Cell Constructor did not throw an exception when column input was > 8. Refer to variable " + exceptionVariable + " for debugging purposes. \n");
            
            System.out.println("Total tests conducted: " + totalTests);
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1);

        } catch (Exception e) {
            passedTests++; 
            System.out.println("Passed Conductor Test 7: Cell Constructor threw an exception when column input was > 8. "); 
        }
        

        System.out.println("\n\n");


        //Test Getters 
        System.out.println("Testing Cell Getter Methods: "); 

        try {
            Cell getterC1 = new Cell(0, 0, 0); 

            totalTests++; 
            exceptionVariable = "getterC1.isComplete()"; 
            if (getterC1.isComplete()) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC1.getRowNumber()"; 
            if (getterC1.getRowNumber() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC1.getColumnNumber()"; 
            if (getterC1.getColumnNumber() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC1.getBoxNumber()"; 
            if (getterC1.getBoxNumber() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC1.getValue()"; 
            if (getterC1.getValue() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC1.getPotentialValues()"; 
            if (!getterC1.getPotentialValues().isEmpty()) {
                throw new Exception(); 
            }
            passedTests++; 

            System.out.println("Passed Getter Test 1: Cell Getter methods returned correct outputs when Cell was unchanged. "); 

        } catch (Exception e) {
            System.out.println("Failed Getter Test 1: Cell Getter methods did not return correct output when Cell was unchanged. Refer to method " + exceptionVariable + " for debugging purposes. \n" ); 

            System.out.println("Total tests conducted: " + totalTests); 
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1); 
        }


        try {
            Cell getterC2 = new Cell(9, 8, 8); 

            totalTests++; 
            exceptionVariable = "getterC2.isComplete()"; 
            if (!getterC2.isComplete()) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC2.getRowNumber()"; 
            if (getterC2.getRowNumber() != 8) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC2.getColumnNumber()"; 
            if (getterC2.getColumnNumber() != 8) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC2.getBoxNumber()"; 
            if (getterC2.getBoxNumber() != 8) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC2.getValue()"; 
            if (getterC2.getValue() != 9) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC2.getPotentialValues()"; 
            if (!getterC2.getPotentialValues().isEmpty()) {
                throw new Exception(); 
            }
            passedTests++; 

            System.out.println("Passed Getter Test 2: Cell Getter methods returned correct outputs when Cell was unchanged. "); 

        } catch (Exception e) {
            System.out.println("Failed Getter Test 2: Cell Getter methods did not return correct output when Cell was unchanged. Refer to method " + exceptionVariable + " for debugging purposes. \n" ); 

            System.out.println("Total tests conducted: " + totalTests); 
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1); 
        }


        try {
            Cell getterC3 = new Cell(4, 4, 6); 

            totalTests++; 
            exceptionVariable = "getterC3.isComplete()"; 
            if (!getterC3.isComplete()) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC3.getRowNumber()"; 
            if (getterC3.getRowNumber() != 4) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC3.getColumnNumber()"; 
            if (getterC3.getColumnNumber() != 6) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC3.getBoxNumber()"; 
            if (getterC3.getBoxNumber() != 5) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC3.getValue()"; 
            if (getterC3.getValue() != 4) {
                throw new Exception(); 
            }
            passedTests++; 

            totalTests++; 
            exceptionVariable = "getterC3.getPotentialValues()"; 
            if (!getterC3.getPotentialValues().isEmpty()) {
                throw new Exception(); 
            }
            passedTests++; 

            System.out.println("Passed Getter Test 3: Cell Getter methods returned correct outputs when Cell was unchanged. "); 

        } catch (Exception e) {
            System.out.println("Failed Getter Test 3: Cell Getter methods did not return correct output when Cell was unchanged. Refer to method " + exceptionVariable + " for debugging purposes. \n" ); 

            System.out.println("Total tests conducted: " + totalTests); 
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1); 
        }
                
        
        //Extra Testing for getBoxNumber() - - as setting the box number was math intensive, want to ensure it works for all cases 
        try {
            //box number should be 0 
            Cell getterC4 = new Cell(0, 0, 0); 
            totalTests++; 
            exceptionVariable = "getterC4.getBoxNumber()"; 
            if (getterC4.getBoxNumber() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC5 = new Cell(0, 1, 1); 
            totalTests++; 
            exceptionVariable = "getterC5.getBoxNumber()"; 
            if (getterC5.getBoxNumber() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC6 = new Cell(0, 2, 2); 
            totalTests++; 
            exceptionVariable = "getterC6.getBoxNumber()"; 
            if (getterC6.getBoxNumber() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC7 = new Cell(0, 0, 2); 
            totalTests++; 
            exceptionVariable = "getterC7.getBoxNumber()"; 
            if (getterC7.getBoxNumber() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC8 = new Cell(0, 2, 0); 
            totalTests++; 
            exceptionVariable = "getterC8.getBoxNumber()"; 
            if (getterC8.getBoxNumber() != 0) {
                throw new Exception(); 
            }
            passedTests++; 


            //box number should be 1 
            Cell getterC9 = new Cell(0, 0, 3); 
            totalTests++; 
            exceptionVariable = "getterC9.getBoxNumber()"; 
            if (getterC9.getBoxNumber() != 1) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC10 = new Cell(0, 2, 5);
            totalTests++; 
            exceptionVariable = "getterC10.getBoxNumber()"; 
            if (getterC10.getBoxNumber() != 1) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC11 = new Cell(0, 1, 4); 
            totalTests++; 
            exceptionVariable = "getterC11.getBoxNumber()"; 
            if (getterC11.getBoxNumber() != 1) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC12 = new Cell(0, 2, 3); 
            totalTests++; 
            exceptionVariable = "getterC12.getBoxNumber()"; 
            if (getterC12.getBoxNumber() != 1) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC13 = new Cell(0, 0, 5); 
            totalTests++; 
            exceptionVariable = "getterC13.getBoxNumber()"; 
            if (getterC13.getBoxNumber() != 1) {
                throw new Exception(); 
            }
            passedTests++; 


            //box number should be 2
            Cell getterC14 = new Cell(0, 0, 6); 
            totalTests++; 
            exceptionVariable = "getterC14.getBoxNumbner()"; 
            if (getterC14.getBoxNumber() != 2) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC15 = new Cell(0, 1, 7); 
            totalTests++; 
            exceptionVariable = "getterC15.getBoxNumbner()"; 
            if (getterC15.getBoxNumber() != 2) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC16 = new Cell(0, 2, 8); 
            totalTests++; 
            exceptionVariable = "getterC16.getBoxNumbner()"; 
            if (getterC16.getBoxNumber() != 2) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC17 = new Cell(0, 2, 6); 
            totalTests++; 
            exceptionVariable = "getterC17.getBoxNumbner()"; 
            if (getterC17.getBoxNumber() != 2) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC18 = new Cell(0, 0, 8); 
            totalTests++; 
            exceptionVariable = "getterC18.getBoxNumbner()"; 
            if (getterC18.getBoxNumber() != 2) {
                throw new Exception(); 
            }
            passedTests++; 


            //box number should be 3 
            Cell getterC19 = new Cell(0, 3, 0); 
            totalTests++; 
            exceptionVariable = "getterC19.getBoxNumber()"; 
            if (getterC19.getBoxNumber() != 3) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC20 = new Cell(0, 4, 1); 
            totalTests++; 
            exceptionVariable = "getterC20 .getBoxNumber()"; 
            if (getterC20.getBoxNumber() != 3) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC21 = new Cell(0, 5, 2); 
            totalTests++; 
            exceptionVariable = "getterC21.getBoxNumber()"; 
            if (getterC21.getBoxNumber() != 3) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC22 = new Cell(0, 5, 0); 
            totalTests++; 
            exceptionVariable = "getterC22.getBoxNumber()"; 
            if (getterC22.getBoxNumber() != 3) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC23 = new Cell(0, 3, 2); 
            totalTests++; 
            exceptionVariable = "getterC23.getBoxNumber()"; 
            if (getterC23.getBoxNumber() != 3) {
                throw new Exception(); 
            }
            passedTests++; 

            
            //box number should be 4 
            Cell getterC24 = new Cell(0, 3, 3); 
            totalTests++; 
            exceptionVariable = "getterC24.getBoxNumber()"; 
            if (getterC24.getBoxNumber() != 4) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC25 = new Cell(0, 4, 4);
            totalTests++; 
            exceptionVariable = "getterC25.getBoxNumber()"; 
            if (getterC25.getBoxNumber() != 4) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC26 = new Cell(0, 5, 5); 
            totalTests++; 
            exceptionVariable = "getterC26.getBoxNumber()"; 
            if (getterC26.getBoxNumber() != 4) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC27 = new Cell(0, 5, 3); 
            totalTests++; 
            exceptionVariable = "getterC27.getBoxNumber()"; 
            if (getterC27.getBoxNumber() != 4) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC28 = new Cell(0, 3, 5); 
            totalTests++; 
            exceptionVariable = "getterC28.getBoxNumber()"; 
            if (getterC28.getBoxNumber() != 4) {
                throw new Exception(); 
            }
            passedTests++; 
            

            //box number should be 5 
            Cell getterC29 = new Cell(0, 3, 6); 
            totalTests++; 
            exceptionVariable = "getterC29.getBoxNumber()"; 
            if (getterC29.getBoxNumber() != 5) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC30 = new Cell(0, 4, 7); 
            totalTests++; 
            exceptionVariable = "getterC30.getBoxNumber()"; 
            if (getterC30.getBoxNumber() != 5) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC31 = new Cell(0, 5, 8); 
            totalTests++; 
            exceptionVariable = "getterC31.getBoxNumber()"; 
            if (getterC31.getBoxNumber() != 5) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC32 = new Cell(0, 5, 6); 
            totalTests++; 
            exceptionVariable = "getterC32.getBoxNumber()"; 
            if (getterC32.getBoxNumber() != 5) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC33 = new Cell(0, 3, 8); 
            totalTests++; 
            exceptionVariable = "getterC33.getBoxNumber()"; 
            if (getterC33.getBoxNumber() != 5) {
                throw new Exception(); 
            }
            passedTests++; 
            

            //box number should be 6
            Cell getterC34 = new Cell(0, 6, 0); 
            totalTests++; 
            exceptionVariable = "getterC34.getBoxNumber()"; 
            if (getterC34.getBoxNumber() != 6) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC35 = new Cell(0, 7, 1); 
            totalTests++; 
            exceptionVariable = "getterC35.getBoxNumber()"; 
            if (getterC35.getBoxNumber() != 6) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC36 = new Cell(0, 8, 2); 
            totalTests++; 
            exceptionVariable = "getterC36.getBoxNumber()"; 
            if (getterC36.getBoxNumber() != 6) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC37 = new Cell(0, 8, 0); 
            totalTests++; 
            exceptionVariable = "getterC37.getBoxNumber()"; 
            if (getterC37.getBoxNumber() != 6) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC38 = new Cell(0, 6, 2); 
            totalTests++; 
            exceptionVariable = "getterC38.getBoxNumber()"; 
            if (getterC38.getBoxNumber() != 6) {
                throw new Exception(); 
            }
            passedTests++; 


            //box number should be 7 
            Cell getterC39 = new Cell(0, 6, 3); 
            totalTests++; 
            exceptionVariable = "getterC39.getBoxNumber()"; 
            if (getterC39.getBoxNumber() != 7) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC40 = new Cell(0, 7, 4); 
            totalTests++; 
            exceptionVariable = "getterC40.getBoxNumber()"; 
            if (getterC40.getBoxNumber() != 7) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC41 = new Cell(0, 8, 5); 
            totalTests++; 
            exceptionVariable = "getterC41.getBoxNumber()"; 
            if (getterC41.getBoxNumber() != 7) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC42 = new Cell(0, 8, 3); 
            totalTests++; 
            exceptionVariable = "getterC42.getBoxNumber()"; 
            if (getterC42.getBoxNumber() != 7) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC43 = new Cell(0, 6, 5); 
            totalTests++; 
            exceptionVariable = "getterC43.getBoxNumber()"; 
            if (getterC43.getBoxNumber() != 7) {
                throw new Exception(); 
            }
            passedTests++; 


            //box number should be 8 
            Cell getterC44 = new Cell(0, 6, 6); 
            totalTests++; 
            exceptionVariable = "getterC44.getBoxNumber()"; 
            if (getterC44.getBoxNumber() != 8) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC45 = new Cell(0, 7, 7); 
            totalTests++; 
            exceptionVariable = "getterC45.getBoxNumber()"; 
            if (getterC45.getBoxNumber() != 8) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC46 = new Cell(0, 8, 8);
            totalTests++; 
            exceptionVariable = "getterC46.getBoxNumber()"; 
            if (getterC46.getBoxNumber() != 8) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC47 = new Cell(0, 8, 6); 
            totalTests++; 
            exceptionVariable = "getterC47.getBoxNumber()"; 
            if (getterC47.getBoxNumber() != 8) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell getterC48 = new Cell(0, 6, 8); 
            totalTests++; 
            exceptionVariable = "getterC48.getBoxNumber()"; 
            if (getterC48.getBoxNumber() != 8) {
                throw new Exception(); 
            }
            passedTests++; 

            System.out.println("Passed Getter Test 4: Cell .getBoxNumber() returned correct outputs. "); 

        } catch (Exception e) {
            System.out.println("Failed Getter Test 4: Cell .getBoxNumber() returned incorrect outputs. Refer to method " + exceptionVariable + " for debugging purposes. \n"); 

            System.out.println("Total tests conducted: " + totalTests); 
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1); 
        }


        System.out.println("\n\n");
        


        //Test Setters 
        System.out.println("Testing Cell Setter Methods: "); 

        try {
            Cell setterC1 = new Cell(0, 0, 0); 
            totalTests++; 
            exceptionVariable = "setterC1.setValue(1)"; 
            setterC1.setValue(1);
            if (setterC1.getValue() != 1) {
                throw new Exception(); 
            }
            passedTests++; 

            Cell setterC2 = new Cell(1, 1, 1); 
            totalTests++; 
            exceptionVariable = "setterC2.setValue(0)"; 
            setterC2.setValue(0);
            if (setterC2.getValue() != 0) {
                throw new Exception(); 
            }
            passedTests++; 

            System.out.println("Passed Setter Test 1: Cell Setter methods correctly changed values. "); 

        } catch (Exception e) {
            System.out.println("Failed Setter Test 1: Cell Setter methods did not correctly change value. Refer to method " + exceptionVariable + " for debugging purposes. \n"); 

            System.out.println("Total tests conducted: " + totalTests); 
            System.out.println("Total tests passed: " + passedTests); 

            System.exit(1); 
        }

        System.out.println("\n\n"); 


        //Testing Cell Other methods:

        System.out.println("Testing Cell Other Methods: "); 

        try {
            Cell otherC1 = new Cell(0, 1, 1); 

            


        } catch (Exception e) {
            // TODO: handle exception
        }

        /*
         * Remaining to test:
         * 
         * finalValue()
         * addPotentialValue()
         * removePotentialValue() 
         * 
         * These can be tested together - - add and remove, and once there is only 1 value left, test finalValue()
         * 
         * 
         * 
         * fillPotentialValue() is integration testing - - first test Section class then come back to test this method 
         * 
         * 
         * 
         * toString - - should be easy at the end 
         */



    }
    
}
