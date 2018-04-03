/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

/**
 * class customer
 *
 * @author apple
 */
public class Customer {

    private String name;
    private String address;

    /**
     * constructor
     *
     * @param name pass the string value
     * @param address pass the string value
     */
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * method to get name
     *
     * @return return the string value
     */
    public String getName() {
        return this.name;
    }

    /**
     * method to set name
     *
     * @param name pass the string value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to get address
     *
     * @return return string value
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * method to set address
     *
     * @param address set address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
