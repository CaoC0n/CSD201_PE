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
public class Product {

    String pcode;
    String proName;
    int quantity;
    int saled;
    double price;

    public Product(String pcode, String proName, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.proName = proName;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    @Override
    public String toString() {
        return pcode + " | " + proName + " | " + quantity + " | " + saled + " | " + price;
    }

}
