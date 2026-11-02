class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {

            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));

        } 
        while (slow != fast);

        return slow == 1;
    }
    private int getNextNumber(int n) {

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
