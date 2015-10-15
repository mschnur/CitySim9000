package com.cs9k;

import java.util.HashMap;
import java.util.Map;

/**
 * This was originally an enum, but was changed to a class so it could be mocked.
 *
 * Created by Matt on 10/13/2015.
 */
public class Route
{
   public static final Route MEOW = new Route("Meow St.");
   public static final Route CHIRP = new Route("Chirp St.");
   public static final Route FOURTH = new Route("Fourth Ave.");
   public static final Route FIFTH = new Route("Fifth Ave.");

   static
   {
      MEOW.setConnections(true, Location.COFFEE_SHOP, Location.MALL);
      CHIRP.setConnections(true, Location.BOOKSTORE, Location.UNIVERSITY);
      FOURTH.setConnections(false, Location.OUTSIDE_CITY, Location.MALL, Location.BOOKSTORE, Location.OUTSIDE_CITY);
      FIFTH.setConnections(false,
                           Location.OUTSIDE_CITY,
                           Location.UNIVERSITY,
                           Location.COFFEE_SHOP,
                           Location.OUTSIDE_CITY);
   }

   private final String                  name;
   private       Map<Location, Location> connections;

   private Route(String name)
   {
      this.name = name;
   }

   public Location getDestinationWhenComingFrom(Location comingFrom)
   {
      return connections.get(comingFrom);
   }

   @Override
   public String toString()
   {
      return name;
   }

   private void setConnections(boolean twoWay, Location... connects)
   {
      this.connections = new HashMap<>(connects.length);
      if (connects.length >= 2)
      {
         for (int i = 0, j = 1; j < connects.length; i++, j++)
         {
            connections.put(connects[i], connects[j]);
            if (twoWay)
            {
               connections.put(connects[j], connects[i]);
            }
         }
      }
   }
}
