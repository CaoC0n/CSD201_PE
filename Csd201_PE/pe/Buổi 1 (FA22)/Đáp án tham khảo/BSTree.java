/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {
   Node root;
   BSTree() {root=null;}
   boolean isEmpty() {
       return(root==null);
      }
   void clear() {
       root=null;
      }
   void visit(Node p) {
      System.out.print("p.info: ");
      if(p != null) System.out.println(p.info + " ");
     }
   void fvisit(Node p, RandomAccessFile f) throws Exception {
      if(p != null) f.writeBytes(p.info + " ");
     }
   void breadth(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void preOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }

   void loadData(int k) { //do not edit this function
      String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xBrand, int xColor, int xWeight) {
    //You should insert here statements to complete this function
       if (xBrand.charAt(0) == 'A') {
            return;           			
        }
        Node q = new Node(new Bike(xBrand, xColor, xWeight));
        if (isEmpty()) {
            root = q;
            return;
        }
        Node p = root;
        Node f = null; // f is the father of p
        while (p != null) {
            if (xWeight == p.info.weight) {
                return;
            } // end if
            f = p;
            if (xWeight < p.info.weight) {
                p = p.left;
            } else {
                p = p.right;
            }
        } // end while

        if (xWeight < f.info.weight) {
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
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    inOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  
//=============================================================
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    preOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    this.preOrder2(root, f);

    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }  
  
  void preOrder2(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      if (p.info.color<6){
          fvisit(p,f);
      }
      preOrder2(p.left,f);
      preOrder2(p.right,f);
     }
  
  
  
//=============================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    postOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
  this.postOrder3(root);
  int k = this.countNode(node3);
  node3.info.color = k;
    
    //------------------------------------------------------------------------------------
    postOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  //tim p
  int count3 = 0;
    Node node3 = null;
    void postOrder3(Node p) {
        if (p == null) {
            return;
        }
        postOrder3(p.left);
        postOrder3(p.right);
        //logic
        count3++;
        if (count3 == 5) {
            node3 = p;
            return;
        }
    }
    //tim k
    int countNode(Node pNode) {
        if (pNode == null) {
            return 0;
        }
        int k, h, rNode;
        k = countNode(pNode.left);
        h = countNode(pNode.right);
        rNode = k + h + 1;
        return rNode;
    }
  
 
  

//=============================================================
  void f4() throws Exception {
    clear();
    loadData(13);;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    postOrder(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
   this.postOrder4(root);
   Node fp = this.searchParent(node4);
   this.rotateRight(node4, fp);
    
    //------------------------------------------------------------------------------------
    postOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   } 
  //tim p
  int count4 = 0;
    Node node4 = null;
    void postOrder4(Node p) {
        if (p == null) {
            return;
        }
        postOrder4(p.left);
        postOrder4(p.right);
        //logic
        if (p.left != null){
            count4++;
            if (count4 == 2) {
                node4 = p;
                return;
            }
        }    
        
    }
    //quay phai
    void rotateRight(Node p, Node fp) {
        if (p == null || p.left == null) {
            return ;
        }

        Node p1 = p.left;
        p.left = p1.right;
        p1.right = p;
        if (fp.left == p)
            fp.left = p1;
        else
            fp.right = p1;
    }
    // tim cha
    Node searchParent(Node a) {
        if (a == null)
            return null;
        Node p = root, f = null;
        while (p != null && p != a) {
            f = p;
            if (p.info.weight > a.info.weight)
                p = p.left;
            else 
                p = p.right;
        }
        return f;
    }
  
  
   

 }
