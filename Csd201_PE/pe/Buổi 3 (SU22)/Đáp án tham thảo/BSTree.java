/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
        
    void insert(String xType, int xRate, int xWing) {
    //You should insert here statements to complete this function
        if (xType.charAt(0) == 'B') {
            return;           			
        }
        Node q = new Node(new Bird(xType, xRate, xWing));
        if (isEmpty()) {
            root = q;
            return;
        }
        Node p = root;
        Node f = null; // f is the father of p
        while (p != null) {
            if (xRate == p.info.rate) {
                return;
            } // end if
            f = p;
            if (xRate < p.info.rate) {
                p = p.left;
            } else {
                p = p.right;
            }
        } // end while

        if (xRate < f.info.rate) {
            f.left = q;
        } else {
            f.right = q;
        }
   }
  
//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        this.breadth2(root, f);
        
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.wing>4)
                fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    
    

//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        this.postOrder3(root, f);
        Node fp = this.searchParent(node3);
        this.deleteCopying(fp.info.rate);
       
        
        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    int count3=0;
    Node node3 = null;
     void postOrder3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder3(p.left, f);
        postOrder3(p.right, f);
        count3++;
        if(count3==4){
            node3=p;
            return;
        }
    }
     
     Node searchParent(Node a) {
        if (a == null)
            return null;
        Node p = root, f = null;
        while (p != null && p != a) {
            f = p;
            if (p.info.rate > a.info.rate)
                p = p.left;
            else 
                p = p.right;
        }
        return f;
    }
    
     public void deleteCopying(int x) { //Delete Node with info = x
        if (isEmpty()) {
            return;
        }

        Node p = root;
        Node f = null;
        while (p != null) {
            if (p.info.rate == x) {
                break;
            }
            f = p;
            if (x < p.info.rate) {
                p = p.left;
            } else {
                p = p.right;
            }
        } //end while
        if (p == null) {
            return;
        }
        // p has no children
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
                return;
            }
            if (f.left == p) {
                f.left = null;
                return;
            } else {
                f.right = null;
                return;
            }
        }
        // p has only left child
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = root.left;
                return;
            }
            if (f.left == p) {
                f.left = p.left;
                return;
            } else {
                f.right = p.left;
                return;
            }
        }
        // p has only right child
        if (p.left == null && p.right != null) {
            if (f == null) {
                root = root.right;
                return;
            }
            if (f.left == p) {
                f.left = p.right;
                return;
            } else {
                f.right = p.right;
                return;
            }
        }
        // p has 2 children
        if (p.left != null && p.right != null) {
            Node q = p.left;
            Node rp = q;
            Node fr = null;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right;
            } //end while;
            p.info = rp.info;
            if (fr == null) {
                p.left = q.left;

            } else {
                fr.right = rp.left;
            }

            return;
        }

    }
    
   
//=============================================================
    
    
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        this.postOrder3(root, f);
       int k = this.height(node3);
       node3.info.wing = k;
        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    public int height(Node p) {
        if (p == null) {
            return 0;
        }
        int l = height(p.left) + 1;
        int r = height(p.right) + 1;
        return (l > r) ? l : r;
    }
    
    

}
