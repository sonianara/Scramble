package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Ingredient;

public class IngredientTest {

	@Test
	public void TestGetName() {
		Ingredient water = new Ingredient("water");
		assertEquals("water", water.getName());
	}
	
	@Test
	public void TestGetNameLowerCase() {
		Ingredient cocos_nucifera = new Ingredient("Cocos Nucifera");
		assertEquals("cocos nucifera", cocos_nucifera.getName());
		
	}
	
	@Test
	public void TestIsEqualToTrue() {
		Ingredient water = new Ingredient("water");
		assertEquals(true, water.isEqualTo(new Ingredient("water")));
	}
	
	@Test
	public void TestIsEqualToFalse() {
		Ingredient cocos_nucifera = new Ingredient("Cocos Nucifera");
		Ingredient water = new Ingredient("water");
		assertEquals(false, water.isEqualTo(cocos_nucifera));
		
	}

	

}
