package com.tek.sales.execute;

import java.util.Scanner;

import com.tek.sales.cart.interfce.ICart;
import com.tek.sales.item.eenum.ItemProperties.ItemType;
import com.tek.sales.item.interfce.IItem;
import com.tek.sales.util.ApplicationContextUtil;

public class Main {

    enum ItemTypeList {
        BOOK("Books"),
        MUSIC_CD("Music CD"),
        CHOCOLATE("Chocolates"),
        PERFUME("Perfume"),
        PILLS("Headache Pills");
        private String itemName;

        private ItemTypeList(String name) {
            itemName = name;
        }

        public String getItemName() {
            return itemName;
        }
    }
    /**
     * This class is used to run the application. 
     * First User has to choose what kind of Item he is ordering. 
     * And system asks for Price
     * Once price is given, user was asked to enter category of Item.
     * 
     * User can add multiple items to the cart. and Same item can be added
     * multiple times to the cart. 
     * 
     * To exit from the system, user need to press 0 from the available menu.
     * 
     * On exit tax will be calculated and receipt will be shown to the user.
     * 
     * @param args
     */
    public static void main(String[] args) {
    	//Scans the 
        Scanner input = new Scanner(System.in);
        //This has list of all available items in the application
        ItemTypeList list[] = ItemTypeList.values();
        StringBuilder buffer = new StringBuilder();
        int count = 1;
        //while iterating through the loop, we are building Menu for items
        for (ItemTypeList item : list) {
            buffer.append(count++).append(" :").append(item.getItemName() + "\n");
        }
        String productList = buffer.toString() + "0 :Exit and Print Receipt\nSelect Item : \n";
        ItemType[] itemTypes = ItemType.values();

        buffer.delete(0, buffer.length());
        //This appends menu number for the items
        for (ItemType itemType : itemTypes) {
            buffer.append(itemType.ordinal()).append(" :").append(itemType.name() + "\n");
        }
        String itemTypeList = "Available Item Categories: \n" + buffer;
        
        //getting the cart instance using dependency injection concept using Spring framework.
        ICart cart = (ICart) ApplicationContextUtil.getBean("cartBean");
        
        //This loop is to add products to the cart. On press of 0 will exit this loop and generate
        //receipt
        while (true) {
            System.out.println(productList);
            //Reads product input.
            int product = input.nextInt();
            if (product == 0) {
                break;
            }
          //getting the Item instance using dependency injection concept using Spring framework.
            IItem item = (IItem) ApplicationContextUtil.getBean("itemBean");
            item.setItemDescription(list[product - 1].getItemName());
            System.out.println("Enter Price:");
            //Reading price for the item
            item.setItemPrice(input.nextFloat());
            System.out.println(itemTypeList);
            System.out.println("Select Item Category:");
            item.setItemType(itemTypes[input.nextInt()]);
            //Adding item to the cart
            cart.addItemToCart(item);
        }
        input.close();
        //Calculate taxes and printing the receipt.
        cart.calculateAndPrintReceiptDetails();
        
    }
}
