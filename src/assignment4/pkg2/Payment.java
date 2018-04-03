/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class payment
 *
 * @author apple
 */
public class Payment {

    /**
     * protected field for subclass use
     */
    protected double amount;

    private Customer customer;
    private Order order;
    private String date;
    private Scanner scanner;
    private Cash cash;
    private Credit creditCard;
    private Check check;

    /**
     * constructor
     *
     * @param amount to initialize the field amount
     */
    public Payment(double amount) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.date = dateFormat.format(new Date());
        this.amount = amount;

    }

    /**
     * method to choose payment
     *
     * @param paymentWay to pass way of payment
     * @param customer to the customer object
     * @param order to pass the order to pay
     */
    public void choosePayment(int paymentWay, Customer customer, Order order) {
        scanner = new Scanner(System.in);
        try {
            switch (paymentWay) {//enter the payment way
                case 1:
                    System.out.println("You should pay " + this.amount + " Enter your cash please:");
                    double cashPayed = scanner.nextDouble();
                    while (this.amount > cashPayed) { // if the amount of cash is not enough
                        System.out.println("Not enough money, please enter more: ");
                        cashPayed = scanner.nextDouble() + cashPayed;
                    }
                    cash = new Cash(amount, cashPayed);//create cash object
                    cash.printReceipt(order);
                    break;
                case 2:
                    System.out.print("Enter your card number please:");
                    System.out.println("-----------------------------");
                    long number = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter your card type please:");
                    System.out.println("-----------------------------");
                    String type = scanner.nextLine();
                    System.out.println("Enter your expire Date please:");
                    System.out.println("-----------------------------");
                    long expDate = scanner.nextInt();
                    creditCard = new Credit(amount, number, type, expDate);//create credit card object
                    creditCard.authorized(order);//authorization
                    creditCard.printReceipt(order);
                    break;
                case 3:
                    System.out.println("Enter your bank ID please:");
                    long bankID = scanner.nextInt();
                    check = new Check(amount, customer.getName(), bankID);//create check object
                    check.authorized(order);
                    check.printReceipt(order);
                    break;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter the right format");
        }
    }

    /**
     * method to print receipt
     *
     * @param order pass the order to print receipt
     */
    public void printReceipt(Order order) {
        System.out.println("Date " + this.date);
        System.out.println("Total Items = " + order.orderDetails.size());
        System.out.println("Total  " + order.calcTotal());
        System.out.println("Tax = " + order.calcTax());

    }

}
