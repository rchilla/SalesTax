/**
 * 
 */
package com.tek.sales.jUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import com.tek.sales.cart.interfce.ICart;
import com.tek.sales.item.eenum.ItemProperties.ItemType;
import com.tek.sales.item.interfce.IItem;
import com.tek.sales.util.ApplicationContextUtil;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public class CartTest {
	private List<IItem> itemList ;
	private float expectedTotalSalexTax;
	private float exptecdTotalCost;

	public CartTest(List<IItem> list , float totalCost , float totalSalexTax){
		itemList = list;
		exptecdTotalCost = totalCost;
		expectedTotalSalexTax = totalSalexTax;
	}

	@Parameterized.Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] {
			   { createItemList(new Object[][]{ItemTestHelper.ITEM_LIST[0], ItemTestHelper.ITEM_LIST[1], ItemTestHelper.ITEM_LIST[2]}), 29.83f , 1.50f},
			   { createItemList(new Object[][]{ItemTestHelper.ITEM_LIST[3], ItemTestHelper.ITEM_LIST[4]}), 65.15f , 7.65f},
			   { createItemList(new Object[][]{ItemTestHelper.ITEM_LIST[5], ItemTestHelper.ITEM_LIST[6], ItemTestHelper.ITEM_LIST[7], ItemTestHelper.ITEM_LIST[8]}), 74.68f , 6.70f} };
	   return Arrays.asList(data);
	 }

	 private static List<IItem> createItemList(Object[][] data){
		 List<IItem> list = new ArrayList<IItem>();
		 for(Object[] item: data){
			 list.add(ItemTestHelper.createItem((String)item[0],(Float)item[1], (ItemType)item[2]));
		 }
		 return list;
	 }

	 @Test
	 public void testCartCostAndTax(){

		 ICart cart = (ICart) ApplicationContextUtil.getBean("cartBean");
		 for(IItem item : itemList){
			 cart.addItemToCart(item);
		 }
		 cart.getTotalPrice();
		 Assert.assertEquals("test failed for sales tax" , expectedTotalSalexTax ,cart.getSalesTaxPrice(), 0.0f );
		 Assert.assertEquals("test failed for total cost" , exptecdTotalCost ,cart.getTotalPrice(), 0.0f );
	 }	

}
