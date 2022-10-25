package Util;

import java.util.Random;

public interface Util {

    /**
     * make the random function easier to use
     * @param upperBound the upper bound
     * @param lowerBound the lower bound
     * @return a random int between upper and lower bound or 0 if lower is upper than higher
     */
     static int random(int upperBound, int lowerBound){
         if (upperBound >= lowerBound) {
                 return new Random().nextInt(upperBound - lowerBound + 1) + lowerBound;
         } else {
             return 0;
         }
    }
}
