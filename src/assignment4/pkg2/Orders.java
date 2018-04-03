/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * class order
 *
 * @author apple
 */
public class Orders {

    java.io.File file;

    /**
     * constructor
     */
    public Orders() {

        this.file = new java.io.File("orders.txt");
    }

    /**
     * method to find whether the customer has existed
     *
     * @param customer pass the customer
     * @return return boolean
     * @throws FileNotFoundException to catch exception if file is not found
     */
    public boolean findCustomer(Customer customer) throws FileNotFoundException {
        Scanner input = new Scanner("Customers.txt");
        while (input.hasNext()) {
            String[] s = input.nextLine().split(",");
            if ((s[0].equals(customer.getName())) && (s[1].equals(customer.getAddress()))) {
// if the customer's name is consistent with the customer's address, then return true to show that the customer has exists
                return true;
            } else {
                return false;
            }

        }
        return false;

    }
}
