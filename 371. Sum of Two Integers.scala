//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.


object Solution {
    def getSum(a: Int, b: Int): Int = {
        if (b == 0) a
        else getSum(a ^ b, (a & b) << 1)
    }
}
