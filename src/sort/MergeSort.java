package sort;

public class MergeSort {
	// compare from end to start
		public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
			if (A.length == 0 || B.length == 0) {
				return;
			}
			int pointer = m + n - 1;
			int pa = m - 1;
			int pb = n - 1;
			while (pa >= 0 && pb >= 0) {
				if (A[pa] >= B[pb]) {
					A[pointer] = A[pa];
					pointer--;
					pa--;
				} else {
					A[pointer] = B[pb];
					pointer--;
					pb--;
				}
			}
			// while (pa >= 0) {
			// A[pa] = A[pa];
			// pa--;
			// }

			// only need to check this
			while (pb >= 0) {
				A[pb] = B[pb];
				pb--;
			}
		}

		// TLE
		public static void mergeSortedArr(int[] A, int m, int[] B, int n) {
			if (A.length == 0 || B.length == 0) {
				return;
			}
			int pa = 0;
			int pb = 0;
			int[] flag = new int[A.length - m];
			while (pa < A.length && pb < n) {
				if (A[pa] <= B[pb] && pa < m) {
					pa++;
				} else if (A[pa] > B[pb] && pa < m) {
					swap(A, pa, B, pb);
					pa++;
				} else if (pa >= m && flag[pa - m] == 0) {
					swap(A, pa, B, pb);
					flag[pa - m] = 1;
					pb++;
				} else if (pa >= m && flag[pa - m] == 1 && A[pa] > B[pb]) {
					swap(A, pa, B, pb);
					pa++;
				}
			}
		}

		private static void swap(int[] A, int pa, int[] B, int pb) {
			int temp = A[pa];
			A[pa] = B[pb];
			B[pb] = temp;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int[] A = { 9, 10, 11, 12, 13, 0, 0, 0, 0 };
			int[] B = { 14, 15, 16, 17 };
			mergeSortedArray(A, 5, B, 4);
			for (int i = 0; i < A.length; i++) {
				System.out.print(A[i] + " ");
			}
		}
}
