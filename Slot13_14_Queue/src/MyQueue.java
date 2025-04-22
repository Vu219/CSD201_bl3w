/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class MyQueue {

    Node head, tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
    
    public void enqueue(int key) {
        Node newNode = new Node(key);
        if(this.isEmpty()) {
            this.head = this.tail = newNode;
        }else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
    
    public int dequeue() {
        if(!this.isEmpty()) {
            int tmp = this.head.info;
            
            this.head = this.head.next;
            if(this.head == null) {
                this.tail = null;
            }  
            
            return tmp;
        }else {
            return Integer.MIN_VALUE;
        }
    }
    
    public int front() {
        if(!this.isEmpty()) {
            return this.head.info;
        }else {
            return Integer.MIN_VALUE;
        }
    }
    
    public void display() {
        if(!this.isEmpty()) {
            Node current = this.head;
            while(current != null) {
                System.out.print(current.info + " ");
                current = current.next;
            }
        }
    }
}
