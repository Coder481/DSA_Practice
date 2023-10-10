package array.leetcode

class NumberOfGoodPairs {

    companion object {
        fun solve(nums: IntArray): Int {

            val map = hashMapOf<Int, Int>()
            nums.forEach { num ->
                map[num] = map.getOrDefault(num, 0) + 1
            }
            var res = 0
            map.values.forEach {  n ->
                val sum = n*(n-1)/2
                res += sum
            }

            return res
        }

    }

}