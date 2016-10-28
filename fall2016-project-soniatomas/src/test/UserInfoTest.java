package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.UserInformation;


public class UserInfoTest {

	UserInformation ui = new UserInformation();
	
	@Test
  public void testUserName() {
  	ui.setUsername("Doug");
    assertEquals("Doug", ui.getUsername());
  }

	@Test
	  public void testUserName1() {
	  	ui.setUsername("");
	    assertEquals("", ui.getUsername());
	  }
	
	@Test
	  public void testUserName2() {
	  	ui.setUsername("Sally10");
	    assertEquals("Sally10", ui.getUsername());
	  }
	
	public void testFirstName() {
  	ui.setFirstName("Fanny");
    assertEquals("Fanny", ui.getFirstName());
  }

	@Test
	  public void testFirstName1() {
	  	ui.setFirstName("");
	    assertEquals("", ui.getFirstName());
	  }
	
	@Test
	  public void testFirstName2() {
	  	ui.setFirstName("Sally10");
	    assertEquals("Sally10", ui.getFirstName());
	  }
	
	@Test
		public void testLastName() {
			ui.setLastName("Thompson");
		  assertEquals("Thompson", ui.getLastName());
		}
		
	@Test
	  public void testLastName1() {
	  	ui.setLastName("");
	    assertEquals("", ui.getLastName());
	  }
		
	@Test
	  public void testLastName2() {
	  	ui.setLastName("Johnson18");
	    assertEquals("Johnson18", ui.getLastName());
	  }

	@Test
		public void testEmail() {
			ui.setEmail("slack@gmail.com");
		  assertEquals("slack@gmail.com", ui.getEmail());
		}
	
	@Test
		public void testEmail1() {
			ui.setEmail("");
		  assertEquals("", ui.getEmail());
		}
	
	@Test
		public void testEmail2() {
			ui.setEmail("2plank@hotmail.com");
			assertEquals("2plank@hotmail.com", ui.getEmail());
		}
	
		public static void main(String [] args) {
	    org.junit.runner.JUnitCore.main("UserTests");
		}	
}
