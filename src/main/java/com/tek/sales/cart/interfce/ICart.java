/**
 * 
 */
package com.tek.sales.cart.interfce;

import com.tek.sales.item.interfce.IItem;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public interface ICart {
	//This method add the item to the cart
	public void addItemToCart(IItem item);
	//This method calculates the tax and prints the receipt.
	public void calculateAndPrintReceiptDetails();
	//This method returns the Total price of cart including taxes.
	public float getTotalPrice() ;
	//This method returns only applicable sales tax
	public float getSalesTaxPrice() ;

}
