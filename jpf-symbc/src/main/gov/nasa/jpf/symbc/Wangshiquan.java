package gov.nasa.jpf.symbc;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.Config;
//import gov.nasa.jpf.search.SearchListener;
//import gov.nasa.jpf.vm.VMListener;
public class Wangshiquan {
	static int field;
	//static final String SYM_METHOD = "+symbolic.method=gov.nasa.jpf.symbc.TestMethodInvocation.testMethodInvocation(sym#sym)";
	  public static void main (String[] args) {
		  Config config;
	      JPF jpf;
	      //String[] jpfArgs = { "/home/sdnracer/jpf/jpf-symbc/src/examples/myTest/NodeSimple.jpf" };
          String[] jpfArgs = { "/home/sdnracer/jpf/jpf-symbc/src/examples/NumberExample.jpf" };
          config = JPF.createConfig( jpfArgs );
	      //String[] conf =new String[6];//target=HelloWorld
	      //conf[0] = "+target = HelloWorld"; 
	      //conf[0] = "target = gov.nasa.jpf.jpf-core.src.examples.HelloWorld";  // This changes dynamically.
	      //conf[1] = "jpf-core.classpath=C:\\Eclipse-Workspace\\jpf-core\\jpf.properties";
	       // Is this the way in conf[2] i have to specify the classpath for MyMainClassForVerification?
	      //conf[2] = "classpath=C:\\Eclipse-Workspace\\eVerification-jpf\\bin";   // changes dynamically.
	      //config = JPF.createConfig( conf);
	      jpf = new JPF(config);
	      jpf.run();

// //config.setTarget("InfinitLoopZZ");
// //config.setProperty("cg.enumerate_random", "true");
// //jpf.addListener( listener);

	  }

}
