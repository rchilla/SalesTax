/**
 * 
 */
package com.tek.sales.item;

import com.tek.sales.item.eenum.ItemProperties.ItemType;
import com.tek.sales.item.interfce.IItem;
import com.tek.sales.tax.interfce.ITaxCalculator;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public class Item implements IItem{
	//Holds Item name
	private String name;
	//Holds Item Price
	protected float itemPrice;
	//Hold Item Type
	private ItemType itemType;
	
	private ITaxCalculator taxCalculator ;
	
	public Item() {
		super();
	}
	
	public Item(ITaxCalculator taxCalculator) {
		this.taxCalculator = taxCalculator;
	}
	
	@Override
	public void setItemDescription(String description) {
		name = description;
		
	}

	@Override
	public String getItemDescription() {
		return name;
	}

	@Override
	public void setItemPrice(float price) {
		itemPrice = price;
	}

	@Override
	public float getItemPrice() {
		return itemPrice;
	}

	@Override
	public void setItemType(ItemType itemTyp) {
		itemType = itemTyp;
		
	}

	@Override
	public Boolean isTaxExempted() {
		return itemType.isTaxExempted();
	}

	@Override
	public Boolean isImportedItem() {
		return itemType.isImportedItem();
	}

	@Override
	public float getItemSaleTax() {
		return (taxCalculator.calculateTax(this));
	}

	@Override
	public float getItemTotalPrice() {
		return getItemSaleTax()+getItemPrice();
	}

	@Override
	public String toString(){
		return 1+ " "+name+" :" +getItemTotalPrice();
	}
}
