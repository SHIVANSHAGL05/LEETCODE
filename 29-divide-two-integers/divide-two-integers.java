class Solution {
    public int divide(int dividend, int divisor) {

        int INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        if (dividend == INT_MIN && divisor == -1) {
            return INT_MAX;
        }
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        int quotient = 0;
        while (ldividend >= ldivisor) {
            long temp = ldivisor, multiple = 1;
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            ldividend -= temp;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
