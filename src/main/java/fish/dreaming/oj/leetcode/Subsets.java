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
public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		quickSort(S);

		int length = S.length;
		int[] index = new int[length];
		for (int i = 0; i < length; i++) {
			index[i] = 0;
		}

		int currTurnLength = 0;
		int eleHave = 0;
		int lastTurnIndex = 0;
		while (currTurnLength++ < length) {
			eleHave = 0;
			lastTurnIndex = -1;
			while (true) {
				while (eleHave < currTurnLength) {
					lastTurnIndex++;
					index[eleHave] = lastTurnIndex;
					eleHave++;
				}

				Integer[] turnRet = new Integer[currTurnLength];
				for (int i = 0; i < currTurnLength; i++) {
					turnRet[i] = S[index[i]];
				}
				ret.add(Arrays.asList(turnRet));

				boolean found = false;
				while (eleHave-- > 0 && !found) {
					if (length - index[eleHave] > (currTurnLength - eleHave)) {
						lastTurnIndex = index[eleHave];
						found = true;
						break;
					}
				}

				if (!found) {
					break;
				}
			}
		}

		ret.add(new ArrayList<Integer>());
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
