/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

/**
 * class credit
 *
 * @author apple
 */
public class Credit extends Payment implements Authorization {

    private long number;
    private String type;
    private long expDate;

    /**
     * constructor credit
     *
     * @param amount pass double value
     * @param number pass long value
     * @param type pass string value
     * @param expDate pass long value
     */
    public Credit(double amount, long number, String type, long expDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expDate = expDate;
    }

    /**
     * method to print receipt
     *
     * @param payedOrder pass pay order
     */
    @Override
    public void printReceipt(Order payedOrder) {
        System.out.println("-----------------------------");
        System.out.println("Date " + payedOrder.date);
        System.out.println("Total Items  :" + payedOrder.orderDetails.size());
        System.out.println("Amount to pay:" + payedOrder.calcTotal() + " dollars");
        System.out.println("Tax          :" + payedOrder.calcTax() + " dollars");
        System.out.println("Pay by credit card");

    }

    /**
     * method to authorize payment
     *
     * @param payedOrder pass the payed order
     */
    @Override
    public void authorized(Order payedOrder) {
        System.out.println("If the number matches with the type and expDate, then it is authorised");
        System.out.println("Successfully authorised. Payment succeeds");
        payedOrder.setStatus("Payed");
    }

}
