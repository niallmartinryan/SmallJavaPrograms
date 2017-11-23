
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 12/10/15 20:43:36
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
        System.out.println("Hello");									// GET RID OF THIS LATER!!!!!!!!!!!!!!!!!!!!!!!
     }
     @Test
     public void testIsEmpty(){
        DoublyLinkedList<Integer> testDLL =  new DoublyLinkedList<Integer>();
        boolean expectedResult = true;
        assertEquals("Checking isEmpty for an empty list which should return true", expectedResult, testDLL.isEmpty());

        testDLL.insertBefore(0, 2);
        expectedResult = false;
        assertEquals("Checking isEmpty for a list containing one item", expectedResult, testDLL.isEmpty());
     }
     @Test
     public void testGet(){
        DoublyLinkedList<Integer> testDLL =  new DoublyLinkedList<Integer>();
        assertEquals("Checking Get method for an empty list", null , testDLL.get(0));
        testDLL.insertBefore(0 ,10);
        testDLL.insertBefore(0 , 5);
        testDLL.insertBefore(0 , 7);
        assertSame("Checking get method for 1 element list accessing first element", 7, testDLL.get(0));
        assertSame("Checking get method for 3 elements get third element", 10, testDLL.get(2));
        assertEquals("Checking get method for 1 element list accessing before list", null, testDLL.get(-5));

        assertEquals("Checking get method for 1 element list accessing after list", null, testDLL.get(7));
        
     }
     @Test
     public void testDeleteAt(){
    	 DoublyLinkedList<Integer> testDLL =  new DoublyLinkedList<Integer>();
         assertEquals("Checking deleteAt method for an empty list", false,testDLL.deleteAt(0));
         testDLL.insertBefore(0, 10);
         assertEquals("Checking deleteAt method for 1 elem list, param out of bounds", false, testDLL.deleteAt(10));
    	 assertEquals("Checking deleteAt method for 1 elem list, param in bounds", true, testDLL.deleteAt(0));
         testDLL.insertBefore(0, 10);
         testDLL.insertBefore(5, 1);
         assertEquals("Checking deleteAt method for 1 elem list, param is end of list",true ,testDLL.deleteAt(1) ); // just checks if right result not actual list
         testDLL.insertBefore(5, 1);		// add back in
         testDLL.insertBefore(0, 5);		// 3 elems in now
    	 assertEquals("Checking deleteAt method for 1 elem list, param is in middle of list", true, testDLL.deleteAt(1));
    	 //now to check its actually deleting stuff and leaving it alone.
    	 testDLL.deleteAt(-5);
    	 assertEquals("Checking deleteAt, that it doesnt change list if false", "5,1",testDLL.toString() );
    	 testDLL.deleteAt(0);
    	 assertEquals("Checking deleteAt, that it changes list accordingly when true", "1", testDLL.toString());
    	 testDLL.insertBefore(0 , 20);
    	 testDLL.deleteAt(1);
     }
     @Test
     public void testPush(){
    	 DoublyLinkedList<Integer> testDLL =  new DoublyLinkedList<Integer>();
    	 testDLL.push(500);
    	 testDLL.push(50);
    	 assertEquals("Checking push method, one element", "50,500", testDLL.toString());
    	 testDLL.push(1);
    	 assertEquals("Checking push method, with 2 elements already there", "1,50,500", testDLL.toString());
    	 
     }
     @Test
     public void testPop(){
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.push(50);
    	 testDLL.push(10);
    	 testDLL.pop();
    	 assertEquals("Checking pop method, one element","50",testDLL.toString() );
    	 testDLL.pop();
    	 assertNull("checking if it is null", testDLL.pop());
     }
     @Test
     public void testEnqueue(){
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.enqueue(10);
    	 assertEquals("Checking enqueue method, add one element in empty list","10",testDLL.toString());
    	 testDLL.enqueue(500);
    	 testDLL.enqueue(5000);
    	 assertEquals("Checking enqueue method, add two elements in list","5000,500,10" ,testDLL.toString());
    	 
     }
     @Test
     public void testDequeue(){
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 
    	 assertNull("Checking dequeue method, remove element from empty queue",testDLL.dequeue());
    	 testDLL.enqueue(50);
    	 testDLL.enqueue(10);
    	 testDLL.dequeue();
    	 assertEquals("Checking that the element is removed","10", testDLL.toString());
    	 assertSame("Checking that the correct element is returned",10 , testDLL.dequeue());
    	 
     }
     // DO I REALLY NEED TO TEST THE TOSTRING METHOD.. HMMM!!
     @Test
     public void testToString(){
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.insertBefore(0, 20);
    	 testDLL.insertBefore(1, 21);
    	 testDLL.insertBefore(0, 22);
    	 assertEquals("Checking the toString method, 3 elements","22,20,21", testDLL.toString());
     }
     @Test 
     public void testInsertNode(){
    	 DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	 testDLL.insertNode(10);
    	 assertEquals("Checking the insertNode method, no elements in list", "10", testDLL.toString());
    	 testDLL.insertNode(25);
    	 testDLL.insertNode(30);
    	 assertEquals("Checking the insertNode method,elems in list","30,25,10", testDLL.toString());
    	 
     }
    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.

}


