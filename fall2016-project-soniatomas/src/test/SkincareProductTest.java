package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import models.*;

public class SkincareProductTest {

	@Test
	public void TestGetName() {
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		assertEquals("jergen's lotion", lotion.getName());
	}
	
	@Test
	public void TestGetIngredients() {
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		lotion.addIngredient(new Ingredient("water"));
		lotion.addIngredient(new Ingredient("paraffin"));
		lotion.addIngredient(new Ingredient("beeswax"));
		LinkedList<Ingredient> ingredients = lotion.getIngredients();
		assertEquals(true, ingredients.contains(new Ingredient("water")));
		assertEquals(true, ingredients.contains(new Ingredient("paraffin")));
		assertEquals(true, ingredients.contains(new Ingredient("beeswax")));	
	}
	
	@Test
	public void TestContainsIngredientTrue() {
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		lotion.addIngredient(new Ingredient("water"));
		lotion.addIngredient(new Ingredient("paraffin"));
		lotion.addIngredient(new Ingredient("beeswax"));
		assertEquals(true, lotion.containsIngredient(new Ingredient("water")));
	}
	
	@Test
	public void TestContainsIngredientFalse() {
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		lotion.addIngredient(new Ingredient("water"));
		lotion.addIngredient(new Ingredient("paraffin"));
		lotion.addIngredient(new Ingredient("beeswax"));
		assertEquals(false, lotion.containsIngredient(new Ingredient("petroleum")));
	}
	
	@Test
	public void TestIsSameTypeTrue() {
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		SkincareProduct sunscreen = new SkincareProduct("BananaBoat Sunscreen");
		assertEquals(true, lotion.isSameType(sunscreen));
	}
	@Test
	public void TestIsSameTypeFalse() {
		MakeupProduct mascara = new MakeupProduct("Maybelline Mascara");
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		assertEquals(false, lotion.isSameType(mascara));
	}

}
