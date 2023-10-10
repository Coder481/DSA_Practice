package array.leetcode

class BuildArrayFromPermutation {
    companion object {
        fun solve(nums: IntArray): IntArray {
            val res = IntArray(nums.size)
            for( i in nums.indices) res[i] = nums[nums[i]]
            return res
        }
    }
}