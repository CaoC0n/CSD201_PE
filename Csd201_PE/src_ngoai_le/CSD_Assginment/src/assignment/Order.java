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
class Order {

    String pcode;
    String ccode;
    int quantity;

    public Order(String pcode, String ccode, int quantity) {
        this.pcode = pcode;
        this.ccode = ccode;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return pcode + " | " + ccode + " | " + quantity;
    }

}
