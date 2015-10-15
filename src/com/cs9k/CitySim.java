package com.cs9k;

import java.util.Random;

/**
 * Created by Matt on 10/13/2015.
 */
public class CitySim
{
   private final Random random;

   public CitySim(Random rand)
   {
      this.random = rand;
   }

   public static void printTravelSummaryString(Driver driver, Location start, Route route, Location end)
   {
      System.out.println(driver.toString()
                               + " heading from "
                               + start.toString()
                               + " to "
                               + end.toString()
                               + " via "
                               + route.toString());
   }

   public Location getStartLocation()
   {
      return Location.values[random.nextInt(Location.COUNT)];
   }

   public Location travelToNextLocation(Driver driver, Location currentLocation)
   {
      int      numPossibleRoutes = currentLocation.getNumberRoutes();
      Route    chosenRoute       = currentLocation.getRoute(random.nextInt(numPossibleRoutes));
      Location destination       = chosenRoute.getDestinationWhenComingFrom(currentLocation);
      printTravelSummaryString(driver, currentLocation, chosenRoute, destination);
      return destination;
   }


}
