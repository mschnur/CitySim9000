package com.cs9k;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matt on 10/13/2015.
 */
public enum Route
{
   MEOW("Meow St."),
   CHIRP("Chirp St."),
   FOURTH("Fourth Ave."),
   FIFTH("Fifth Ave.");

   static
   {
      MEOW.setConnections(true, Location.COFFEESHOP, Location.MALL);
      CHIRP.setConnections(true, Location.BOOKSTORE, Location.UNIVERSITY);
      FOURTH.setConnections(false, Location.OUTSIDE_CITY, Location.MALL, Location.BOOKSTORE, Location.OUTSIDE_CITY);
      FIFTH.setConnections(false,
                           Location.OUTSIDE_CITY,
                           Location.UNIVERSITY,
                           Location.COFFEESHOP,
                           Location.OUTSIDE_CITY);
   }

   private final String                  name;
   private       Map<Location, Location> connections;

   Route(String name)
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
