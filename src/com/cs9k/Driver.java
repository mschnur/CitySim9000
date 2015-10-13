package com.cs9k;

/**
 * Created by Matt on 10/13/2015.
 */
public class Driver
{
   private final int number;

   public Driver(int number)
   {
      this.number = number;
   }

   @Override
   public String toString()
   {
      return "Driver " + number;
   }
}
