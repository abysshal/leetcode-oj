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
public class TestPascalsTriangle {

	private static final int[] INPUT = { 5 };
	private static final int[][][] OUTPUT = { { { 1 }, { 1, 1 }, { 1, 2, 1 },
			{ 1, 3, 3, 1 }, { 1, 4, 6, 4, 1 } } };

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fish.dreaming.oj.leetcode.PascalsTriangle#generate(int)}.
	 */
	@Test
	public void testGenerate() {
		for (int i = 0; i < INPUT.length; i++) {
			List<List<Integer>> ret = new PascalsTriangle().generate(INPUT[i]);
			assertNotNull(ret);
			assertEquals(OUTPUT[i].length, ret.size());
			for (int j = 0; j < ret.size(); j++) {
				assertEquals(OUTPUT[i][j].length, ret.get(j).size());
				for (int k = 0; k < ret.get(j).size(); k++) {
					assertEquals(OUTPUT[i][j][k], ret.get(j).get(k).intValue());
				}
			}
		}
	}

}
