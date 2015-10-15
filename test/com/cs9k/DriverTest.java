package com.cs9k;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matt on 10/15/2015.
 */
public class DriverTest
{

   private ByteArrayOutputStream out = new ByteArrayOutputStream();

   @Before
   public void setUp()
   {
      System.setOut(new PrintStream(out));
   }

   @After
   public void tearDown()
   {
      System.setOut(null);
   }

   /**
    * Ensures that the toString method outputs a String matching the expected format.
    */
   @Test
   public void testToString() throws Exception
   {
      Driver driver = new Driver(4);
      assertEquals("Driver 4", driver.toString());
   }
}
