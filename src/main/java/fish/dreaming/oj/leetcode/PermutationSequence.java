/**
 * 
 */
package fish.dreaming.oj.leetcode;

/**
 * @author tao
 *
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int[] FACTORIAL = { 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
		int len = n;
		boolean[] used = new boolean[len];
		for (int i = 0; i < len; i++) {
			used[i] = false;
		}
		StringBuilder sb = new StringBuilder();
		while (n-- > 1) {
			int tims = k / FACTORIAL[n - 1];
			int left = k % FACTORIAL[n - 1];
			if (left > 0) {
				tims += 1;
			}
			k -= (tims - 1) * FACTORIAL[n - 1];

			for (int i = 0; i < len; i++) {
				if (!used[i]) {
					tims--;
					if (tims <= 0) {
						used[i] = true;
						sb.append(i + 1);
						break;
					}
				}
			}
		}

		for (int i = 0; i < len; i++) {
			if (!used[i]) {
				sb.append(i + 1);
			}
		}

		return sb.toString();
	}
}
