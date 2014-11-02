/**
 * 
 */
package fish.dreaming.oj.leetcode;

/**
 * @author tao
 *
 */
public class CountAndSay {

	public String countAndSay(int n) {
		String ret = "1";
		int count = 0;
		byte last = 0x00;
		while (--n > 0) {
			byte[] bytes = ret.getBytes();
			last = bytes[0];
			count = 1;
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < bytes.length; i++) {
				if (bytes[i] == last) {
					count++;
				} else {
					sb.append(String.valueOf(count));
					sb.append((char) last);
					last = bytes[i];
					count = 1;
				}
			}
			sb.append(String.valueOf(count));
			sb.append((char) last);
			ret = sb.toString();
		}
		return ret;
	}
}
