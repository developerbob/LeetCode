/**
* There are two sorted arrays nums1 and nums2 of size m and n respectively.
* Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*
* Example 1:
* nums1 = [1, 3]
* nums2 = [2]
* The median is 2.0
*
 * Example 2:
* nums1 = [1, 2]
* nums2 = [3, 4]
* The median is (2 + 3)/2 = 2.5
*
 * Solution: http://www.drdobbs.com/parallel/finding-the-median-of-two-sorted-arrays/240169222?pgno=2
*
 * @author Bob Yang
* @since 2017-07-10
*
*/
 
public class Algo_4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int ret = findMedianSortedArraysLeft(nums1, nums2);

		if (ret < 0) {
			ret = findMedianSortedArraysLeft(nums2, nums1);
			return nums2[ret];
		} else {
			return nums1[ret];
		}
	}

	public int findMedianSortedArraysLeft(int[] nums1, int[] nums2) {
		int p = 0, q = nums1.length;
		int half = (nums1.length + nums2.length) / 2;
		while (p <= q) {
			int pos = (p + q) / 2;
			int test = isMedianForBoth(nums2, half - pos - 1, nums1[pos]);
			if (test == 0) {
				return pos;
			} else if (test > 0) {
				q = pos - 1; // pos is tested, so (pos - 1)
			} else {
				p = pos + 1; // pos is tested, so (pos + 1)
			}
		}
		return -1;
	}

	/**
	 * @return 0: found median 
	 *         1: more than half is greater than value 
	 *        -1: more than half is less than value
	 */
	public int isMedianForBoth(int nums[], int reqNum, int value) {
		int ret;
		if (nums[reqNum - 1] <= value && nums[reqNum] >= value) {
			ret = 0;
		} else if (nums[reqNum] < value) {
			return 1;
		} else {
			return -1;
		}
		return ret;
	}

	public static void main(String[] args) {
		// Median: 9.5
		int[] nums1 = { 1, 3, 5, 7, 9, 10, 11 };
		int[] nums2 = { 2, 6, 11, 12, 13, 14, 15 };
		Algo_4 a = new Algo_4();
		double ret = a.findMedianSortedArrays(nums1, nums2);
		System.out.println("Median: " + ret);

		// Median: 8.0
		int[] nums3 = { 1, 3, 5, 7, 14, 16, 17 };
		int[] nums4 = { 2, 6, 7, 9, 10, 12, 13 };
		ret = a.findMedianSortedArrays(nums3, nums4);
		System.out.println("Median: " + ret);
	}
 
}