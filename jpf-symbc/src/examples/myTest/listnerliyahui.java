package myTest;

public class listnerliyahui {
	static int c=0;
	
	void foo(int a, int b)
	{
		if(c==40){
			
			System.out.println("if c=40 ~~~~~~~~~~");
			if(a==20)
			{
				System.out.println(" a=20~~~~~~");	
			}
		}
		if(a==10){
			c=40;
			System.out.println(" a=10~~~~~~");		
		}
		
	}
	public static void main (String[] args){
	
		listnerliyahui a= new listnerliyahui();
		a.foo(2,3);
		//System.out.println("c1====================="+ c);
		//a.foo(2,3);
		//System.out.println("c2====================="+ c);
	}

}
