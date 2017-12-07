/**
 * 
 */
package com.tek.sales.cart;

import java.util.List;
import java.util.Map;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.HashMap;

import com.tek.sales.cart.interfce.ICart;
import com.tek.sales.item.interfce.IItem;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public class Cart implements ICart {
	//Holds items
	private List<IItem> itemList;
	//Holds sales tax value
	private float saleTax;
	//Holds total Cost value
	private float totalCost;
	//formatter
	private static final Format FORMATTER = new DecimalFormat("0.00");
	
	public Cart() {
		itemList = new ArrayList<IItem>();
	}

	/* 
	 * This method adds the items to the cart.
	 * (non-Javadoc)
	 * @see com.cart.interfce.ICart#addItemToCart(com.item.interfce.IItem)
	 */
	@Override
	public void addItemToCart(IItem item) {
		itemList.add(item);
	}

	/* 
	 * This method calculates the taxes and finally prints the receipt
	 * (non-Javadoc)
	 * @see com.cart.interfce.ICart#calculateAndPrintReceiptDetails()
	 */
	@Override
	public void calculateAndPrintReceiptDetails() {
		//resetting total cost and sales tax initially.
		resetCart();
		StringBuilder buffer = new StringBuilder();
		//This map holds the list of items in the cart and their corresponding 
		//quantities and prices.
		Map<String,List<Float>> productMap = new HashMap<String,List<Float>>();
		for (IItem item : itemList) {
			//get item description
			String itemName = item.getItemDescription();
			//If item is imporeted then append "Imported" string to it before
			// item description.
			if(item.isImportedItem())
			itemName = "Imported " + itemName;
			List<Float> list = null;
			//check whether the item already in the cart or not.
			//If item already in the cart then item will be added to 
			//cart and quantity will be increased.
			//else item will be simply added to cart.
			if(productMap.containsKey(itemName)){
				//This logic runs if same item is already in the cart.
			    list = productMap.get(itemName);
				float quantity = list.get(0)+1;
				float price = list.get(1) + item.getItemPrice();
				list = new ArrayList<Float>();
				list.add(0, quantity);
				list.add(1, price);
				productMap.put(itemName, list);
			}else{
				//This block runs if item is not present in the cart
				list = new ArrayList<Float>();
				list.add(0, 1f);
				list.add(1, item.getItemPrice());
				productMap.put(itemName, list);
			}
			//here total cost will be calculated.
			totalCost += item.getItemTotalPrice();
			//here total sales tax will be calculated.
			saleTax += item.getItemSaleTax();
		}
		System.out.println("\n");
		//prints all the items present in the cart.
		for(String item :productMap.keySet()){
			System.out.println(productMap.get(item).get(0).intValue()+" "+item+" :"+productMap.get(item).get(1));
		}
		buffer.append("Sales Taxes:" + FORMATTER.format(saleTax));
		buffer.append("\nTotal :" + totalCost);
		//prints total cost and sales taxes.
		System.out.println(buffer.toString());
	}

	/* 
	 * This method returns total price of cart including taxes.
	 * (non-Javadoc)
	 * @see com.cart.interfce.ICart#getTotalPrice()
	 */
	@Override
	public float getTotalPrice() {
		return totalCost;
	}

	/* 
	 * This method returns the sales tax
	 * (non-Javadoc)
	 * @see com.cart.interfce.ICart#getSalesTaxPrice()
	 */
	@Override
	public float getSalesTaxPrice() {
		return Float.valueOf(FORMATTER.format(saleTax));
	}
	
	/**
	 * This method builds the Sales Tax and Total Cost
	 * string to print the receipt finally.
	 */
	public String toString(){
		StringBuilder buffer = new StringBuilder();
		for (IItem item : itemList) {
			buffer.append("\n").append(item.toString());
		}
		return buffer.toString();
	}
	/**
	 * This method resets the total and Sales tax costs.
	 */
	private void resetCart() {
		totalCost = new Long(0);
		saleTax = new Long(0);
	}

}
