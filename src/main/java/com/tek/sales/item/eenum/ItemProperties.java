/**
 * 
 */
package com.tek.sales.item.eenum;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public class ItemProperties {
	public enum ItemType {
		BOOK_MEDICAL_FOOD(true, false), 
		OTHERS_ITEMS(false, false), 
		IMPORTED_BOOK_MEDICAL_FOOD(true,true), 
		IMPORTED_OTHERS_ITEMS(false, true);
		//Tells whether item is exempted from tax or not. 
		private boolean isTaxExempted;
		//Tells whether item is imported or not
		private boolean isImportedItem;

		private ItemType(boolean exepmted, boolean imported) {
			isTaxExempted = exepmted;
			isImportedItem = imported;
		}

		public boolean isImportedItem() {
			return isImportedItem;
		}

		public boolean isTaxExempted() {
			return isTaxExempted;
		}
	}

}
