/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * class order detail
 *
 * @author apple
 */
public class OrderDetail {

    private double quantity;
    private double taxStatus;
    private Item item;
    private double subPrice;

    /**
     * constructor
     *
     * @param quantity pass the value quantity
     */
    public OrderDetail(int quantity) {
        this.quantity = quantity;
        this.subPrice = 0;
        this.taxStatus = 0.02;

    }

    /**
     * get the quantity method
     *
     * @return return the double value of quantity
     */
    public double getQuantity() {
        return this.quantity;
    }

    /**
     * get the tax rate method
     *
     * @return return the double value of tax rate
     */
    public double getTaxStatus() {
        return this.taxStatus;
    }

    /**
     * get the price
     *
     * @return return the double value of price
     */
    public double getPrice() {
        return this.subPrice;
    }

    /**
     * print items
     *
     * @return return the string form of information
     */
    public String printItems() {
        String information = (this.quantity + " " + this.item.getDescription());
        return information;
    }

    /**
     * method to add item
     *
     * @param n pass n to control loop
     * @throws NumberFormatException catch exception if number format is not
     * correct
     * @throws FileNotFoundException catch exception if file is not found
     */
    public void addItem(int n) throws NumberFormatException, FileNotFoundException {
        Scanner scanner = new Scanner(new File("menu.txt"));
        // System.out.println(n);
        int count = 1;
        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(",");
            int productID = Integer.parseInt(s[0]);
            String description = s[1];
            double price = Double.parseDouble(s[2]);
            double weight = Double.parseDouble(s[3]);
            if (count == n) {
                this.item = new Item(productID, description, price, weight);
            }
            count++;

        }

    }

    /**
     * calculate the subtotal price of each item
     *
     * @return return the double value of price
     */
    public double calcSubtotal() {
        return this.item.getPriceforQuantity() * this.getQuantity();

    }

    /**
     * calculate the weight of each item
     *
     * @return return double value of weight
     */
    public double calcWeight() {
        return (this.item.getWeight() * this.quantity);

    }

}
