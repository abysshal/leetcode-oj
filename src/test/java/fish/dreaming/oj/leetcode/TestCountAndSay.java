/**
 * 
 */
package fish.dreaming.oj.leetcode;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author tao
 *
 */
public class TestCountAndSay {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fish.dreaming.oj.leetcode.CountAndSay#countAndSay(int)}.
	 */
	@Test
	public void testCountAndSay() {
		assertEquals("1", new CountAndSay().countAndSay(1));
		assertEquals("11", new CountAndSay().countAndSay(2));
		assertEquals("21", new CountAndSay().countAndSay(3));
		assertEquals("1211", new CountAndSay().countAndSay(4));
		assertEquals("111221", new CountAndSay().countAndSay(5));
		assertEquals("312211", new CountAndSay().countAndSay(6));
	}

}
