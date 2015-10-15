package com.cs9k;

import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matt on 10/15/2015.
 */
public class LocationTest
{

   /**
    * Ensures that the number of routes is correctly based on the number of routes in the internal routesOut
    * array (which is filled based on the input to the setRoutesOut method).
    */
   @Test
   public void testGetNumberRoutes() throws Exception
   {
      // use reflection to access the private constructor
      final Constructor<Location> constructor = Location.class.getDeclaredConstructor(String.class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            constructor.setAccessible(true);
            return null; // nothing to return
         }
      });

      // use reflection to access the private method setRoutesOut
      final Method method = Location.class.getDeclaredMethod("setRoutesOut", Route[].class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            method.setAccessible(true);
            return null; // nothing to return
         }
      });

      Location location = constructor.newInstance("blah");
      Route route1 = Mockito.mock(Route.class), route2 = Mockito.mock(Route.class), route3 = Mockito.mock(Route.class);
      method.invoke(location, new Object[]{ new Route[]{ route1, route2, route3}});

      assertEquals(location.getNumberRoutes(), 3);
   }

   /**
    * Ensures that the route retrieved by getRoute is from the given index in the routesOut
    * array (which is filled based on the input to the setRoutesOut method).
    */
   @Test
   public void testGetRoute() throws Exception
   {
      // use reflection to access the private constructor
      final Constructor<Location> constructor = Location.class.getDeclaredConstructor(String.class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            constructor.setAccessible(true);
            return null; // nothing to return
         }
      });

      // use reflection to access the private method setRoutesOut
      final Method method = Location.class.getDeclaredMethod("setRoutesOut", Route[].class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            method.setAccessible(true);
            return null; // nothing to return
         }
      });

      Location location = constructor.newInstance("blah");
      Route route1 = Mockito.mock(Route.class), route2 = Mockito.mock(Route.class), route3 = Mockito.mock(Route.class);
      method.invoke(location, new Object[]{new Route[]{route1, route2, route3}});

      assertEquals(location.getRoute(1), route2);
   }

   /**
    * Ensures that the toString method outputs a String matching the expected format.
    */
   @Test
   public void testToString() throws Exception
   {
      // use reflection to access the private constructor
      final Constructor<Location> constructor = Location.class.getDeclaredConstructor(String.class);
      AccessController.doPrivileged(new PrivilegedAction<Void>()
      {
         public Void run()
         {
            constructor.setAccessible(true);
            return null; // nothing to return
         }
      });

      Location location = constructor.newInstance("name");
      assertEquals("name", location.toString());
   }
}
