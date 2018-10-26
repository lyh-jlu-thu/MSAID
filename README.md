
## What is MSAID?

MSAID is a network detection tool that can detect of interference in multiple SDN applications.

##Where can I use MASID?

MSAID is an off-line detection tool. It does not require to change or rewrite the kernel of the controller running the applications. It only needs the tested applications, e.g., firewall or loadbalancer.




## How can I get the applications?
MSAID uses SPF as the symbolic execution engine. Hence, it supports a representative set of SDN applications and controllers written in Java, e.g., Floodlight, OpenDaylight, and ONOS. In the MSAID, the interference detection phase is separated from symbolic execution. The detection phase does not require access to the source code and the symbolic execution tools. For applications running on other controllers, e.g., RYU, you can replace SPF with other symbolic execution engines that support the Python language. With the advances in execution engines, any application developed in popular languages (e.g., Python and C) can be verified.

For exmaple, you can download applications from the website (http://www.projectfloodlight.org/floodlight/).



## What kinds of applications checks does MSID not support?

Because interference detection in MSAID depends on the code paths of SDN applications, MSAID does have inherent limitation to handle non-automated applications which don't do flow decisions embedded on source code. In addition, we assume that, ideally, you would have access to the source code of application implementations. Obviously, for commercial concern, there would be some proprietary and closed source SDN applications. To handle these applications, you need to ask for help from the developers and providers of the application. The interference detection depends on the output of symbolic execution. In the first phase, symbolic execution runs locally on each application¡¯s source code. When the codebase of an application is unavailable, you can provide the detection tool to the developer and provider of the application and ask them to provide the outputs of the symbolic execution. 


## How do I get started?

The only inputs are the applications and .jpf for configuration. Writing a .jpf file is easy. It enables you to enter detailed policies, including specifying multiple methods to be executed symbolically, limiting the search depth, specifying the search strategy, selecting which constraint solver to choose, specifying min/max values for symbolic variables, setting the default values for variables you don't care about and
so on. For example, to minimize the number or scope of symbolic values, you only need to enter parameters in the corresponding configuration snippets.

Don't worry. The specification of example demo and the introduction about the steps is coming. Http, XXX


## Main parts of MSAID. 
In the project, the symbolic execution codes are jpf-core and jpf-symbc. Note that these codes are different from the SPF on the website (http://javapathfinder.sourceforge.net/). The analyzed SDN applications (from some controller platforms e.g., Floodlight) running on SPF may invoke some abstracts of the classes in jdk in MJI. However, MJI doesn't consist of the abstraction of some methods in classes of jdk (e.g., class java.nio.ByteBuffer, java.lang.String.format and so on). We rewrite the corresponding codes to provide these methods based on the simplified implementation in jdk. These developments aim to make the symbolic execution engine use better. These developments are one-time offline task, and you can use the tool directly. For example, we added five methods in class java.nio.ByteBuffer. Some applications (e.g., firewall) in floodlight invoke these methods, which are absent in SPF, hence we added these corresponding methods. (https://github.com/lyh-jlu-thu/MSAID/blob/master/project/jpf-core/src/classes/java/nio/ByteBuffer.java). 
The identify codes are in indentitor. This detection engine then crosschecks the output messages, and then it outputs an interference report if interferences exist among these multiple applications.
The detailed of the introduction about the codes is coming. Http, XXX


If you'd like support for additional currently-unsupported features, using the [GitHub issue tracker](https://github.com/MSAID/issues/new)
and we'll try to fix. Or you can email to li-yh15@mails.tsinghua.edu.cn. Or, you can -- we welcome pull requests!)
