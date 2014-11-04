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
public class TestSurroundedRegions {

	private static char[][] INPUT = { { 'X', 'X', 'X', 'X' },
			{ 'X', 'O', 'O', 'X', }, { 'X', 'X', 'O', 'X' },
			{ 'X', 'O', 'X', 'X' } };
	private static final char[][] OUTPUT = { { 'X', 'X', 'X', 'X' },
			{ 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
			{ 'X', 'O', 'X', 'X' } };

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSolve() {
		new SurroundedRegions().solve(INPUT);
		for (int i = 0; i < INPUT.length; i++) {
			for (int j = 0; j < INPUT[i].length; j++) {
				System.out.println(String.format("x:%d,\ty:%d", i, j));
				assertEquals(INPUT[i][j], OUTPUT[i][j]);
			}
		}
	}

}
