package com.hiideals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Stack {

	int [] arr;
	int index;
	public int[] createArray(int x) {
		arr = new int[x];
		System.out.println("Array is created, it's length is:" +arr.length);
		return arr;
	}

	public int push (int num) {
		index = arr.length;

		arr[0] = 5;
		arr[1] = 5;
		arr[2] = 5;
		Stack.size(arr,num);
		//System.out.println("The pushed item is:" +num);

		/*for(int i=0;i<arr.length;i++){
			System.out.println("The Array items are:" +arr[i]);
		}*/

		return num;
	}


	public int pop (int popIndex) {
		System.out.println(arr.length-popIndex);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		return arr[arr.length-popIndex];
	}


	public static void main(String args[]){	

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the Array");

		int n = scan.nextInt();

		Stack r = new Stack();
		r.createArray(n);
		for (int i = 0; i <n; i++) {
			r.push(i);
		}


		System.out.println(r.arr[3]);
		for (int i = 1; i < n-1; i++) {
			//r.pop(n-i);
		}

	}

	public static int size(int [] arr,int num)
	{
		int count = Collections.frequency(Arrays.asList(arr),0);
		System.out.println(count);
		return count;
	}
}
