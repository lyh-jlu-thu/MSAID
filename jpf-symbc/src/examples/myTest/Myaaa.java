package myTest;

public class Myaaa {
	public void printtest(int a ){
		if(a == 1){
			System.out.println("111111111===1111");
		}
		MyObject object = new MyObject();
		object.setA(a);
		if(object.getA() == 2){
			System.out.println("222222222====222");
		}
	}
	public static void main (String[] args){
		Myaaa a= new Myaaa();
		a.printtest(2);
	}
}
