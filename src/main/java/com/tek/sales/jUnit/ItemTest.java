/**
 * 
 */
package com.tek.sales.jUnit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import com.tek.sales.item.eenum.ItemProperties.ItemType;
import com.tek.sales.item.interfce.IItem;

import org.junit.runner.RunWith;


/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
@RunWith(Parameterized.class)
public class ItemTest {
	private String description;
	private float price;
	private ItemType itemType;
	private float expectedPriceWithTax;

	public ItemTest(String desc , float aPrice , ItemType type , float costWithTax){
		description = desc;
		price = aPrice;
		itemType = type;
		expectedPriceWithTax = costWithTax;
	}

	@Parameterized.Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = ItemTestHelper.ITEM_LIST;
	   return Arrays.asList(data);
	 }

	 @Test
	 public void testItemPriceWithTax(){
		IItem item = ItemTestHelper.createItem(description, price, itemType);
		Assert.assertEquals("test failed for price with tax"+item.getItemDescription(), expectedPriceWithTax ,item.getItemTotalPrice(), 0.0f );
	 }
}
