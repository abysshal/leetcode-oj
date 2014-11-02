/**
 * 
 */
package fish.dreaming.oj.utils;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import fish.dreaming.oj.leetcode.NextPermutation;

/**
 * @author tao
 *
 */
public class TestNextPermutation {

	private static int[][] INPUT = { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 5 } };
	private static final int[][] OUTPUT = { { 1, 3, 2 }, { 1, 2, 3 },
			{ 1, 5, 1 } };

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		for (int i = 0; i < INPUT.length; i++) {
			new NextPermutation().nextPermutation(INPUT[i]);
			for (int j = 0; j < INPUT[i].length; j++) {
				assertEquals(OUTPUT[i][j], INPUT[i][j]);
			}
		}
	}

}
