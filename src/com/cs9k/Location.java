package com.cs9k;

/**
 * This was originally an enum, but was changed to a class so it could be mocked.
 * <p>
 * Created by Matt on 10/12/2015.
 */
public class Location
{
   public static final Location MALL         = new Location("Mall");
   public static final Location BOOKSTORE    = new Location("Bookstore");
   public static final Location COFFEE_SHOP  = new Location("Coffee Shop");
   public static final Location UNIVERSITY   = new Location("University");
   public static final Location OUTSIDE_CITY = new Location("Outside City");

   public static final Location[] values = new Location[]
         {
               MALL,
               BOOKSTORE,
               COFFEE_SHOP,
               UNIVERSITY,
               OUTSIDE_CITY
         };

   public static final int COUNT = values.length;

   static
   {
      MALL.setRoutesOut(Route.FOURTH, Route.MEOW);
      BOOKSTORE.setRoutesOut(Route.FOURTH, Route.CHIRP);
      COFFEE_SHOP.setRoutesOut(Route.FIFTH, Route.MEOW);
      UNIVERSITY.setRoutesOut(Route.FIFTH, Route.CHIRP);
      OUTSIDE_CITY.setRoutesOut(Route.FIFTH, Route.FOURTH);
   }

   private final String  name;
   private       Route[] routesOut;

   private Location(String name)
   {
      this.name = name;
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
