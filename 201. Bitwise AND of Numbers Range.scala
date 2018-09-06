
//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

object Solution {
    def rangeBitwiseAnd(m: Int, n: Int): Int = {
        if (m >= n) n
        else rangeBitwiseAnd(m, n & (n - 1))
    }
}
