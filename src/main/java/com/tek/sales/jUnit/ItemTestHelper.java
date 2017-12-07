/**
 * 
 */
package com.tek.sales.jUnit;

import com.tek.sales.item.eenum.ItemProperties.ItemType;
import com.tek.sales.item.interfce.IItem;
import com.tek.sales.util.ApplicationContextUtil;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public class ItemTestHelper {
	/**
	 * Data set
	 */
	public static Object[][] ITEM_LIST = new Object[][] {
			   { "book", 12.49f , ItemType.BOOK_MEDICAL_FOOD , 12.49f },
			   { "Music CD", 14.99f , ItemType.OTHERS_ITEMS , 16.49f},
			   { "chocolate bar" , 0.85f , ItemType.BOOK_MEDICAL_FOOD , 0.85f} ,
			   { "imported box of chocolates", 10.00f, ItemType.IMPORTED_BOOK_MEDICAL_FOOD, 10.50f},
			   { "imported bottle of perfume", 47.50f, ItemType.IMPORTED_OTHERS_ITEMS, 54.65f},
			   { "imported bottle of perfume", 27.99f,ItemType.IMPORTED_OTHERS_ITEMS , 32.19f},
			   { "bottle of perfume", 18.99f, ItemType.OTHERS_ITEMS , 20.89f},
			   { "packet of headache pills", 9.75f , ItemType.BOOK_MEDICAL_FOOD, 9.75f},
			   { "box of imported chocolates",11.25f,ItemType.IMPORTED_BOOK_MEDICAL_FOOD, 11.85f}
			   };

	/**
	 * Helper method to create Item
	 * @param description
	 * @param price
	 * @param itemType
	 * @return
	 */
	public static IItem createItem(String description , float price , ItemType itemType ){
		IItem item = (IItem) ApplicationContextUtil.getBean("itemBean");
		item.setItemType(itemType);
		item.setItemPrice(price);
		item.setItemDescription(description);
		return item;
	}
}
