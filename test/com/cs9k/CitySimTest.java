package com.cs9k;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by Matt on 10/13/2015.
 */
public class CitySimTest
{

   private ByteArrayOutputStream out = new ByteArrayOutputStream();

   @Before
   public void setUp()
   {
      System.setOut(new PrintStream(out));
   }

   @After
   public void tearDown()
   {
      System.setOut(null);
   }

   /**
    * Tests that the start location is determined by retrieving a location from an index
    * (determined by the Random object supplied to the CitySim constructor) in the
    * values array of the Location class.
    */
   @Test
   public void testGetStartLocation() throws Exception
   {
      Random random = Mockito.mock(Random.class);
      when(random.nextInt(anyInt())).thenReturn(1);
      CitySim sim = new CitySim(random);
      assertEquals(sim.getStartLocation(), Location.values[1]);
   }

   /**
    * Tests that the after choosing a route to go down, the next location
    * can is determined by getting the location to which the selected route
    * connects the current location.
    */
   @Test
   public void testTravelToNextLocation() throws Exception
   {
      Random random = Mockito.mock(Random.class);
      Driver driver = Mockito.mock(Driver.class);
      Location currLoc = Mockito.mock(Location.class);
      Route chosenRoute = Mockito.mock(Route.class);
      Location destination = Mockito.mock(Location.class);

      when(currLoc.getRoute(anyInt())).thenReturn(chosenRoute);
      when(chosenRoute.getDestinationWhenComingFrom(currLoc)).thenReturn(destination);

      CitySim cs = new CitySim(random);

      assertEquals(destination, cs.travelToNextLocation(driver, currLoc));
   }

   /**
    * Tests that the travel summary is printed such that it matches the expected format.
    */
   @Test
   public void testPrintTravelSummaryString() throws Exception
   {
      Driver   driver = Mockito.mock(Driver.class);
      Location start  = Mockito.mock(Location.class);
      Route    route  = Mockito.mock(Route.class);
      Location end    = Mockito.mock(Location.class);

      when(driver.toString()).thenReturn("driver");
      when(start.toString()).thenReturn("start");
      when(route.toString()).thenReturn("route");
      when(end.toString()).thenReturn("end");

      CitySim.printTravelSummaryString(driver, start, route, end);

      assertEquals("driver heading from start to end via route" + System.lineSeparator(), out.toString());
   }
}
