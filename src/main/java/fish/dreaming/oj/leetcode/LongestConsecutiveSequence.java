/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author tao
 *
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if (num == null || num.length <= 0) {
			return 0;
		}
		Map<Integer, Integer> mapInc = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapDesc = new HashMap<Integer, Integer>();
		Set<Integer> unique = new HashSet<Integer>();
		int max = 0;
		for (int i = 0; i < num.length; i++) {
			if (unique.contains(num[i])) {
				continue;
			} else {
				unique.add(num[i]);
			}
			Integer low = mapDesc.get(num[i] - 1);
			Integer high = mapInc.get(num[i] + 1);
			if (low != null && high == null) {
				mapDesc.remove(num[i] - 1);
				mapDesc.put(num[i], low);
				mapInc.put(low, num[i]);
				if (num[i] - low > max) {
					max = num[i] - low;
				}
			} else if (low == null && high != null) {
				mapInc.remove(num[i] + 1);
				mapInc.put(num[i], high);
				mapDesc.put(high, num[i]);
				if (high - num[i] > max) {
					max = high - num[i];
				}
			} else if (low != null && high != null) {
				mapInc.remove(num[i] + 1);
				mapDesc.remove(num[i] - 1);
				mapInc.put(low, high);
				mapDesc.put(high, low);
				if (high - low > max) {
					max = high - low;
				}
			} else {
				mapInc.put(num[i], num[i]);
				mapDesc.put(num[i], num[i]);
			}
		}

		return max + 1;
	}
}
