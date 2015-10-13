package com.cs9k;

import java.util.Random;

/**
 * Created by Matt on 10/13/2015.
 */
public class PRNG
{
   private final Random random;
   private final long seed;

   public PRNG(long seed)
   {
      this.seed = seed;
      this.random = new Random(seed);
   }

   public int nextInt(int exclusiveUpperBound)
   {
      return random.nextInt(exclusiveUpperBound);
   }

}
