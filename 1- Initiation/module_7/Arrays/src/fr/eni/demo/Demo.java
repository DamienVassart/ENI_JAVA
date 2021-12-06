package fr.eni.demo;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		// declaring
		int[] arr;
		
		// initializing
		arr = new int[10];
		
		// printing
		System.out.println(Arrays.toString(arr)); // [0,0,0,0,0,0,0,0,0,0]
		
		// filling every position with a fixed value
		Arrays.fill(arr, 5);
		System.out.println(Arrays.toString(arr)); // [5,5,5,5,5,5,5,5,5,5]
		
		// filling with random values
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		System.out.println(Arrays.toString(arr)); // array of 10 random values
		
		// sorting the previous array:
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr)); // previous array sorted
		
		// searching
		int[] otherArr = {4, 8, 1};
		Arrays.sort(otherArr);
		System.out.println(Arrays.toString(otherArr)); // [1,4,8]
		System.out.println(Arrays.binarySearch(otherArr, 8)); // 2
		
		int a = arr[5]; // arr is the previous array filled with random numbers
		System.out.println(a); // prints the 6th value of arr stored in variable a
		System.out.println(Arrays.binarySearch(arr, a)); // index of a in arr (5)
		
		// copying an array and increasing the length
		int[] newArr = Arrays.copyOf(arr, arr.length + 1);
		System.out.println(Arrays.toString(arr)); // sorted array of 10 values
		System.out.println(Arrays.toString(newArr)); // same array plus a 0 at the end
		
		// partial copy of an array
		newArr = Arrays.copyOfRange(arr, 2, 5);
		System.out.println(Arrays.toString(newArr)); // arr[2] to arr[4] (or arr[5] not included)
	}

}
