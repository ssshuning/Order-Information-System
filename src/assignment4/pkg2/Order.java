/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

/**
 * class order
 *
 * @author apple
 */
public class Order {

    /**
     * protected data field for subclass use
     */
    protected String date;
    private String status;
    java.io.File file;

    /**
     * protected data field for subclass use
     */
    protected ArrayList<OrderDetail> orderDetails;
    private Customer customer;

    /**
     * constructor for order class
     *
     * @param customer pass the customer to the order
     */
    public Order(Customer customer) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date = dateFormat.format(new Date());
        this.status = "Not Payed.";
        this.orderDetails = new ArrayList<OrderDetail>();
        this.customer = customer;
    }

    /**
     * method to set the order status
     *
     * @param status pass the string value of status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * method to calculate tax
     *
     * @return return the double value of tax
     */
    public double calcTax() {
        double tax = 0;
        for (OrderDetail orderDetail : orderDetails) {
            tax = (orderDetail.getTaxStatus() * orderDetail.calcWeight()) + tax;
        }

        return tax;
    }

    /**
     * method to calculate the total price
     *
     * @return return the double value of price
     */
    public double calcTotal() {
        double totalPrice = 0;
        for (OrderDetail orderDetail : orderDetails) {
            totalPrice = this.calcTax() + orderDetail.calcSubtotal() + totalPrice;
        }
        return totalPrice;
    }

    /**
     * method to add order details to the array list
     *
     * @param orderDetail pass the order detail to the method
     * @return return the array list
     */
    public ArrayList<OrderDetail> addOrderDetails(OrderDetail orderDetail) {

        orderDetails.add(orderDetail);

        return orderDetails;
    }

    /**
     * method to export the order into order file
     *
     * @throws FileNotFoundException catch exception if file is not found
     * @throws IOException catch exception if the input is not valid
     */
    public void exportOrder() throws FileNotFoundException, IOException {
        String orderInfo = ("Customer: " + this.customer.getName() + " from "
                +//get order information
                this.customer.getAddress() + " buys:\n");
        System.out.println(orderDetails.size());
        for (OrderDetail orderDetail : orderDetails) { // for loop displaying orderdetails
            orderInfo = orderInfo + " \n" + orderDetail.printItems();

        }

        try (//use print writer to write order details into order text file
                PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("Orders.txt", true)));) {
            output.println(orderInfo + "\nfor " + this.calcTotal() + " dollars");

        }
    }

}
