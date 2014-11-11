/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author tao
 *
 */
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0) {
			return Arrays.asList(1);
		}
		int[] odd = new int[rowIndex / 2 + 1];
		int[] even = new int[rowIndex / 2 + 1];
		odd[0] = 1;
		even[0] = 1;

		for (int i = 0; i < rowIndex / 2; i++) {
			for (int j = 1; j < i + 1; j++) {
				even[j] = odd[j - 1] + odd[j];
			}
			even[i + 1] = even[i];
			for (int j = 1; j < i + 2; j++) {
				odd[j] = even[j - 1] + even[j];
			}
		}

		Integer[] ret = new Integer[rowIndex + 1];
		if (rowIndex % 2 == 0) {
			for (int i = 0; i < rowIndex / 2; i++) {
				ret[i] = odd[i];
				ret[rowIndex - i] = odd[i];
			}
			ret[rowIndex / 2] = odd[rowIndex / 2];
		} else {
			for (int j = 1; j < rowIndex / 2 + 1; j++) {
				even[j] = odd[j - 1] + odd[j];
			}

			for (int i = 0; i < rowIndex / 2 + 1; i++) {
				ret[i] = even[i];
				ret[rowIndex - i] = even[i];
			}
		}
		return Arrays.asList(ret);
	}
}
