
package student;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;



public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
       
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSaveStudent() {
       String simulatedInput = "12345\nJohn Doe\n20\njohn.doe@example.com\nComputer Science\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
         // the above code simulates the input from scanners
        
       
     
        ArrayList studentDetails = Student.saveStudent();
        // that method returns an arraylist that we store into this arraylist
       
      
        assertEquals("12345", studentDetails.get(0));
        assertEquals("John Doe", studentDetails.get(1));
        assertEquals(20, studentDetails.get(2));
        assertEquals("john.doe@example.com", studentDetails.get(3));
        assertEquals("Computer Science", studentDetails.get(4));
    }


    @Test
    public void testSearchStudent() {
        String simulatedInput = "67891";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        Student.studentDetails.add("12345");
        Student.studentDetails.add("Simphiwe");
        Student.studentDetails.add(20);
        Student.studentDetails.add("thatGuy@example.com");
        Student.studentDetails.add("Law");
        
        Student.studentDetails.add("10466");
        Student.studentDetails.add("Jonn");
        Student.studentDetails.add(27);
        Student.studentDetails.add("john.doe@example.com");
        Student.studentDetails.add("Computer Science");
        
        Student.studentDetails.add("67891");
        Student.studentDetails.add("Bolokwa");
        Student.studentDetails.add(19);
        Student.studentDetails.add("thatGurl@example.com");
        Student.studentDetails.add("Communication");
        
        int value = Student.searchStudent();
         
         if(value != -1){
         
             System.out.println("Student has been found");
         }
         
         
          assertFalse(0>value);
        
        
        
    }
    
    @Test
    public void testSearchStudent_StudentNotFouund() {
        String simulatedInput = "1";//invalid student number 
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        
        
        Student.studentDetails.add("12345");
        Student.studentDetails.add("Simphiwe");
        Student.studentDetails.add(20);
        Student.studentDetails.add("thatGuy@example.com");
        Student.studentDetails.add("Law");
        
        Student.studentDetails.add("10466");
        Student.studentDetails.add("Jonn");
        Student.studentDetails.add(27);
        Student.studentDetails.add("john.doe@example.com");
        Student.studentDetails.add("Computer Science");
        
        Student.studentDetails.add("67891");
        Student.studentDetails.add("Bolokwa");
        Student.studentDetails.add(19);
        Student.studentDetails.add("thatGurl@example.com");
        Student.studentDetails.add("Communication");
        
         int value = Student.searchStudent();
         
         if(value == -1){
         
             System.out.println("Student not found");
         }
         
         
          assertEquals(-1, value);
     }


    @Test
    public void testDeleteStudent() {
        String simulatedInput = "12345";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        Student.studentDetails.add("12345");
        Student.studentDetails.add("Simphiwe");
        Student.studentDetails.add(20);
        Student.studentDetails.add("thatGuy@example.com");
        Student.studentDetails.add("Law");
       
        Student.deleteStudent();
        
        assertEquals(0, Student.studentDetails.size());
    }


    @Test
    public void testDeleteStudent_StudentNotFound() {
        
        String simulatedInput = "12";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        
        Student.studentDetails.add("12345");
        Student.studentDetails.add("Simphiwe");
        Student.studentDetails.add(20);
        Student.studentDetails.add("thatGuy@example.com");
        Student.studentDetails.add("Law");
       
        Student.deleteStudent();
        
        assertFalse(0>Student.studentDetails.size());
        
        if(!Student.studentDetails.isEmpty()){
            System.out.println("The Student could not be found");
        
        }
        
    }
    
     @Test
    public void testStudentAge_StudentAgeValid(){
         
        String simulatedInput = "12345\nJohn Doe\n20\njohn.doe@example.com\nComputer Science\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        
        ArrayList<Object> studentDetails = Student.saveStudent();

     
        assertEquals(20, studentDetails.get(2));

    }
    
     @Test
    public void testStudentAge_StudentAgeInvalid() {
// Simulated input with an invalid age (15)
        String simulatedInput = "12345\nJohn Doe\n15\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            // Call the saveStudent method
            Student.saveStudent();
            fail("Expected the method to continue prompting for valid input or throw an exception.");
        } catch (NoSuchElementException e) {
            // Test passes if the method throws NoSuchElementException
        }
    

    }
    
     @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        
         // Simulated input with an invalid character ('A') for age and then terminates to check handling
        String simulatedInput = "12345\nJohn Doe\nA\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Since the loop requires a valid age to exit, we only test up to the invalid input
        // and then assert if the method is correctly handling it

        try {
            Student.saveStudent();
            fail("Expected the method to continue prompting for valid input.");
        } catch (Exception e) {
            // Assert that the exception is related to invalid input handling
            assertTrue(e instanceof InputMismatchException || e instanceof NoSuchElementException);
        }
    }
}
