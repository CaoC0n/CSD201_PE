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
        if (xType.charAt(0) == 'B')
            return;
        Bird b = new Bird(xType, xRate, xWing);
        Node q = new Node(b);
        if (isEmpty()) {
            root = q;
            return;
        }
        Node p = root, f = null;
        while (p != null) {
            if (p.info.rate == xRate) 
                return;
            
            f = p;
            if (p.info.rate > xRate) 
                p = p.left;
            else
                p = p.right;
        }
        
        if (f.info.rate > xRate) 
            f.left = q;
        else
            f.right = q;
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
        //breadth(root, f);
        //preOrder(root, f);
        //inOrder(root, f);
        //postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        //breadth2(root, f);
        //preOrder2(root, f);
        //inOrder2(root, f);
        //postOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        if (p.info.type.charAt(0) == 'A' || p.info.type.charAt(0) == 'C') fvisit(p, f);
    }
    
    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if (p.info.wing < 4 && p.info.rate > 6) fvisit(p, f);
        inOrder2(p.right, f);
    }
    
    int count2 = 1;
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (count2 % 2 != 0) fvisit(p, f);
        count2++;
        preOrder2(p.left, f);
        preOrder2(p.right, f);
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
            if (r.info.wing > 4) fvisit(r, f);
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
        ArrayList<Node> a = new ArrayList<>();
        postOrder3(root, f, a);
        Node p = a.get(3);
        Node ff = searchParent(p);
        deleteByMerging(ff.info.rate);
        //delete(ff);
        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
    void postOrder3(Node p, RandomAccessFile f, ArrayList<Node> a) throws Exception {
        if (p == null) {
            return;
        }
        postOrder3(p.left, f, a);
        postOrder3(p.right, f, a);
        a.add(p);
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
    
    void deleteByMerging(int x){
        Node p=root,par=root,rightMost=root;
        //tim node can xoa
        while(p!= null){
            if(p.info.rate > x) {
                par = p;
                p=p.left;
            }else if(p.info.rate < x){
                par = p;
                p=p.right;
                
            }else break;
            
        }
        
        // ra khoi vong lap thi p co the = null hoac la node can xoa
        //neu p = null -> k tim thay nut can xoa
        if (p == null) return;
        //xoa node neu no k co con
        if (p.left == null && p.right == null){
            if(p==root) root = null;
            //neu nut can xoa la left thi par.left tro vao null
            if(par.left == p) par.left = null;
            else par.right = null;
        }
        //neu p != null
        // xoa node neu no chi co con left
        else if(p.left != null && p.right == null){
            if(p==root) root = p.left;
            if(par.left == p) par.left = p.left;
            else par.right = p.left;
           
        }
        // xoa node neu no chi co con right
        else if(p.right != null && p.left == null){ 
            if(p==root){
                root = p.right;
            }
            if(par.left == p) par.left = p.right;
            else par.right = p.right;
            
        }
        // xoa node co 2 con
        else{
            //tim node right most cua con left
            rightMost = p.left;
            while(rightMost.right!=null) rightMost.right=rightMost;
            if(p==root){
                rightMost.right=root.right;
                root=root.left;
            }
            else{
                //neu node can xoa la con left
                if(par.left == p) {
                    par.left= p.left;
                    rightMost.right = p.right;
                }
                //neu node can xoa la con right
                else{
                    par.right = p.left;
                    rightMost.right=p.right;
                }
            }
        }     
    }
    
    void delete(Node x) {
        if (isEmpty()) 
            return;
        Node p = root, f = null;
        while (p != null) {
            if (p.info == x.info) break;
            f = p;
            if (p.info.rate > x.info.rate)
                p = p.left;
            else
                p = p.right;
        }
        if (p == null) return;
        
        // No child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
                return;
            }
            if (f.left == p)
                f.left = null;
            else
                f.right = null;
        }
        
        // 1 child
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
                return;
            }
            if (f.left == p)
                f.left = p.left;
            else
                f.right = p.left;
        } 
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
                return;
            }
            if (f.left == p) 
                f.left = p.right;
            else 
                f.right = p.right;
        }

        // 2 children
        if (p.left != null && p.right != null)
            deleteByCopying(p);
    }
    
    void deleteByCopying(Node p) {
        Node rightMost = p.left, f = null;
        while (rightMost.right != null) {
            f = rightMost;
            rightMost = rightMost.right;
        }
        p.info = rightMost.info;
        if (f == null)
            p.left = rightMost.left;
        else 
            f.right = rightMost.left;
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
        //postOrder(root, f);
        //breadth(root, f);
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        //breadth4(root, f);
        
        //------------------------------------------------------------------------------------
        //breadth(root, f);
        //postOrder(root, f);
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    
      
    int count4 = 1;
    void breadth4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (count4 == 4) {int k = getHeight(r); r.info.wing  = k; return;}
            count4++;
            //fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }
    int getHeight(Node p) {
        if (p == null) {
            return 0;
        }
        return Math.max(getHeight(p.left), getHeight(p.right)) + 1;
    }
}
