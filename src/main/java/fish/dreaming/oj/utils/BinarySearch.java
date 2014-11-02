/**
 * 
 */
package fish.dreaming.oj.utils;

/**
 * @author tao
 *
 */
public class BinarySearch {
	public static int binarySearch(int srcArray[], int key) {
		int mid = srcArray.length / 2;
		if (key == srcArray[mid]) {
			return mid;
		}

		int start = 0;
		int end = srcArray.length - 1;
		while (start <= end) {
			mid = (end - start) / 2 + start;
			if (key < srcArray[mid]) {
				end = mid - 1;
			} else if (key > srcArray[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int binarySearchBiggerReverse(int srcArray[], int key,
			int startOffset, int endOffset) {
		int mid;
		while (startOffset < endOffset) {
			mid = endOffset - (endOffset - startOffset) / 2;
			if (key < srcArray[mid]) {
				startOffset = mid;
			} else if (key >= srcArray[mid]) {
				endOffset = mid - 1;
			}
		}
		if (startOffset == endOffset && srcArray[startOffset] > key) {
			return startOffset;
		} else {
			return -1;
		}
	}
}
