/**
 * 
 */
package com.tek.sales.item.interfce;

import com.tek.sales.item.eenum.ItemProperties.ItemType;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public interface IItem {
	
	//to set and get Item Description
	void setItemDescription(String description);
	String getItemDescription();
	
	//to set and get Item Price
	void setItemPrice(float price);
	float getItemPrice();
	
	//to set and get Item Type like books, food, medical etc.
	void setItemType(ItemType itemType);
	
	//tell whether Tax is exempted for Item or not.
	Boolean isTaxExempted();
	
	//tell whether Item is imported or not.
	Boolean isImportedItem();
	
	//Holds sales tax of item
	float getItemSaleTax();
	
	//Final Price of Item including all taxes
	float getItemTotalPrice();

}
