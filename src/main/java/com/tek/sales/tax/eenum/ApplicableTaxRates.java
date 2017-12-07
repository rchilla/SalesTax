/**
 * 
 */
package com.tek.sales.tax.eenum;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public class ApplicableTaxRates {
	public enum TaxType {
		NO_TAX(0),
		BASIC_SALES_TAX(0.1f),
		IMPORTED_TAX(0.05f) ,
		BOTH_TAXES(BASIC_SALES_TAX.getApplicableTax()+IMPORTED_TAX.getApplicableTax());
		//hold the applicable tax for the item
		private float applicableTax;

		private TaxType(float tax) {
			applicableTax = tax;
		}

		public float getApplicableTax() {
			return applicableTax;
		}
	}
}
