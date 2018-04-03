/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

/**
 *
 * @author apple
 */
public class Item {

    private double shippingWeight;
    private String description;
    private int productID;

    /**
     *
     */
    protected double quantityPrice;

    /**
     *
     * @param productID
     * @param description
     * @param price
     * @param shippingWeight
     */
    public Item(int productID, String description, double price, double shippingWeight) {
        this.shippingWeight = shippingWeight;
        this.productID = productID;
        this.quantityPrice = price;
        this.description = description;
    }

    /**
     *
     * @return
     */
    public double getPriceforQuantity() {
        return this.quantityPrice;
    }

    /**
     *
     * @return
     */
    public double getWeight() {
        return this.shippingWeight;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

}
