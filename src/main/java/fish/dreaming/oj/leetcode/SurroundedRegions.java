/**
 * 
 */
package fish.dreaming.oj.leetcode;

/**
 * @author tao
 *
 */
public class SurroundedRegions {
	public void solve(char[][] board) {

		if (board == null || board.length <= 0 || board[0].length <= 0) {
			return;
		}

		int xLen = board.length;
		int yLen = board[0].length;
		boolean[] checked = new boolean[xLen * yLen];

		int[] xCache = new int[xLen * yLen];
		int[] yCache = new int[xLen * yLen];
		int cacheSize = 0;
		int cacheOffset = -1;

		int[] xMark = new int[xLen * yLen * 3];
		int[] yMark = new int[xLen * yLen * 3];
		int markSize = 0;
		boolean markGood = true;

		for (int i = 0; i < checked.length; i++) {
			checked[i] = false;
		}

		for (int x = 0; x < xLen; x++) {
			for (int y = 0; y < yLen; y++) {
				if (!checked[x * yLen + y]) {
					xCache[0] = x;
					yCache[0] = y;
					cacheSize = 1;
					cacheOffset = 0;
					markSize = 0;
					markGood = true;
					// BFS
					while (cacheOffset < cacheSize) {
						int xTmp = xCache[cacheOffset];
						int yTmp = yCache[cacheOffset];
						cacheOffset++;
						if (checked[xTmp * yLen + yTmp]) {
							continue;
						}
						checked[xTmp * yLen + yTmp] = true;
						if (board[xTmp][yTmp] == 'O') {
							if (xTmp == 0 || yTmp == 0 || xTmp == xLen - 1
									|| yTmp == yLen - 1) {
								markGood = false;
							} else {
								xMark[markSize] = xTmp;
								yMark[markSize] = yTmp;
								markSize++;
							}
							if (xTmp > 0) {
								if (!checked[(xTmp - 1) * yLen + yTmp]) {
									xCache[cacheSize] = xTmp - 1;
									yCache[cacheSize] = yTmp;
									cacheSize++;
								}
							}
							if (xTmp < xLen - 1) {
								if (!checked[(xTmp + 1) * yLen + yTmp]) {
									xCache[cacheSize] = xTmp + 1;
									yCache[cacheSize] = yTmp;
									cacheSize++;
								}
							}
							if (yTmp > 0) {
								if (!checked[xTmp * yLen + yTmp - 1]) {
									xCache[cacheSize] = xTmp;
									yCache[cacheSize] = yTmp - 1;
									cacheSize++;
								}
							}
							if (yTmp < yLen - 1) {
								if (!checked[xTmp * yLen + yTmp + 1]) {
									xCache[cacheSize] = xTmp;
									yCache[cacheSize] = yTmp + 1;
									cacheSize++;
								}
							}
						}
					}

					if (markGood) {
						for (int i = 0; i < markSize; i++) {
							board[xMark[i]][yMark[i]] = 'X';
						}
					}
				}
			}
		}
	}
}
