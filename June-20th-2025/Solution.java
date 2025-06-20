class Solution {

    private int getManhattanDistance(int north, int south, int east, int west, int k) {
        // System.out.println(north + " " + south + " " + east + " " + west);
        if(north > south) {
            int temp = south;
            south -= Math.min(south, k);
            north += temp - south;
            k -= temp - south;
        } else {
            int temp = north;
            north -= Math.min(north, k);
            south += temp - north;
            k -= temp - north;
        }

        // System.out.println(north + " " + south + " " + east + " " + west);


        if(east > west) {
            int temp = west;
            west -= Math.min(west, k);
            east += temp - west;
            k -= temp - west;
        } else {
            int temp = east;
            east -= Math.min(east, k);
            west += temp - east;
            k -= temp - east;
        }

        // System.out.println(north + " " + south + " " + east + " " + west);


        int result =  (int)Math.abs(north - south) + Math.abs(west - east);

        // System.out.println(result);

        return result;

    }

    public int maxDistance(String s, int k) {
        int north = 0, south = 0, east = 0, west = 0;
        int pathLength = s.length();
        System.out.println(pathLength);
        int maxManhattanDistance = 0;
        for(int idx = 0; idx < pathLength; idx++) {
            // System.out.println(s.substring(0, idx + 1));
            char dir = s.charAt(idx);
            switch (dir) {
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    west++;
                    break;
                default:
                    System.out.println("Invalid direction at index " + idx + ": " + dir);
            }

            int currManhattanDistance = getManhattanDistance(north, south, east, west, k);
            maxManhattanDistance = Math.max(maxManhattanDistance, currManhattanDistance);
        }

        return maxManhattanDistance;
    }
}
