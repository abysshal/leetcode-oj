/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tao
 *
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		quickSort(num);

		int length = num.length;
		boolean[] inUse = new boolean[length];
		int[] index = new int[length];
		for (int i = 0; i < length; i++) {
			inUse[i] = false;
			index[i] = 0;
		}
		int nextTurnIndex = 1;
		inUse[0] = true;
		index[0] = 0;
		int lastTurnValue = 0;
		int lastTurnIndex = 0;
		while (true) {
			lastTurnIndex = -1;
			while (nextTurnIndex < length) {
				for (int i = lastTurnIndex + 1; i < length; i++) {
					if (!inUse[i]) {
						inUse[i] = true;
						index[nextTurnIndex] = i;
						nextTurnIndex++;
						lastTurnIndex = i;
					}
				}
			}

			Integer[] turnRet = new Integer[length];
			for (int i = 0; i < length; i++) {
				turnRet[i] = num[index[i]];
			}
			ret.add(Arrays.asList(turnRet));

			nextTurnIndex--;
			inUse[index[nextTurnIndex]] = false;

			boolean found = false;
			while (nextTurnIndex > 0 && !found) {
				nextTurnIndex--;
				lastTurnIndex = index[nextTurnIndex];
				lastTurnValue = num[lastTurnIndex];
				inUse[index[nextTurnIndex]] = false;
				for (int i = lastTurnIndex + 1; i < length; i++) {
					if (!inUse[i] && num[i] != lastTurnValue) {
						inUse[i] = true;
						index[nextTurnIndex] = i;
						nextTurnIndex++;
						found = true;
						break;
					}
				}
			}

			if (nextTurnIndex <= 0 && !found) {
				break;
			}
		}

		return ret;
	}

	private static boolean isEmpty(int[] n) {
		return n == null || n.length == 0;
	}

	public static void quickSort(int[] n) {
		if (isEmpty(n)) {
			return;
		}
		quickSort(n, 0, n.length - 1);
	}

	public static void quickSort(int[] n, int l, int h) {
		if (isEmpty(n)) {
			return;
		}
		if (l < h) {
			int pivot = partion(n, l, h);
			quickSort(n, l, pivot - 1);
			quickSort(n, pivot + 1, h);
		}
	}

	private static int partion(int[] n, int start, int end) {
		int tmp = n[start];
		while (start < end) {
			while (n[end] >= tmp && start < end) {
				end--;
			}
			if (start < end) {
				n[start++] = n[end];
			}
			while (n[start] < tmp && start < end) {
				start++;
			}
			if (start < end) {
				n[end--] = n[start];
			}
		}
		n[start] = tmp;
		return start;
	}
}
