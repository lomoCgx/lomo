package com.lomo.utilsTest;

public class ArrayTest {

	public static void main(String[] args) {
		int[] fun ={0,1,2,3,4,5,6};
		int index = 2;
		int size = 7;
		int numMoved = size - index - 1;
		System.arraycopy(fun, 3, fun, 2, numMoved);
		fun[--size] = 0;
		System.out.println(size);
		for (int i : fun) {
			System.out.print(i+",");
		}

	}
	
}
