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
class CustomerList {

    static class Node {

        Customer data;
        Node next;

        public Node(Customer data) {
            this.data = data;
        }
    }

    Node head;

    public void add(Customer customer) {
        Node newNode = new Node(customer);
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

    public void display() {
        System.out.println("Ccode | CusName | Phone");
        System.out.println("-----------------------");
        Node current = head;
        while (current != null) {
            System.out.println(current.data.ccode + " | " + current.data.cusName + " | " + current.data.phone);
            current = current.next;
        }
    }

    public Node search(String xCode) {
        Node current = head;
        while (current != null) {
            if (current.data.ccode.equals(xCode)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(String xCode) {
        if (head == null) {
            return;
        }

        if (head.data.ccode.equals(xCode)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.ccode.equals(xCode)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
