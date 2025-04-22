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
    
    public void enqueue(String id, String name, int age, double gpa) {
        Student newStudent = new Student(id, name, age, gpa);
        Node newNode = new Node(newStudent);
        
        if(this.isEmpty()) {
            this.head = this.tail = newNode;
        }else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
    
    public Student dequeue() {
        if(!this.isEmpty()) {
            Student value = this.head.info;
            this.head = this.head.next;
            if(this.head == null) {
                this.tail = null;
            } 
            return value;
        }else {
            return null;
        }
    }
    
    public Student front() {
         if(!this.isEmpty()) {
             Student value = this.head.info;
             return value;
         }else {
             return null;
         }
    }
    
    public void display() {
        if(!this.isEmpty()) {
            Node current = this.head;
            while(current != null) {
                System.out.print(current.info + "   ");
                current = current.next;
            }
        }
    }
    
    public void HighGPA() {
        Node current = this.head;
        Node MaxGPA = this.head;
        
        while(current != null){
            if(current.info.getGpa() > MaxGPA.info.getGpa()) {
                MaxGPA = current;
            }
            current = current.next;
        }
        
        System.out.println(MaxGPA.info);
    }
}
