package test;

import static org.junit.Assert.*;

import org.junit.Test;
import models.*;

import java.util.LinkedList;


public class MakeupProductTest {

	@Test
	public void TestGetName() {
		MakeupProduct mascara = new MakeupProduct("Maybelline Mascara");
		assertEquals("maybelline mascara", mascara.getName());
	}
	
	@Test
	public void TestGetIngredients() {
		MakeupProduct mascara = new MakeupProduct("Maybelline Mascara");
		mascara.addIngredient(new Ingredient("water"));
		mascara.addIngredient(new Ingredient("paraffin"));
		mascara.addIngredient(new Ingredient("beeswax"));
		LinkedList<Ingredient> ingredients = mascara.getIngredients();
		assertEquals(true, ingredients.contains(new Ingredient("water")));
		assertEquals(true, ingredients.contains(new Ingredient("paraffin")));
		assertEquals(true, ingredients.contains(new Ingredient("beeswax")));	
	}
	
	@Test
	public void TestContainsIngredientTrue() {
		MakeupProduct mascara = new MakeupProduct("Maybelline Mascara");
		mascara.addIngredient(new Ingredient("water"));
		mascara.addIngredient(new Ingredient("paraffin"));
		mascara.addIngredient(new Ingredient("beeswax"));
		assertEquals(true, mascara.containsIngredient(new Ingredient("water")));
	}
	
	@Test
	public void TestContainsIngredientFalse() {
		MakeupProduct mascara = new MakeupProduct("Maybelline Mascara");
		mascara.addIngredient(new Ingredient("water"));
		mascara.addIngredient(new Ingredient("paraffin"));
		mascara.addIngredient(new Ingredient("beeswax"));
		assertEquals(false, mascara.containsIngredient(new Ingredient("petroleum")));
	}
	
	@Test
	public void TestIsSameTypeTrue() {
		MakeupProduct mascara = new MakeupProduct("Maybelline Mascara");
		MakeupProduct eyeliner = new MakeupProduct("Maybelline EyeLiner");
		assertEquals(true, mascara.isSameType(eyeliner));
	}
	@Test
	public void TestIsSameTypeFalse() {
		MakeupProduct mascara = new MakeupProduct("Maybelline Mascara");
		SkincareProduct lotion = new SkincareProduct("Jergen's Lotion");
		assertEquals(false, mascara.isSameType(lotion));
	}
}
