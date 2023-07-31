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
class Customer {

    String ccode;
    String cusName;
    String phone;

    public Customer(String ccode, String cusName, String phone) {
        this.ccode = ccode;
        this.cusName = cusName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ccode + " | " + cusName + " | " + phone;
    }

}
