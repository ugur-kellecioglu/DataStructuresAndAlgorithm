/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

/**
 * Title: Stack implementation with custom linked list implementation Part 1
 *
 * @author Uğur Kellecioğlu ID: *** CLASS: CMPE 242 SECTION: 1
 * Assignment: 1 Description: This class define a stack adt based on linked list
 *
 */
public class MyStack<Item> {

    private MyLinkedList myList;

    public MyStack() {
        myList = new MyLinkedList();
    }

    public boolean isEmpty() {
        
        //--------------------------------------------------------------
        // Summary: If list's head is null that means stack is empty..
        // Precondition: myList is an object from MyLinkedList class
        // Postcondition: none.
        //--------------------------------------------------------------
        
        if (myList.getHead() == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        
        //--------------------------------------------------------------
        // Summary: If list's head is not null create a pointer that iterating through stack and increase count by one.
        // Precondition: myList is an object
        // Postcondition: tmp is an iterator, count  variable returned.
        //--------------------------------------------------------------
        
        if (isEmpty()) {
            return 0;
        } else {
            int count = 0;
            MyNode tmp = myList.getHead();
            while (tmp != null) {
                count++;
                tmp = tmp.getNext();
            }
            return count;
        }

    }

    public void push(Item item) {
        
        //--------------------------------------------------------------
        // Summary: if there are no items in stack it should be head,
        //         if there are  items in stack it should be the new head
        // Precondition: myList is an object
        // Postcondition: newNode is an myNode object
        //--------------------------------------------------------------
        
        MyNode newNode = new MyNode(item);
        if (myList.getHead() == null) {
            myList.setHead(newNode);
        } else {
            newNode.setNext(myList.getHead());
            myList.setHead(newNode);
        }

    }

    public Item pop() {
        
        //--------------------------------------------------------------
        // Summary: return the item at the top and remove it from stack
        // Precondition: myList is an MyLinkedList object
        // Postcondition: i is a Item and head of the stack is changed.
        //--------------------------------------------------------------
        
        Item i = (Item) myList.getHead().getData();
        myList.setHead(myList.getHead().getNext());
        return i;

    }

    public Item peek() {
        
        //--------------------------------------------------------------
        // Summary: it shows the item at the top of the stack
        // Precondition: myList is an MyLinkedList object
        // Postcondition: head of the list is returned
        //--------------------------------------------------------------
        
        return (Item) myList.getHead().getData();
    }

    public void print() {
        
        //--------------------------------------------------------------
        // Summary: It iterate through the stack and print them
        // Precondition: myList is an MyLinkedList object
        // Postcondition: tmp is an MyNode pointer.
        //--------------------------------------------------------------
        
        MyNode tmp = myList.getHead();
        while (tmp != null) {
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }
    
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        System.out.println(ms.isEmpty());
        ms.push(1);
        ms.push(2);
        System.out.println(ms.isEmpty());

        ms.pop();
        System.out.println(ms.isEmpty());
    }

}
