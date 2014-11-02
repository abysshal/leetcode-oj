/**
 * 
 */
package fish.dreaming.oj.leetcode;

import java.util.Stack;

/**
 * @author tao
 *
 */
public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String str : tokens) {
			if (str.length() == 1) {
				switch (str.charAt(0)) {
				case '+':
					stack.push(stack.pop() + stack.pop());
					break;
				case '-': {
					int first = stack.pop();
					stack.push(stack.pop() - first);
					break;
				}
				case '*':
					stack.push(stack.pop() * stack.pop());
					break;
				case '/': {
					int first = stack.pop();
					stack.push(stack.pop() / first);
					break;
				}
				default:
					stack.push(Integer.valueOf(str));
				}
			} else {
				stack.push(Integer.valueOf(str));
			}
		}
		return stack.pop();
	}
}
