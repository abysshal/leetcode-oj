/**
 * 
 */
package fish.dreaming.oj.leetcode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author tao
 *
 */
public class TestPermutationsII {

	private static final int[][] INPUT = { { 1, 2, 1 }, { 4, 3, 2, 1 } };
	private static final int[] OUTPUT = { 3, 24 };

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fish.dreaming.oj.leetcode.PermutationsII#permuteUnique(int[])}.
	 */
	@Test
	public void testPermuteUnique() {
		for (int i = 0; i < OUTPUT.length; i++) {
			List<List<Integer>> ret = new PermutationsII()
					.permuteUnique(INPUT[i]);
			assertNotNull(ret);
			assertEquals(ret.size(), OUTPUT[i]);
		}

	}

}
