/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author tao
 *
 */
public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		if (S == null || L == null || L.length <= 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> ret = new ArrayList<Integer>();
		int len = L[0].length();
		int totalLen = 0;
		HashMap<String, Integer> ls = new HashMap<String, Integer>();
		for (String l : L) {
			Integer value = ls.get(l);
			if (value != null) {
				ls.put(l, value + 1);
			} else {
				ls.put(l, 1);
			}
			totalLen += l.length();
		}

		for (int i = 0; i <= S.length() - totalLen; i++) {
			Iterator<String> iterator = ls.keySet().iterator();
			HashMap<String, Integer> currMap = new HashMap<String, Integer>();
			while (iterator.hasNext()) {
				String next = iterator.next();
				Integer value = ls.get(next);
				currMap.put(next, Integer.valueOf(value));
			}
			boolean ok = true;
			for (int j = 0; j < L.length; j++) {
				String tmp = S.substring(i + j * len, i + (j + 1) * len);
				Integer count = currMap.get(tmp);
				if (count != null && count > 0) {
					currMap.put(tmp, count - 1);
				} else {
					ok = false;
					break;
				}
			}
			if (ok) {
				ret.add(new Integer(i));
			}
		}

		return ret;
	}
}
