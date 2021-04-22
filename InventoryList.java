

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
 * This class models the singly linked list data structure that stores elements of type Box.
 * 
 * @author elgini neci
 *
 */
public class InventoryList {


  private LinkedBox head = null;
  private LinkedBox tail = null;
  private int size;
  private int yellowCount;
  private int blueCount;
  private int brownCount;

  /**
   * Returns the size of this list
   * 
   * @return the size of this LinkedBoxList
   */
  public int size() {

    if (head == null && tail == null) {
      return 0;
    }
    size = 1;
    LinkedBox curr = head;
    while (curr.getNext() != null) {
      size++;
      curr = curr.getNext();
    }
    return size;
  }

  /**
   * Checks whether this LinkedBoxList is empty
   * 
   * @return true if this LinkedBoxList is empty, false otherwise
   */
  public boolean isEmpty() {
    if (size() == 0) {
      return true;
    }

    return false;

  }

  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
    yellowCount = 0;
    brownCount = 0;
    blueCount = 0;
  }

  /**
   * Adds a brown box at the end of this inventory list
   * 
   * @param brownBox new brown box to be added to this list
   */
  public void addBrown(Box brownBox) {
    if (brownBox == null || Color.BROWN == null) {
      throw new IllegalArgumentException("Brownbox is null");
    }
    LinkedBox newNode = new LinkedBox(brownBox);
    if (head == null && tail == null) { // checks if the list is empty
      head = newNode;
      tail = newNode;

    } else {
      tail.setNext​(newNode);
      tail = newNode;

    }
    brownCount++;
    size++;
  }

  /**
   * Adds a new yellow box at the head of this list
   * 
   * @param yellowBox new box to be added to this list
   */
  public void addYellow(Box yellowBox) {
    if (yellowBox == null || Color.YELLOW == null) {
      throw new IllegalArgumentException("YellowBox is null");
    }

    LinkedBox newNode = new LinkedBox(yellowBox);
    if (head == null && tail == null) { // checks if the list is empty
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext​(head);
      head = newNode;

    }
    yellowCount++;
    size++;
  }

  /**
   * Adds a new blue box at the top of blue boxes if the list contains any blue box. Blue boxes must
   * be added at the buttom of yellow boxes and at the top of all the brown boxes if any. This means
   * that a new blue box must be added at index yellowCount.
   * 
   * @param blueBox new box to be added to this list
   */
  public void addBlue(Box blueBox) {
    if (blueBox == null) {
      throw new IllegalArgumentException("BlueBox is null");
    }

    LinkedBox currNode = head;
    LinkedBox newNode = new LinkedBox(blueBox);
    if (head == null && tail == null) { // checks if the list is empty
      head = newNode;
      tail = newNode;
    } else {
      if (yellowCount == 0) {
        newNode.setNext​(head);
        head = newNode;
      } else if (brownCount == 0 && blueCount == 0) {
        tail.setNext​(newNode);
        tail = newNode;
      } else {
        for (int i = 0; i < yellowCount - 1; i++) {
          currNode = currNode.getNext();
        }
        newNode.setNext​(currNode.getNext());
        currNode.setNext​(newNode);

      }
    }
    size++;
    blueCount++;
  }

  /**
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index position within this list
   * @return the box stored at position index of this list
   */
  public Box get​(int index) {

    size = 0;
    LinkedBox curr = head;
    while (curr.getNext() != null && size < index) {
      size++;
      curr = curr.getNext();
    }
    if (size == index) {
      return curr.getBox();
    }
    return null;

  }

  /**
   * Removes and returns the box at the head of this list if its color is yellow
   * 
   * @return a reference to the removed box
   */
  public Box removeYellow() {
    if (yellowCount == 0) {
      throw new java.util.NoSuchElementException("There is no yellow box");
    } else {
      LinkedBox removeNode = head;
      LinkedBox sucNode = head.getNext();
      head = sucNode;
      if (sucNode == null) {
        tail = null;
      }
      yellowCount--;
      size--;
      return removeNode.getBox();
    }

  }

  /**
   * Removes and returns the box at the head of this list if its color is brown
   * 
   * @return a reference to the removed box
   */
  public Box removeBrown() {
    if (brownCount == 0) {
      throw new java.util.NoSuchElementException("There is no brown box");
    }
    LinkedBox removeNode = tail;
    if (size() == 1) {
      head = null;
      tail = null;
    } else {
      LinkedBox currNode = head;
      for (int i = 0; i < size - 2; i++) {
        currNode = currNode.getNext();
      }
      tail = currNode;
      tail.setNext​(null);

    }
    brownCount--;
    size--;
    return removeNode.getBox();

  }


  /**
   * Removes and returns a box given its inventory number from this list
   * 
   * @param inventoryNumber inventory number of the box to be removed from this list
   * @return a reference to the removed element
   */
  public Box removeBox​(int inventoryNumber) {
  
    LinkedBox tempNode = head;
    int temp=0;
    for(int i=0;i<size;i++) {
if(inventoryNumber==tempNode.getBox().getInventoryNumber()) {
  temp++;
}
tempNode=tempNode.getNext();
    }
    if(temp==0) {
      throw new java.util.NoSuchElementException ("There is no box with that number");
    }
    
    if (inventoryNumber == head.getBox().getInventoryNumber()) {
      LinkedBox currNode = head;
      LinkedBox sucNode = head.getNext();
      head = sucNode;
      if (sucNode == null) {
        tail = null;
      }
      size--;
      if(currNode.getBox().getColor()==Color.BROWN) {
        brownCount--;
      }else if(currNode.getBox().getColor()==Color.YELLOW){
        yellowCount--;
      }else {
        blueCount--;
      }   
      return currNode.getBox();
      
    } else if (inventoryNumber == tail.getBox().getInventoryNumber()) {
      LinkedBox currNode = head;
      for (int i = 0; i < size-2; i++) {
        currNode = currNode.getNext();
      }
      LinkedBox removeNode=currNode.getNext();
      tail = currNode;
      currNode.setNext​(null);
      size--;
      if(removeNode.getBox().getColor()==Color.BROWN) {
        brownCount--;
      }else if(removeNode.getBox().getColor()==Color.YELLOW){
        yellowCount--;
      }else {
        blueCount--;
      }
      
      return removeNode.getBox();
    }else {
      LinkedBox currNode = head;
      int index=0;
      for (int i = 0; i < size; i++) {
        if (inventoryNumber == currNode.getBox().getInventoryNumber()) {
          break;
        }
        index++;
        currNode=currNode.getNext();
      }
     
      LinkedBox preNode=head;
      for (int i = 0; i < index-1; i++) {
        preNode=preNode.getNext();
      }
      preNode.setNext​(currNode.getNext());
      size--;
      if(currNode.getBox().getColor()==Color.BROWN) {
        brownCount--;
      }else if(currNode.getBox().getColor()==Color.YELLOW){
        yellowCount--;
      }else {
        blueCount--;
      }
      
      return currNode.getBox();
    }

  }

  /**
   * Returns the number of brown boxes stored in this list
   * 
   * @return the brownCount
   * 
   */
  public int getBrownCount() {
    return this.brownCount;
  }

  /**
   * Returns the number of yellow boxes stored in this list
   * 
   * @return the YellowCount
   * 
   */
  public int getYellowCount() {
    return this.yellowCount;
  }

  /**
   * Returns the number of blue boxes stored in this list
   * 
   * @return the BlueCount
   * 
   */
  public int getBlueCount() {
    return this.blueCount;
  }

 

  /**
   * Returns a String representation of the contents of this list
   * 
   * @return a String representation of the content of this list. If this list is empty, an empty
   *         String ("") will be returned.
   */
  @Override
  public java.lang.String toString() {
    if (size == 0) {
      return "";
    }
    String elements = "";
    LinkedBox currNode = head;
    for (int i = 0; i < size(); i++) {
      elements += currNode;
      currNode = currNode.getNext();
    }



    return elements;
  }
}
