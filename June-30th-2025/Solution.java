class Solution {
    public int findLHS(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0) return 0;
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for(int num: nums) {
            freqMap.compute(num, (key, value) -> Objects.nonNull(value) ? value + 1 : 1);
        }
        Integer[] keys = freqMap.keySet()
                                .stream()
                                .toArray(Integer[]::new);


        int numberOfDistinctValues = keys.length;
        int maxLHSSubsequence = 0;

        for(int idx = 1; idx < numberOfDistinctValues; idx++) {
            if(Math.abs((long)keys[idx] - keys[idx - 1]) == 1) {
                maxLHSSubsequence = Math.max(maxLHSSubsequence, freqMap.get(keys[idx]) + freqMap.get(keys[idx - 1]));
            }
        }

        return maxLHSSubsequence;
    }
}
