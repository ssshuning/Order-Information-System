
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

/**
 * class check
 *
 * @author apple
 */
public class Check extends Payment implements Authorization {

    private String name;
    private long bankID;

    /**
     * constructor of check
     *
     * @param amount double value passed
     * @param name string value passed
     * @param bankID long value passed
     */
    public Check(double amount, String name, long bankID) {
        super(amount);
        this.name = name;
        this.bankID = bankID;
    }

    /**
     * method to print receipt
     *
     * @param payedOrder order object passed
     */
    @Override
    public void printReceipt(Order payedOrder) {
        System.out.println("-----------------------------");
        System.out.println("Date " + payedOrder.date);
        System.out.println("Total Items  :" + payedOrder.orderDetails.size());
        System.out.println("Amount to pay:" + payedOrder.calcTotal() + " dollars");
        System.out.println("Tax          :" + payedOrder.calcTax() + " dollars");
        System.out.println("Pay by check");
    }

    /**
     * method to authorize payment
     *
     * @param payedOrder object order passed
     */
    @Override
    public void authorized(Order payedOrder) {
        System.out.println("If the name matches bank account, then it is authorised");
        System.out.println("Successfully authorised. Payment succeeds");
        payedOrder.setStatus("Payed");
    }

}
