/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4.pkg2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * the class containing main method
 *
 * @author apple
 */
public class Assignment42 {

    /**
     * main method
     *
     * @param args the command line argument no contents contained in the
     * argument
     * @throws java.io.IOException catch exception if input is not valid
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name please:");//enter your name
        String name = scanner.nextLine();
        System.out.println("Enter your address please:");//enter your address
        String address = scanner.nextLine();
        Customer customer = new Customer(name, address);//create new customer object
        Orders orders = new Orders();//create new orders object
        if (!orders.findCustomer(customer)) {// this for loop is used to check whether the customer has existed
            try (
                    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("Customers.txt", true)));) {
                output.println(name + "," + address);// if not, write the customer information into the file
            }

        }

        System.out.println("What would you like to buy? ");
        System.out.println("--------------------------------------------------------");
        System.out.println("Product ID         Description         Price      Weight");
        //print the menue
        File menu = new File("menu.txt");
        Scanner readMenu = new Scanner(menu);//read menu from the text
        while (readMenu.hasNext()) {//print out the menue information
            String[] s = readMenu.nextLine().split(",");//use split to split each line that has been read
            int productID = Integer.parseInt(s[0]);//convert string to different value types needed
            String description = s[1];
            double price = Double.parseDouble(s[2]);
            double weight = Double.parseDouble(s[3]);
            System.out.format("%10d%20s%15f%10f", productID, description, price, weight);
            System.out.println();
        }
        System.out.println("Enter the product ID please:");//enter what you want to buy
        int quantity;
        int productID;
        Order order = new Order(customer);//put the customer object into order object
        try {
            productID = scanner.nextInt();
            while (productID > 0 && productID < 7) { // the value ID is defined between 1-7
                System.out.println("Enter the quantity you want to buy");
                quantity = scanner.nextInt();
                OrderDetail orderDetail = new OrderDetail(quantity);//set the quantity want to buy
                orderDetail.addItem(productID);//add items into orderdetails
                System.out.println("Anything else? If not, enter any other number to drop except 1-6");
                productID = scanner.nextInt();
                scanner.nextLine();
                order.addOrderDetails(orderDetail);//add orderdetail into order object
            }
        } catch (InputMismatchException ex) {
            System.out.println("Please enter integers");
        }

        double totalPrice = order.calcTotal();//calculate the total price
        Payment payment = new Payment(totalPrice);//create payment object
        System.out.println("--------------------------------------------- ");
        System.out.println("Enter your payment way please:\n1 for cash"
                + "\n2 for credit" + "\n3 for check");
        int way = scanner.nextInt();
        payment.choosePayment(way, customer, order);
        order.exportOrder();//export the order into order text file
        Scanner readOrders = new Scanner(new File("Orders.txt"));
        while (readOrders.hasNext()) { // print out the order
            System.out.println(readOrders.nextLine());
        }

    }
}
