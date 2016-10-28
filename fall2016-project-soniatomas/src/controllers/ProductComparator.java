package controllers;

import models.*;
import java.util.*;

public class ProductComparator 
{
	/**
	 * Finds the Ingredients that are common among the two Products. Returns the Ingredients are found in both
	 * productOne and productTwo. Only Products of the same type can be compared. 
	 * For example, a user can only compare a SkincareProduct against another SkincareProduct.
	 * If the Products are not of the same type, then a ProductException is thrown.
	 * Returns null if there are no common Ingredients.
	 * @param productOne - Product
	 * @param productTwo - Product to compare
	 * @return Linked list containing ingredients that are only common among the two products.
	 * 
	 */


	public LinkedList<Ingredient> getCommonIngredients(Product productOne, Product productTwo) throws ProductException
	{
		LinkedList<Ingredient> list = new LinkedList<Ingredient>();
		int i, j, common;
		if (productOne.isSameType(productTwo)) {
			common = 0;
			for (i = 0; i < productOne.getIngredients().size(); i++) {
				if (productTwo.containsIngredient(productOne.getIngredients().get(i))) {
					list.add(productOne.getIngredients().get(i));
					common ++;
				}
			}
			if (common == 0) {
				return null;
			}
		}
		else {
			throw new ProductException();
		}
		return list;
	}

	/**
	 * Finds and returns the Ingredients are unique to productOne compared to productTwo, in others words it returns
	 * only the Ingredients that can be found in productOne.
	 * Only Products of the same type can be compared. 
	 * For example, a user can only compare a SkincareProduct against another SkincareProduct.
	 * If the Products are not of the same type, then a ProductException is thrown.
	 * Returns null if there are no unique Ingredients in productOne
	 * @param productOne - Product 
	 * @param productTwo - Product to compare against
	 * @return Linked list containing ingredients that are only common among the two products.
	 * 
	 */
	public LinkedList<Ingredient> getUniqueIngredients(Product productOne, Product productTwo) throws ProductException
	{
		LinkedList<Ingredient> listone = productOne.getIngredients();
		LinkedList<Ingredient> listtwo = productTwo.getIngredients();
		LinkedList<Ingredient> returnList = new LinkedList<Ingredient>();
		int i, j, uniq;
		if (productOne.isSameType(productTwo)) {
			uniq = 0;
			for (i = 0; i < listone.size(); i++) {
				if (listone.contains(listtwo.get(i))) {
					Ingredient rm = listtwo.get(i);
					listone.remove(rm);
					listtwo.remove(rm);
				}
				else {
					uniq++;
				}
			}
			if (uniq == 0) {
				return null;
			}
			
			for (i = 0; i < listone.size(); i++) {
				returnList.add(listone.get(i));
			}
			for (j = 0; j < listtwo.size();j++) {
				returnList.add(listtwo.get(j));
			}
		}
		else {
			throw new ProductException();
		}
		return returnList;
	}
	
	
	
	
}
