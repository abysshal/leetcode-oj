/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.Stack;

/**
 * @author tao
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		Byte[] bytes = { '(', '{', '[' };
		Stack<Byte> stack = new Stack<Byte>();
		byte[] chars = s.getBytes();
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
			case '(':
				stack.push(bytes[0]);
				break;
			case ')':
				if (stack.isEmpty() || !stack.pop().equals(bytes[0])) {
					return false;
				}
				break;
			case '{':
				stack.push(bytes[1]);
				break;
			case '}':
				if (stack.isEmpty() || !stack.pop().equals(bytes[1])) {
					return false;
				}
				break;
			case '[':
				stack.push(bytes[2]);
				break;
			case ']':
				if (stack.isEmpty() || !stack.pop().equals(bytes[2])) {
					return false;
				}
				break;
			default:
				break;
			}
		}

		return stack.isEmpty();
	}
}
