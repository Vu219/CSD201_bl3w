/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Mytree {

    Node root;

    public Mytree() {
        this.root = null;
    }

    public void load() {
        insert(20);
        insert(10);
        insert(30);
        insert(5);
        insert(15);
        insert(25);
        insert(35);
        insert(100);
    }
    
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node p, int value) {
        if (p == null) {
            p = new Node(value);
        } else if (value < p.info) {
            p.left = insertRec(p.left, value);
        } else if (value > p.info) {
            p.right = insertRec(p.right, value);
        }
        return p;
    }

    public void visit(Node p) {
        System.out.println(p.info + " ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        } else {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        } else {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        } else {
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }

    int search(Node p, int x) {
        //base case
        if (p == null) {
            return 0; //ko tim thay
        }
        if (p.info == x) {
            return 1; //tim thay
        }
        
        //đệ quy
        if(x < p .info) {
            return search(p.left, x);
        }else {
            return search(p.right, x);
        }
    }
    
    private int MaxlLevel (Node p) {
        if(p == null) {
            return 0;
        }
        int MaxLeftlevel = MaxlLevel(p.left);
        int MaxRightLevel = MaxlLevel(p.right);
        
        return Math.max(MaxLeftlevel, MaxRightLevel) +1;
    }
    
    //1. Test f1 - compute height (chiều cao của cây là maxLevel -1)
    public int f1() {
        return MaxlLevel(root) - 1;
    }
    
    private int CountNode(Node p) {
        if(p == null) {
            return 0;
        }
        return 1 + CountNode(p.left) + CountNode(p.right);
        //Chỉ đếm > 5;
        //int x = ((p.info>5) ? 1 : 0);
        //return x + countNodes(p.left) + countNodes(p.right);
    }
    
    //2. Test f2 - count nodes
    public int f2() {
        return CountNode(root);
    }
    
    private int CountLeafNodes(Node p) {
        if(p == null) {
            return 0;
        }
        int x = (p.left == null && p.right == null) ? 1 : 0;
        return x + CountLeafNodes(p.left) + CountLeafNodes(p.right);
    }
    
    //3 Test f3 - count leaf nodes
    public int f3() {
        return CountLeafNodes(root);
    }
    
    private int SumNodes(Node p) {
        if(p == null) {
            return 0;
        }
        return p.info + SumNodes(p.left) + SumNodes(p.right);
    }
    
    //4. Test f4 - compute sum of nodes
    public int f4() {
        return SumNodes(root);
    }
    
    //5. Test f5 - Pre-Order
    public void f5() {
        preOrder(root);
    }
    
    //6. Test f6 - InOrder
    public void f6() {
        inOrder(root);
    }
    
    //7. Test f7 - Post-Order
    public void f7() {
        postOrder(root);
    }
    
    //8. Test f8 - Search
    public int f8(int n) {
        return search(root, n);
    }
}
