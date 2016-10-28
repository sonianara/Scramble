package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.MakeupProduct;
import models.ProductHistory;
import models.SkincareProduct;


public class ProductHistoryTest {
	ProductHistory productHistory = new ProductHistory();
	
	@Test
	public void testAddProduct() {
		SkincareProduct sp = new SkincareProduct("Moisturizer");
		MakeupProduct mp = new MakeupProduct("Foundation");
		productHistory.addSkincareProduct("Moisturizer", sp);
		productHistory.addMakeupProduct("Foundation", mp);
		//assertEquals(sp, productHistory.getSkincareProduct(sp));
		//assertEquals(mp, productHistory.getMakeupProduct(mp));
		
	}
}
