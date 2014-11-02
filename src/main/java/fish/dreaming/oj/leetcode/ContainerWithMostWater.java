/**
 * 
 */
package fish.dreaming.oj.leetcode;

/**
 * @author tao
 *
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int length = height.length;
		int[] left = new int[length];
		int[] right = new int[length];
		left[0] = 0;
		right[0] = length - 1;
		int leftLength = 1;
		int rightLength = 1;
		int leftIndex = left[0];
		int rightIndex = right[0];
		int maxArea = height[left[0]] > height[right[0]] ? height[right[0]]
				* (length - 1) : height[left[0]] * (length - 1);

		boolean run = true;
		while (run) {
			if (height[leftIndex] > height[rightIndex]) {
				int i = rightIndex - 1;
				while (i > leftIndex) {
					if (height[i] > height[rightIndex]) {
						right[rightLength] = i;
						rightLength++;
						rightIndex = i;
						int max = calcMaxArea(height, left, leftLength, i);
						if (max > maxArea) {
							maxArea = max;
						}
						i--;
						break;
					}
					i--;
				}
				if (i <= leftIndex) {
					run = false;
				}
			} else {
				int i = leftIndex + 1;
				while (i < rightIndex) {
					if (height[i] > height[leftIndex]) {
						left[leftLength] = i;
						leftLength++;
						leftIndex = i;
						int max = calcMaxArea(height, right, rightLength, i);
						if (max > maxArea) {
							maxArea = max;
						}
						i++;
						break;
					}
					i++;
				}
				if (i >= rightIndex) {
					run = false;
				}
			}
		}

		return maxArea;
	}

	private static int calcMaxArea(int[] num, int[] base, int length, int value) {
		int max = 0;
		for (int i = 0; i < length; i++) {
			int tmp = Math.min(num[base[i]], num[value]);
			tmp *= Math.abs(value - base[i]);
			if (tmp > max) {
				max = tmp;
			}
		}
		return max;
	}
}
