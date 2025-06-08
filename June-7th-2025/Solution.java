import java.util.*;

// string, Greedy, hash 
class Solution {

    public static class InvalidStateException extends RuntimeException {
        public InvalidStateException(String message) {
            super(message);
        }
    }

    public String clearStars(String s) {

        int sLength = s.length();  

        TreeMap<Character, List<Integer>> charToPositions = new TreeMap<>();

        for (int idx = 0; idx < sLength; idx++) {
            char ch = s.charAt(idx);
            if (ch == '*') {
                if (charToPositions.isEmpty()) {
                    throw new InvalidStateException(String.format(
                        "Invalid State Exception: No more character's remaining on the left side while processing the * at index %d for String: '%s', Please check if the count of the non-star character's is less or equal to the stars in the left of the index in the given input String", 
                        idx, s));
                } else {
                    Character smallestCharacter = charToPositions.firstKey();

                    List<Integer> positions = charToPositions.get(smallestCharacter);

                    positions.remove(positions.size() - 1);

                    if (positions.isEmpty()) {
                        charToPositions.remove(smallestCharacter);
                    }
                }
            } else {
                List<Integer> positions = charToPositions.getOrDefault(ch, new ArrayList<>());
                positions.add(idx);
                charToPositions.put(ch, positions);
            }
        }

        TreeMap<Integer, Character> positionToChar = new TreeMap<>();
        for (Map.Entry<Character, List<Integer>> entry : charToPositions.entrySet()) {
            Character ch = entry.getKey();
            List<Integer> indices = entry.getValue();
            indices.forEach(idx -> positionToChar.put(idx, ch));
        }

        StringBuilder lesoSmallestString = new StringBuilder();
        for (Map.Entry<Integer, Character> entry : positionToChar.entrySet()) {
            Character ch = entry.getValue();
            lesoSmallestString.append(ch);
        }

        return lesoSmallestString.toString();
    }
}

