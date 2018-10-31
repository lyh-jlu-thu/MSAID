import gov.nasa.jpf.JPF;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.search.SearchListener;
import gov.nasa.jpf.vm.VMListener;
public class Liyahui {
	static int field;
	//static final String SYM_METHOD = "+symbolic.method=gov.nasa.jpf.symbc.TestMethodInvocation.testMethodInvocation(sym#sym)";
	  public static void main (String[] args) {
		  Config config;
	      JPF jpf;
	      //String[] jpfArgs = { "/home/sdnracer/jpf/jpf-core/src/examples/HelloWorld.jpf" };
          //%String[] jpfArgs = { "/home/sdnracer/jpf/jpf-core/src/examples/NumericValueCheck.jpf" };
          //config = JPF.createConfig( jpfArgs );
	      String[] conf =new String[6];//target=HelloWorld
	      //conf[0] = "+target = HelloWorld"; 
	      conf[0] = "+target = NumericValueCheck";
	      conf[1] = "+listener = .listener.NumericValueChecker";
	      conf[2] = "+range.vars = 1";
	      conf[3] = "+range.1.var = NumericValueCheck.main(java.lang.String[]):someVariable";
	      conf[4] = "+range.1.min = 0";
	      conf[5] = "+range.1.max = 42";
	      //conf[0] = "target = gov.nasa.jpf.jpf-core.src.examples.HelloWorld";  // This changes dynamically.
	      //conf[1] = "jpf-core.classpath=C:\\Eclipse-Workspace\\jpf-core\\jpf.properties";
	       // Is this the way in conf[2] i have to specify the classpath for MyMainClassForVerification?
	      //conf[2] = "classpath=C:\\Eclipse-Workspace\\eVerification-jpf\\bin";   // changes dynamically.
	      config = JPF.createConfig( conf);
	      jpf = new JPF(config);
	      jpf.run();

// //config.setTarget("InfinitLoopZZ");
// //config.setProperty("cg.enumerate_random", "true");
// //jpf.addListener( listener);

	  }

}
