package sort;

import java.util.Arrays;

public class MergeSort {
	public static Integer[] sort(Integer[] array) {
		if (array.length <= 1) {
			return array;
		}
		int middle = array.length / 2;
		Integer[] left = Arrays.copyOfRange(array, 0, middle);
		Integer[] right = Arrays.copyOfRange(array, middle, array.length);
		left = sort(left);
		right = sort(right);
		return merge(left, right);
	}

	public static Integer[] merge(Integer[] left, Integer[] right) {
		Integer[] result = new Integer[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		while (leftIndex < left.length || rightIndex < right.length) {
			if (leftIndex < left.length && rightIndex < right.length) {
				if (left[leftIndex] <= right[rightIndex]) {
					result[resultIndex++] = left[leftIndex++];
				} else {
					result[resultIndex++] = right[rightIndex++];
				}
			} else if (leftIndex < left.length) {
				result[resultIndex++] = left[leftIndex++];
			} else if (rightIndex < right.length) {
				result[resultIndex++] = right[rightIndex++];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 3, 4, 2, 5, -1 };
		Integer[] res = sort(arr);
		System.out.println(Arrays.toString(res));
	}
}