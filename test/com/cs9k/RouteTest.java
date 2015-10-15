package com.cs9k;

import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Matt on 10/15/2015.
 */
public class RouteTest
{

   /**
    * Ensure that when this Route is one way, it has the proper connections for each
    * of the locations which is connects, and that the proper location is retrieved
    * based on the current location.
    */
   @Test
   public void testGetDestinationWhenComingFrom_oneWay() throws Exception
   {
      // use reflection to access the private constructor
      final Constructor<Route> constructor = Route.class.getDeclaredConstructor(String.class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            constructor.setAccessible(true);
            return null; // nothing to return
         }
      });

      // use reflection to access the private method setConnections
      final Method method = Route.class.getDeclaredMethod("setConnections", boolean.class, Location[].class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            method.setAccessible(true);
            return null; // nothing to return
         }
      });

      Route route = constructor.newInstance("blah");
      Location loc1 = Mockito.mock(Location.class), loc2 = Mockito.mock(Location.class);
      method.invoke(route, false, new Location[]{ loc1, loc2});

      assertEquals("loc1 ---> loc2", route.getDestinationWhenComingFrom(loc1), loc2);
      assertNull("loc2 -X-> loc1", route.getDestinationWhenComingFrom(loc2));
   }

   /**
    * Ensure that when this Route is two way, it has the proper connections for each
    * of the locations which is connects, and that the proper location is retrieved
    * based on the current location.
    */
   @Test
   public void testGetDestinationWhenComingFrom_twoWay() throws Exception
   {
      // use reflection to access the private constructor
      final Constructor<Route> constructor = Route.class.getDeclaredConstructor(String.class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            constructor.setAccessible(true);
            return null; // nothing to return
         }
      });

      // use reflection to access the private method setConnections
      final Method method = Route.class.getDeclaredMethod("setConnections", boolean.class, Location[].class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            method.setAccessible(true);
            return null; // nothing to return
         }
      });

      Route route = constructor.newInstance("blah");
      Location loc1 = Mockito.mock(Location.class), loc2 = Mockito.mock(Location.class);
      method.invoke(route, true, new Location[]{ loc1, loc2});

      assertEquals("loc1 ---> loc2", route.getDestinationWhenComingFrom(loc1), loc2);
      assertEquals("loc2 ---> loc1", route.getDestinationWhenComingFrom(loc2), loc1);
   }

   /**
    * Ensures that the toString method outputs a String matching the expected format.
    */
   @Test
   public void testToString() throws Exception
   {
      // use reflection to access the private constructor
      final Constructor<Route> constructor = Route.class.getDeclaredConstructor(String.class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            constructor.setAccessible(true);
            return null; // nothing to return
         }
      });

      Route route = constructor.newInstance("name");
      assertEquals("name", route.toString());
   }
}
