package com.cs9k;

/**
 * Created by Matt on 10/12/2015.
 */
public enum Location
{
   MALL("Mall"),
   BOOKSTORE("Bookstore"),
   COFFEESHOP("Coffee Shop"),
   UNIVERSITY("University"),
   OUTSIDE_CITY("Outside City");

   private static final int numLocations = values().length;

   static
   {
      MALL.setRoutesOut(Route.FOURTH, Route.MEOW);
      BOOKSTORE.setRoutesOut(Route.FOURTH, Route.CHIRP);
      COFFEESHOP.setRoutesOut(Route.FIFTH, Route.MEOW);
      UNIVERSITY.setRoutesOut(Route.FIFTH, Route.CHIRP);
      OUTSIDE_CITY.setRoutesOut(Route.FIFTH, Route.FOURTH);
   }

   private final String  name;
   private       Route[] routesOut;

   Location(String name)
   {
      this.name = name;
   }

   public static int count()
   {
      return numLocations;
   }

   public int getNumberRoutes()
   {
      return routesOut.length;
   }

   public Route getRoute(int routeIndex)
   {
      return routesOut[routeIndex];
   }

   @Override
   public String toString()
   {
      return name;
   }

   private void setRoutesOut(Route... routesOut)
   {
      this.routesOut = routesOut;
   }
}
