/**
  You are given two jugs with capacities jug1Capacity and jug2Capacity liters.
  There is an infinite amount of water supply available.
  Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

  If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.

  Operations allowed:
      Fill any of the jugs with water.
      Empty any of the jugs.
      Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
**/
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity) {
            return true;
        }
        
        int largeJugCap = jug1Capacity >= jug2Capacity ? jug1Capacity : jug2Capacity;
        int smallJugCap = jug1Capacity >= jug2Capacity ? jug2Capacity : jug1Capacity;
        
        // Fill the first jug
        int largeJugContents = largeJugCap;
        int smallJugContents = 0;
        
        // Pour the water to the second jug
        while (largeJugContents > smallJugCap) {
            largeJugContents -= smallJugCap;
        }
        smallJugContents = largeJugContents;
        largeJugContents = 0; 
        
        // Pour the water to the second jug again for the final measurement
        largeJugContents = largeJugCap;
        largeJugContents -= smallJugCap - smallJugContents; 
        
        if (largeJugContents == targetCapacity) {
            return true;
        }
        
        return false;
    }
}
