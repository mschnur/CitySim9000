package com.cs9k;


import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CitySimMainTest
{

   /**
    * Tests that a valid long passed as the lone argument from the command line
    * arguments (i.e. represented as a String array) is processed and returned
    * from the parseArgs method.
    */
   @Test
   public void testParseArgs_validValue() throws Exception
   {
      long standardTestValue = 4L;
      assertEquals("parseArgs: Standard valid value",
                   CitySimMain.parseArgs(new String[]{Long.toString(standardTestValue, 10)}),
                   standardTestValue);
      // test that the minimum integer works
      assertEquals("parseArgs: Min valid value",
                   CitySimMain.parseArgs(new String[]{Long.toString(Long.MIN_VALUE, 10)}),
                   Long.MIN_VALUE);
      // test that the max integer works
      assertEquals("parseArgs: Max valid value",
                   CitySimMain.parseArgs(new String[]{Long.toString(Long.MAX_VALUE, 10)}),
                   Long.MAX_VALUE);
   }

   /**
    * Tests that an invalid value as the lone argument from the command line
    * arguments (i.e. represented as a String array) causes an IllegalArgumentException
    * to be thrown in the parseArgs method.
    */
   @Test
   public void testParseArgs_invalidValue() throws Exception
   {
      // test that a number less than min fails
      boolean fail = true;
      try
      {
         BigInteger bigInt = new BigInteger(Long.toString(Long.MIN_VALUE)).subtract(BigInteger.ONE);
         CitySimMain.parseArgs(new String[]{bigInt.toString(10)});
      }
      catch (IllegalArgumentException ex)
      {
         fail = false;
      }
      finally
      {
         if (fail)
         {
            fail("parseArgs: seed less than Long.MIN_VALUE did not throw IllegalArgumentException");
         }
      }

      // test that a number greater than max fails
      fail = true;
      try
      {
         BigInteger bigInt = new BigInteger(Long.toString(Long.MAX_VALUE)).add(BigInteger.ONE);
         CitySimMain.parseArgs(new String[]{bigInt.toString(10)});
      }
      catch (IllegalArgumentException ex)
      {
         fail = false;
      }
      finally
      {
         if (fail)
         {
            fail("parseArgs: seed larger than Long.MAX_VALUE did not throw IllegalArgumentException");
         }
      }

      // tests that a non-integer fails
      fail = true;
      try
      {
         CitySimMain.parseArgs(new String[]{"Not an integer"});
      }
      catch (IllegalArgumentException ex)
      {
         fail = false;
      }
      finally
      {
         if (fail)
         {
            fail("parseArgs: non-integer seed argument did not throw IllegalArgumentException\"");
         }
      }
   }


   /**
    * Tests that an 0 command line parameters (represented as
    * a String array) causes an IllegalArgumentException to be thrown in the
    * parseArgs method.
    */
   @Test
   public void testParseArgs_zeroArgs() throws Exception
   {
      // test that no args fails
      boolean fail = true;
      try
      {
         CitySimMain.parseArgs(new String[0]);
      }
      catch (IllegalArgumentException iae)
      {
         fail = false;
      }
      finally
      {
         if (fail)
         {
            fail("parseArgs: 0 command line parameters did not throw IllegalArgumentException");
         }
      }
   }

   /**
    * Tests that more than 1  command line parameters (represented as
    * a String array) causes an IllegalArgumentException to be thrown in the
    * parseArgs method.
    */
   @Test
   public void testParseArgs_moreThanOneArgs() throws Exception
   {
      // test that more than 1 args fails
      boolean fail = true;
      try
      {
         CitySimMain.parseArgs(new String[2]);
      }
      catch (IllegalArgumentException iae)
      {
         fail = false;
      }
      finally
      {
         if (fail)
         {
            fail("parseArgs: > 1 command line parameters did not throw IllegalArgumentException");
         }
      }
   }
//
//   @Test
//   public void testGetNextDriver_


}

