
import gov.nasa.jpf.symbc.Debug;

public class MyDriverForFields {
	private static void makeFieldsSymbolic(int x, int y) {
        MyClassWithFields mc = new MyClassWithFields();

        mc.field1 = x;
        mc.field2 = y;
        mc.myMethod1();
        if(mc.field1 == 2){
        	System.out.println("2");
        }
        
        Debug.printPC("MyDriverForFields.myMethod Path Condition: ");
    }

    // The test driver
    public static void main(String[] args) {
        makeFieldsSymbolic(1,2);
    }
}
