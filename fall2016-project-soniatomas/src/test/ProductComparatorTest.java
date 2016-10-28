package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import controllers.ProductComparator;
import models.Ingredient;
import models.ProductException;
import models.SkincareProduct;

public class ProductComparatorTest {

	@Test
	public void testCommonIngredientsone() throws ProductException {
		ProductComparator pc = new ProductComparator();
		LinkedList<Ingredient> list = new LinkedList<Ingredient>();
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		lotion.addIngredient(new Ingredient("water"));
		lotion.addIngredient(new Ingredient("oil"));
		lotion.addIngredient(new Ingredient("aloe"));
		SkincareProduct sunscreen = new SkincareProduct("BananaBoat Sunscreen");
		sunscreen.addIngredient(new Ingredient("oil"));
		list.add(new Ingredient("oil"));
		assertEquals(pc.getCommonIngredients(lotion, sunscreen), list);
	}

	public void testCommonIngredientstwo() throws ProductException {
		ProductComparator pc = new ProductComparator();
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		lotion.addIngredient(new Ingredient("water"));
		lotion.addIngredient(new Ingredient("beeswax"));
		lotion.addIngredient(new Ingredient("aloe"));
		SkincareProduct sunscreen = new SkincareProduct("BananaBoat Sunscreen");
		sunscreen.addIngredient(new Ingredient("oil"));
		assertEquals(pc.getCommonIngredients(lotion, sunscreen), null);
	}
	
	public void testUniqIngredientsone() throws ProductException {
		ProductComparator pc = new ProductComparator();
		LinkedList<Ingredient> list = new LinkedList<Ingredient>();
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		lotion.addIngredient(new Ingredient("water"));
		SkincareProduct sunscreen = new SkincareProduct("BananaBoat Sunscreen");
		sunscreen.addIngredient(new Ingredient("oil"));
		list.add(new Ingredient("water"));
		list.add(new Ingredient("oil"));
		assertEquals(pc.getUniqueIngredients(lotion, sunscreen), list);
	}
	
	public void testUniqIngredientstwo() throws ProductException {
		ProductComparator pc = new ProductComparator();
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		lotion.addIngredient(new Ingredient("water"));
		SkincareProduct sunscreen = new SkincareProduct("BananaBoat Sunscreen");
		sunscreen.addIngredient(new Ingredient("water"));

		assertEquals(pc.getUniqueIngredients(lotion, sunscreen), null);
	}

}
