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
public class TestContainerWithMostWater {
	private static final int[][] INPUT = { { 1, 2, 3, 4, 5 },
			{ 2, 10, 8, 4, 6, 5 } };
	private static final int[] OUTPUT = { 6, 20 };

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		for (int i = 0; i < OUTPUT.length; i++) {
			assertEquals(OUTPUT[i],
					new ContainerWithMostWater().maxArea(INPUT[i]));
		}
	}

}
