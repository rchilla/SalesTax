/**
 * 
 */
package com.tek.sales.tax.interfce;

import com.tek.sales.item.interfce.IItem;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public interface ITaxCalculator {
	//this method calculates the tax.
	float calculateTax(IItem item);
}
