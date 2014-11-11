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
public class TestSubstringwithConcatenationofAllWords {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fish.dreaming.oj.leetcode.SubstringwithConcatenationofAllWords#findSubstring(java.lang.String, java.lang.String[])}
	 * .
	 */
	@Test
	public void testFindSubstring() {
		List<Integer> ret = new SubstringwithConcatenationofAllWords()
				.findSubstring("barfoothefoobarman", new String[] { "foo",
						"bar" });
		assertNotNull(ret);
		assertEquals(2, ret.size());
		assertEquals(new Integer(0), ret.get(0));
		assertEquals(new Integer(9), ret.get(1));
	}

}
