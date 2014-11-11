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
public class TestPascalsTriangleII {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		List<Integer> ret = new PascalsTriangleII().getRow(3);
		assertNotNull(ret);
		assertEquals(4, ret.size());
		assertEquals(new Integer(1), ret.get(0));
		assertEquals(new Integer(3), ret.get(1));
		assertEquals(new Integer(3), ret.get(2));
		assertEquals(new Integer(1), ret.get(3));
	}

}
