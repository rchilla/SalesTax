/**
 * 
 */
package com.tek.sales.tax;

import com.tek.sales.item.interfce.IItem;
import com.tek.sales.tax.eenum.ApplicableTaxRates.TaxType;
import com.tek.sales.tax.interfce.ITaxCalculator;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public class TaxCalculator implements ITaxCalculator {
	//round of rule for tax which is 0.05.
	private static final float ROUNDOFF= 0.05f;
	/* (non-Javadoc)
	 * @see com.tax.interfce.ITaxCalculator#calculateTax(com.item.interfce.IItem)
	 */
	@Override
	public float calculateTax(IItem item) {
		return roundOffTax(getItemTaxType(item).getApplicableTax() * item.getItemPrice());
	}
	
	private TaxType getItemTaxType(IItem item) {
		//Below logic checks whether the item is normal or imported.
		//Based on type of item it applies sales tax and imported tax.
		if(item.isImportedItem() && !item.isTaxExempted()){
			return TaxType.BOTH_TAXES;
		}else if( item.isImportedItem() && item.isTaxExempted()){
			return TaxType.IMPORTED_TAX;
		}else if( !item.isImportedItem() && !item.isTaxExempted()){
			return TaxType.BASIC_SALES_TAX;
		}
		//In case of Food, Medical or Books. No Tax will be applicable.
		return TaxType.NO_TAX;
	}
	/**
	 * The rounding rules for sales tax
	 * @param tax
	 * @return
	 */
	private float roundOffTax(float tax){
		//It round off the tax value.
		return  (float)Math.ceil(tax/ROUNDOFF)*ROUNDOFF;
	}
}
