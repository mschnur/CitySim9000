package com.cs9k;

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
         throws NullPointerException, NumberFormatException, IllegalArgumentException
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

   public static Location getStartLocation(PRNG prng)
   {
      return Location.values()[prng.nextInt(Location.count())];
   }

   public static Location travelToNextLocation(PRNG prng, Driver driver, Location currentLocation)
   {
      int      numPossibleRoutes = currentLocation.getNumberRoutes();
      Route    chosenRoute       = currentLocation.getRoute(prng.nextInt(numPossibleRoutes));
      Location destination       = chosenRoute.getDestinationWhenComingFrom(currentLocation);
      System.out.println(getTravelSummaryString(driver, currentLocation, chosenRoute, destination));
      return destination;
   }

   public static String getTravelSummaryString(Driver driver, Location start, Route route, Location end)
   {
      return (driver.toString()
            + " heading from "
            + start.toString()
            + " to "
            + end.toString()
            + " via "
            + route.toString());
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

      PRNG prng = new PRNG(seed);

      for (int i = 0; i < 5; i++)
      {
         Driver driver = new Driver(i);
         Location currentLocation = getStartLocation(prng);
         do
         {
            currentLocation = travelToNextLocation(prng, driver, currentLocation);
         } while (currentLocation != Location.OUTSIDE_CITY);
         System.out.println(driver.toString() + " has left the city!\n-----");
      }

   }

}
