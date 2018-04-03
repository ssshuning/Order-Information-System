/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

/**
 * class cash
 *
 * @author apple
 */
public class Cash extends Payment {

    private double cashTendered;//create fields
    private double change;

    /**
     * constructor of cash
     *
     * @param amount pass the double value of amount
     * @param cashPayed pass the double value of cashPayed
     */
    public Cash(double amount, double cashPayed) {
        super(amount);
        this.change = cashPayed - super.amount;
        this.cashTendered = cashPayed;
    }

    /**
     * method to print receipt
     *
     * @param payedOrder object order passed
     */
    @Override
    public void printReceipt(Order payedOrder) {
        System.out.println("-----------------------------");
        System.out.println("Date " + payedOrder.date);
        System.out.println("Pay by cash");
        System.out.println("Total Items  :" + payedOrder.orderDetails.size());
        System.out.println("Amount to pay:" + payedOrder.calcTotal() + " dollars");
        System.out.println("Tax          :" + payedOrder.calcTax() + " dollars");
        System.out.println("Cash tendered:" + this.cashTendered);
        System.out.println("Changes      :" + this.change);

    }

}
