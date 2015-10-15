package com.cs9k;

import java.util.Random;

public class CitySimMain
{

   /**
    * Parses and return a single long that is expected to be the first
    * and only argument in the command line parameters.
    *
    * @param args the command line parameters
    *
    * @return the valid long that is the first and only command line parameter
    *
    * @throws IllegalArgumentException if there are zero or more than one elements in {@code args} or
    *                                  the first parameter of {@code args} cannot be parsed to a valid long
    */
   public static long parseArgs(String[] args)
         throws NullPointerException, IllegalArgumentException
   {
      if (args.length == 0)
      {
         System.out.println(
               "0 command line arguments given.  1 command line argument (the PRNG seed) is required.");
         throw new IllegalArgumentException("0 arguments given");
      }
      else if (args.length > 1)
      {
         System.out.println(
               "More than 1 command line arguments given.  Only 1 command line argument (the PRNG seed) is allowed.");
         throw new IllegalArgumentException("More than 1 arguments given");
      }
      else
      {
         try
         {
            return Long.parseLong(args[0], 10);
         }
         catch (NumberFormatException nfe)
         {
            System.out.println(
                  "Invalid value given for the PRNG seed given.  Must be an integer in the range [-2^63, 2^63 - 1]");
            throw new IllegalArgumentException(nfe);
         }
      }
   }





   public static void main(String[] args)
   {
      long seed;
      try
      {
         seed = parseArgs(args);
      }
      catch (IllegalArgumentException iae)
      {
         System.exit(-1);
         return;
      }

      Random random = new Random(seed);

      for (int i = 0; i < 5; i++)
      {
         Driver driver = new Driver(i);
         CitySim sim = new CitySim(random);
         Location currentLocation = sim.getStartLocation();
         do
         {
            currentLocation = sim.travelToNextLocation(driver, currentLocation);
         } while (currentLocation != Location.OUTSIDE_CITY);
         System.out.println(driver.toString() + " has left the city!\n-----");
      }

   }

}
