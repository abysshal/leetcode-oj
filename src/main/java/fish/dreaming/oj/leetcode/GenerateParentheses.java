/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tao
 *
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		final char OPEN_P = '(';
		final char CLOSE_P = ')';

		List<String> ret = new ArrayList<String>();
		int len = n * 2;
		char[] seq = new char[len];
		int openPLeft = n - 1;
		int openPUnpair = 1;
		int offset = 1;
		seq[0] = OPEN_P;
		while (offset > 0) {
			while (openPLeft > 0) {
				seq[offset] = OPEN_P;
				offset++;
				openPLeft--;
			}
			while (offset < len) {
				seq[offset] = CLOSE_P;
				offset++;
			}
			ret.add(String.copyValueOf(seq));

			openPUnpair = 0;
			while (offset > 0) {
				offset--;
				if (seq[offset] == CLOSE_P) {
					openPUnpair++;
				} else if (openPUnpair > 1) {
					openPUnpair -= 2;
					openPLeft++;
					seq[offset] = CLOSE_P;
					offset++;
					break;
				} else {
					openPLeft++;
					openPUnpair--;
				}
			}
		}

		return ret;
	}
}
