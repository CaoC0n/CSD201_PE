/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Admin
 */
class OrderList {

    static class Node {

        Order data;
        Node next;

        public Node(Order data) {
            this.data = data;
        }
    }

    Node head;

    public void add(Order order) {
        Node newNode = new Node(order);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayWithTotalValue(ProductList productList) {
        System.out.println("Pcode | Ccode | Quantity | Value");
        System.out.println("-----------------------------");
        Node current = head;
        while (current != null) {
            ProductList.Node productNode = productList.search(current.data.pcode);
            if (productNode != null) {
                double value = productNode.data.price * current.data.quantity;
                System.out.println(current.data.pcode + " | " + current.data.ccode + " | "
                        + current.data.quantity + " | " + value);
            }
            current = current.next;
        }
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            Node minNode = current;
            Node innerCurrent = current.next;
            while (innerCurrent != null) {
                int compareValue = innerCurrent.data.pcode.compareTo(minNode.data.pcode);
                if (compareValue < 0 || (compareValue == 0 && innerCurrent.data.ccode.compareTo(minNode.data.ccode) < 0)) {
                    minNode = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }
            swap(current, minNode);
            current = current.next;
        }
    }

    private void swap(Node node1, Node node2) {
        Order temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}
