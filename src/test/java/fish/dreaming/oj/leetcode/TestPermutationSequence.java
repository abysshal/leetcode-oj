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
public class TestPermutationSequence {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fish.dreaming.oj.leetcode.PermutationSequence#getPermutation(int, int)}
	 * .
	 */
	@Test
	public void testGetPermutation() {
		assertEquals("1", new PermutationSequence().getPermutation(1, 1));
		assertEquals("132", new PermutationSequence().getPermutation(3, 2));
	}

}
