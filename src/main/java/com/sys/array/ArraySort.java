package com.sys.array;

import com.alibaba.fastjson.JSON;

public class ArraySort {

	public static void swap(int[] arr, int a, int b) {
		arr[a] = arr[a] + arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] = arr[a] - arr[b];
	}

	// 简单选择排序
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// 每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			// 进行交换，如果min发生变化，则进行交换
			if (min != i)
				swap(arr, min, i);
		}
	}

	// 冒泡排序
	public static void bubbleSort(int[] arr) {
		// 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
	}

	// 插入排序
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 4, 1, 2, 3 };
//		selectSort(arr);
//		bubbleSort(arr);
		insertionSort(arr);
		System.out.println(JSON.toJSONString(arr));
	}

}
