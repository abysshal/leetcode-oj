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
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return ret;
		}
		List<Integer> last = new ArrayList<Integer>();
		last.add(1);
		ret.add(last);
		numRows--;
		while (numRows-- > 0) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			for (int i = 0; i < last.size() - 1; i++) {
				row.add(last.get(i) + last.get(i + 1));
			}
			row.add(1);
			last = row;
			ret.add(last);
		}

		return ret;
	}
}
