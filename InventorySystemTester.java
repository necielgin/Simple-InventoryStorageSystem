import java.util.NoSuchElementException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Inventory Storage System
// Course: CS 300 Fall 2020
//
// Author: Elgini Neci
// Email: neci@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
/**
 *
 * This class tests the implementation of the other classes.
 * 
 * @author elgini neci
 *
 */
public class InventorySystemTester {

  /**
   * This method should test and make use of at least one LinkedBox constructor, an accessor
   * (getter) method, and a mutator (setter) method.
   * 
   * @return true if all the test are passed
   */
  public static boolean testLinkedBox() {
    Box.restartNextInventoryNumber();
    LinkedBox node=new LinkedBox(new Box(Color.YELLOW));
    if(node.getNext()!=null) {
      return false;
    }
    if(node.getBox().getColor()!=Color.YELLOW||node.getBox().getInventoryNumber()!=1) {
      return false;
    }
    
    return true;

  }

  /**
   * checks for the correctness of the InventoryList.clear() method
   * 
   * @return true if all the test passed
   */
  public static boolean testClear() {
    Box.restartNextInventoryNumber();
    InventoryList list = new InventoryList();
    list.addYellow(new Box(Color.YELLOW));
    list.addYellow((new Box(Color.YELLOW)));
    list.addBlue(new Box(Color.BLUE));
    list.addBlue(new Box(Color.BLUE));// must add YELLOW 5 to the head of the list.
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    list.addBlue(new Box(Color.BLUE));
    list.clear();
    if (list.size() != 0) {
      return false;
    }
    return true;
  }

  /**
   * checks for the correctness of the InventoryList.addYellow(),InventoryList.addBlue(), and
   * InventoryList.addBrown() methods
   * 
   * @return true if all the test passed
   */
  public static boolean testAddBoxes() {
    Box.restartNextInventoryNumber();
    InventoryList list = new InventoryList();
    list.addYellow(new Box(Color.YELLOW));
    list.addYellow((new Box(Color.YELLOW)));
    list.addBlue(new Box(Color.BLUE));
    list.addBlue(new Box(Color.BLUE));// must add YELLOW 5 to the head of the list.
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    list.addBlue(new Box(Color.BLUE));
    System.out.print(list);
    
    if (list.size() != 7) {
      return false;
    }
    return true;

  }

  /**
   * checks for the correctness of the InventoryList.removeBox() InventoryList.removeYellow(), and
   * InventoryList.remove Brown() methods
   * 
   * @return true if all the test passed
   */
  public static boolean testRemoveBoxes() {
    Box.restartNextInventoryNumber();
    InventoryList list = new InventoryList();
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    list.removeBrown();
    list.addYellow(new Box(Color.YELLOW));
    list.addYellow(new Box(Color.YELLOW));
    list.removeYellow();
    list.addYellow(new Box(Color.YELLOW));
    list.addBlue(new Box(Color.BLUE));
    list.removeBox​(2);
    System.out.print(list);
    if (list.size() != 6) {
      return false;
    }
    return true;
  }

  /**
   * checks for the correctness of the InventoryList.get() method
   * 
   * @return true if all the test passed
   */
  public static boolean testGetBoxes() {
    Box.restartNextInventoryNumber();
    InventoryList list = new InventoryList();
    list.addYellow(new Box(Color.YELLOW));
    list.addYellow((new Box(Color.YELLOW)));
    list.addBlue(new Box(Color.BLUE));
    list.addBlue(new Box(Color.BLUE));// must add YELLOW 5 to the head of the list.
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    list.addBlue(new Box(Color.BLUE));
    list.get​(0);
    return true;
  }

  /**
   * a test suite method to run all your test methods
   * 
   * @return true if all the test passed
   */
  public static boolean runAllTests() {
   if(testGetBoxes()&&testRemoveBoxes()&&testAddBoxes()&&testClear()&&testLinkedBox()) {
    
     System.out.println("All test passed");
     return true;
   }
    return false;
  }

  public static void main(String[] args) {
    System.out.print(runAllTests());
    demo();
  }

  /**
   * Helper method to display the size and the count of different boxes stored in a list of boxes
   * 
   * @param list a reference to an InventoryList object
   * @throws NullPointerException if list is null
   */
  private static void displaySizeCounts(InventoryList list) {
    System.out.println("  Size: " + list.size() + ", yellowCount: " + list.getYellowCount()
        + ", blueCount: " + list.getBlueCount() + ", brownCount: " + list.getBrownCount());
  }

  /**
   * Demo method showing how to use the implemented classes in P07 Inventory Storage System
   * 
   * @param args input arguments
   */
  public static void demo() {
    // Create a new empty InventoryList object
    InventoryList list = new InventoryList();
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add a blue box to an empty list
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 1
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 2 at the head of the list
    System.out.println(list); // prints list's content
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 3
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 4
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 5 at the head of the list

    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add more boxes to list and display its contents
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 6 at the end of the list
    System.out.println(list); // prints list's content

    displaySizeCounts(list); // displays list's size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 7 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts

    list.removeBrown(); // removes BROWN 7 from the list

    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 8
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 6 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeYellow(); // removes YELLOW 5
    System.out.println(list); // prints list's content
    list.removeBox​(3); // removes BLUE 3 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    try {
      list.removeBox​(25); // tries to remove box #25
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // remove all yellow boxes
    while (list.getYellowCount() != 0) {
      list.removeYellow();
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox​(1); // removes BLUE 1 from the list -> empty list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 9 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox​(8); // removes BLUE 8 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 9 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 10 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox​(10); // removes YELLOW 10 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
  }
}
