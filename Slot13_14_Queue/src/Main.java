/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.enqueue(10);
        mq.enqueue(17);
        mq.enqueue(3);
        mq.enqueue(8);
        mq.display();
        
        System.out.println("\n-----------\n");
        mq.dequeue();
        mq.display();
        
        System.out.println("\n-----------\n");
        mq.front();
        mq.display();
    }
}
