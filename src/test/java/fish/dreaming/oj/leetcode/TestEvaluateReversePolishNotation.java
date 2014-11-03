/**
 * 
 */
package fish.dreaming.oj.leetcode;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fish.dreaming.oj.leetcode.EvaluateReversePolishNotation;

/**
 * @author tao
 *
 */
public class TestEvaluateReversePolishNotation {

	private static final String[][] INPUT = { { "2", "1", "+", "3", "*" },
			{ "4", "13", "5", "/", "+" } };
	private static int[] OUTPUT = { 9, 6 };

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fish.dreaming.oj.leetcode.EvaluateReversePolishNotation#evalRPN(java.lang.String[])}
	 * .
	 */
	@Test
	public void testEvalRPN() {
		for (int i = 0; i < OUTPUT.length; i++) {
			assertEquals(OUTPUT[i],
					new EvaluateReversePolishNotation().evalRPN(INPUT[i]));
		}
	}

}
