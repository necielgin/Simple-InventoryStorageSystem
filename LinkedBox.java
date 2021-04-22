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
 * This class represents a linked box node
 * 
 * @author elgini neci
 *
 */
public class LinkedBox {


  private Box box;
  private LinkedBox next;


  /**
   * Creates a new LinkedBox node with given box and next fields
   * 
   * @param box  the box carried by this linked box
   * @param next reference to the next linked box in the list
   */
  public LinkedBox(Box box, LinkedBox next) {
    this.box = box;
    this.next = next;
  }

  /**
   * Creates a new LinkedBox with a specified box and null as next field
   * 
   * @param box carried by this linked box
   */
  public LinkedBox(Box box) {
    this.box = box;
    this.next = null;

  }

  /**
   * Returns the next linked box node
   * 
   * @return the next
   */
  public LinkedBox getNext() {
    return this.next;
  }

  /**
   * Sets the link to the next linked box node
   * 
   * @param next the next to set
   */
  public void setNext​(LinkedBox next) {
    this.next = next;
  }

  /**
   * Returns the data field box
   * 
   * @return the box
   */
  public Box getBox() {
    return this.box;
  }

  /**
   * Returns a String representation of this Linked box.
   */
  @Override
  public java.lang.String toString() {

    if (next != null) {
      return box.toString() + " -> ";
    }
    else {
      return box.toString() + " -> END" ;
    }

  }
}
