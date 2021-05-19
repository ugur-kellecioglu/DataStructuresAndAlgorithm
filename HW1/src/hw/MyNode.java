/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

/**
 * Title: Stack implementation with custom linked list implementation 
 * Part 1
 * @author Uğur Kellecioğlu
 * ID: ***
 * CLASS: CMPE 242
 * SECTION: 1
 * Assignment: 1
 * Description: This class define the node that we need in our linked list to store data and pointers.
 * 
 */
public class MyNode<Item>{
    
    private Item data;
    private MyNode next;
    
    public MyNode(Item data){
        this.data = data;
        next = null;
    }

    public Item getData() {
        return data;
    }

    public void setData(Item data) {
        this.data = data;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
    
}
