class Solution {

	// depth-first-search, lesographical, recursive, tries
    private void extendWithLexOrderNumbers(int number, int maxNumber, List<Integer> lexicalOrderList) {
        for(int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            if(number == 0 && nextDigit == 0) continue;
            int nextNumber = number * 10 + nextDigit;
            if(nextNumber <= maxNumber) {
                lexicalOrderList.add(nextNumber);
                extendWithLexOrderNumbers(nextNumber, maxNumber, lexicalOrderList);
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicalOrderList = new ArrayList(n);        
        extendWithLexOrderNumbers(0, n, lexicalOrderList);
        return lexicalOrderList;
    }

    private void extendWithLexOrderNumbersRec(int n) {
        List<Integer> lexicalOrderList = new ArrayList(n);
        
    }
}
