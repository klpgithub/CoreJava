package com.sys.array;

public class ArraySearch {

	// 二分查找
	public static int binarySearch(int[] arr, int key) {
		int low = 0, high = arr.length - 1, mid;
		while (low <= high) {
//			mid = (low + high) / 2; //当arr.length为int最大值时会越界
			mid = (low + high) >>> 1;
			if (key == arr[mid]) {
				return mid;
			} else if (key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// 二分查找-查找第一个与key相等的元素
	public static int findFirstEqual(int[] arr, int key) {
		int low = 0, high = arr.length - 1, mid;
		while (low <= high) {
			mid = (low + high) >>> 1;
			if (key >= arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (low < arr.length && arr[low] == key) {
			return low;
		}
		return -1;
	}

	// 二分查找-查找最后一个与key相等的元素
	public static int findLastEqual(int[] arr, int key) {
		int low = 0, high = arr.length - 1, mid;
		while (low <= high) {
			mid = (low + high) >>> 1;
			if (key >= arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (high < arr.length && arr[high] == key) {
			return high;
		}
		return -1;
	}

	public static void main(String[] args) {

		int pow = (int) Math.pow(2, 31);
		System.out.println(pow);

		int s = ((pow - 1) / 2 + pow) / 2;
		int t = ((pow - 1) / 2 + pow) >>> 1;
		System.out.println(s);
		System.out.println(t);

		int search = findLastEqual(new int[] { 1, 2, 5, 5, 5, 7, 11, 15 }, 5);
		System.out.println(search);

	}

}
