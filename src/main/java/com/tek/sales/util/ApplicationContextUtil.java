/**
 * 
 */
package com.tek.sales.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dileepkumarrongali@yahoo.com
 *
 */
public class ApplicationContextUtil {

	private static ApplicationContext applicationContext;

	/**
	 * This method is used to get class instance using Dependency Injection mechanism.
	 *  It reads the Spring configuration file and fetches the required class instance by 
	 *  passing the class id configured in the xml file. 
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		//Check for null value of class id
		if (beanName != null) {
			//get application context
			applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
			//return bean instance
			return applicationContext.getBean(beanName);
		} else
			return null;

	}

}
