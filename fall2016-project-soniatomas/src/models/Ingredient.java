package models;

public class Ingredient {
	private String name;
	
	public Ingredient(String name) {
		this.name = new String(name.toLowerCase());
	}
	
	public String getName() {
		return new String(name);
	}
	
	public boolean isEqualTo(Ingredient ingredient){
		return name.equals(ingredient.getName()); 
	}
	
	@Override
	public boolean equals(Object o)
	{
		Ingredient otherIngredient = (Ingredient)o;
		return name.equals(otherIngredient.getName());
	}
	
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
	

}
