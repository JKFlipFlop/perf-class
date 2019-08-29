package iaf.perf.course.day3;

import iaf.perf.course.day3.Ex2.Calculator;

public class Ex2_ans {
	/*
	public static void main(String[] args) {
		long st = System.nanoTime();
		for(long a0 = 1 ; a0<1000000 ; a0++) {
			Clac_Series_regular(a0);
		}
		long en = System.nanoTime();
		System.out.println("Time regular: " + (en-st)/1E6+"ms");
		st = System.nanoTime();
		for(long a0 = 1 ; a0<1000000 ; a0++) {
			Clac_Series_regular2(a0);
		}
		en = System.nanoTime();
		System.out.println("Time twiked: " + (en-st)/1E6+"ms");
	}
	*/
	public static final class Clac_Series_regular implements Calculator {

		@Override
		public boolean calculate(long a) {
			int counter = 0;
			while(counter<1000000) {
				if(a%2==0) a = a/2;
				else a = 3*a +1;
				
				if(a==1 || a==2 || a==4) {
					counter++;
					if(counter>1000) return true;
				}
				//System.out.println(a);
			}
			return false;
		}
	}
	
	public static final class Clac_Series_twiked implements Calculator {
		//Could be with array that keeps results for each computation -> more memory would be used
		@Override
		public boolean calculate(long a) {
			int counter = 0;
			while(counter<1000000) {
				if((a & 1) ==0) a = a>>1;
				else a = 3*a +1;
				
				if(a==1) {
					counter++;
					if(counter>1000) return true;
				}
				//System.out.println(a);
			}
			return false;
		}
	}
}
