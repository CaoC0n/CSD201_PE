/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xBrand, int xColor, int xWeight) {
    //You should write here appropriate statements to complete this function.
      if (xBrand.charAt(0) == 'B') {
                return;
    }
    addLast(new Bike(xBrand, xColor, xWeight));
   }
  void addLast(Bike x) {
        Node node = new Node(x);

        if (head == null) {
            head = node;
            tail = head;
            return;
        }

        tail.next = node;
        tail = node;
    }
  
  
  

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  
 
  
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Bike x, y;
     x = new Bike("X",1,2);
     y = new Bike("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     this.insertPositionK(x, 1);
     this.insertPositionK(y, 4);
  
    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  
  
  void insertPositionK(Bike x, int position) {
        if (isEmpty()) {
            head = tail = new Node(x);
        }
        int count = 1;
        Node p = head;
        while (p != null && count < position) {
            p = p.next;
            count++;
        }
        Node temp = p.next;
        p.next = new Node(x, temp);
    }
    
  
  

//==================================================================
  
  
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node node2= this.searchByColor(this.findMin());
     if (node2==null)
         return;
     else
        this.remove(node2);
     
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
  
  void removeFirst(){
        if (isEmpty()){
            return;
        }
        head = head.next;
        if (head == null){
            tail = null;
        }
    }
    
    void remove(Node q){
        if (isEmpty() || q == null){
            return;
        }
        if (q == head){
            removeFirst();
            return;
        }
        Node f = head;
        while(f !=null && f.next != q){
            f = f.next;
        }
        if (f == null){
            return;//q ko co trong danh sach
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null){
            tail = f;
        }
    }
    
    Node searchByColor(int xColor){
        Node p = head;
        int count=0;
        while (p!=null){
            if(p.info.color == xColor){
                count++;
            }
            if (count==2)
                 return p;
            p=p.next;
        }
        return null;
    }
    
    int findMin(){
        int x;
        Node p, q;
        p = q = head;
        x = head.info.color;
        p = p.next;
        while (p != null){
            if (p.info.color < x){
                x = p.info.color;
                q = p;
            }
            p = p.next;
        }
        return x;
    }

  
 

//==================================================================
 
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
   this.sort1(0, 3);
     this.sort2(size()-3, size()-1);

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
  
  Node pos(int k){
        int i = 0;
        Node p = head;
        while (p!=null){
            if (i == k){
                return p;
            }
            i++;
            p = p.next;
        }
        return null;
    }
  
  void sort1(int k, int h){
        if (k > h){
            return;
        }
        if (k < 0){
            k = 0;
        }
        int n = size();
        if ( h > n -1){
            h = n - 1;
        }
        Node u = pos(k);
        Node v = pos(h+1);
        Node pi, pj;
        Bike x;
        pi = u;
        while(pi != v){
            pj = pi.next;
            while ( pj != v){
                if (pj.info.color < pi.info.color){
                    x =pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
  
  void sort2(int k, int h){
        if (k > h){
            return;
        }
        if (k < 0){
            k = 0;
        }
        int n = size();
        if ( h > n -1){
            h = n - 1;
        }
        Node u = pos(k);
        Node v = pos(h+1);
        Node pi, pj;
        Bike x;
        pi = u;
        while(pi != v){
            pj = pi.next;
            while ( pj != v){
                if (pj.info.color > pi.info.color){
                    x =pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
  
  
  int size() {
        int count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

 
  
 }

