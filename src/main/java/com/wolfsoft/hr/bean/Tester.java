package com.wolfsoft.hr.bean;

public class Tester {

	public static void main(String[] args) {
		int[] A = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		int rta=-1;
		int sumBefore = 0;
		int sumAfter = 0;
		for(int i=0;i<A.length;i++){
			sumBefore = sumBefore(A, i);
			sumAfter = sumAfter(A, i);
			if(sumBefore==sumAfter){
				return i;
			}
		}
		return rta;
	}
	
	public static int sumBefore(int[] A, int pos){
		int sum=0;
		for(int i=0;i<pos;i++){
			sum+=A[i];
		}
		return sum;
	}
	
	public static int sumAfter(int[] A, int pos){
		int sum=0;
		for(int i=pos+1;i<A.length;i++){
			sum+=A[i];
		}
		return sum;
	}
	
}
