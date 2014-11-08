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
public class TestSubsets {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for {@link fish.dreaming.oj.leetcode.Subsets#subsets(int[])}.
	 */
	@Test
	public void testSubsets() {
		List<List<Integer>> ret = new Subsets().subsets(new int[] { 1, 2, 3 });
		assertNotNull(ret);
		assertEquals(8, ret.size());
		for (int i = 0; i < ret.size(); ++i) {
			for (int j = 0; j < ret.get(i).size(); ++j) {
				System.out.print(ret.get(i).get(j) + ",\t");
			}
			System.out.println("");
		}
	}
}
