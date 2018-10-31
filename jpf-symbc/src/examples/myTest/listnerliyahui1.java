package myTest;

import gov.nasa.jpf.symbc.Debug;

public class listnerliyahui1 {
	static int c=0;
	
	void foo(int a, int b)
	{
		if(a==1062731519){
			System.out.println("redirec src 1 to 2  ");
			c=a+40;	
			System.out.println("c=  " +Debug.getSymbolicIntegerValue(c));
		}
		if(b==1062731517){
			System.out.println("redirec dst 3 to 4  ");
		}
		if(a==1062731519 && b==1062731517){
			System.out.println("install 2 to 3  ");
		}
		
	}
	public static void main (String[] args){
	
		listnerliyahui1 a= new listnerliyahui1();
		a.foo(2,3);
	}

}
