package models;

import java.util.*;




public class ProductHistory {
	private HashMap<String, MakeupProduct> makeupProductHistory = new HashMap<String, MakeupProduct>();
	private HashMap<String, SkincareProduct> skincareProductHistory = new HashMap<String, SkincareProduct>();
	
	/**
	 * Constructor for ProductHistory
	 * Initializes class variable productHistory
	 */
	public ProductHistory()
	{
		this.makeupProductHistory = makeupProductHistory;
		this.skincareProductHistory = skincareProductHistory;
	}
	/**
	 * Adds a makeup product to productHistory;
	 * @param string
	 */
	
	public void addMakeupProduct(String string, MakeupProduct mp)
	{
		makeupProductHistory.put(string, mp);
	}
	
	
	/**
	 * Adds a skincare product to productHistory;
	 * @param string
	 */
	
	public void addSkincareProduct(String string, SkincareProduct sp)
	{
		skincareProductHistory.put(string, sp);
	} 
	
	/**
	 * gets a makeup product from ProductHistory
	 * @param makeup product
	 * @return Product or null if Product cannot be found in ProductHistory
	 */
	public Product getMakeupProduct(MakeupProduct mp)
	{
		if (makeupProductHistory.containsKey(mp)) {
			MakeupProduct p = makeupProductHistory.get(mp);
			return p;
		} 
		else {
			return null;
		}
	}
	
	/**
	 * gets a skincare product from ProductHistory
	 * @param skincare product
	 * @return Product or null if Product cannot be found in ProductHistory
	 */
	public Product getSkincareProduct(SkincareProduct sp)
	{
		if (skincareProductHistory.containsKey(sp)) {
			SkincareProduct p = skincareProductHistory.get(sp);
			return p;
		} 
		else {
			return null;
		}
	}
	/**
	 * removes a skincare Product form ProductHistory 
	 * @param productName
	 * @return Product that has been removed or null if Product cannot be found
	 * in ProductHistory
	 */
	public void removeSkincareProduct(String skinCareProductName)
	{
		if (skincareProductHistory.containsKey(skinCareProductName)) {
			skincareProductHistory.remove(skinCareProductName);
		}
	}

	/**
	 * removes a makeup Product form ProductHistory 
	 * @param productName
	 * @return Product that has been removed or null if Product cannot be found
	 * in ProductHistory
	 */
	public void removeMakeupProduct(String makeupProductName)
	{
		if (makeupProductHistory.containsKey(makeupProductName)) {
			makeupProductHistory.remove(makeupProductName);
		}
	}	
}
