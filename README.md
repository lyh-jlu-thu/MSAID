
## What is MSAID?

MSAID is a network detection tool that can detect of interference in multiple SDN applications.

##Where can I use MASID?

MSAID is an off-line detection tool. It does not require to change or rewiter the  kernel of the controller running the applications. It only needs the tested applications, e.g., firewall or loadbalance.

The symbolic execution engine in MSAID now is based on JPF. JPF is one of the most popular symbolic execution engine about JAVA. If you are not familiar with formal methods, this basically means JPF is a Java virtual machine that executes your program not just once (like a normal VM), but theoretically in all possible ways. Learn more about JPF (http://javapathfinder.sourceforge.net/).

## What kinds of applications checks does MSID not support?

Because interference detection in MSAID depends on the code paths of SDN applications, MSAID does have inherent limitation to handle non-automated applications which don't do flow decisions embedded on source code. In the original manuscript, we do not present which kind of SDN application can MSAID be used. We add the related introduction in the revised manuscript. In addition, we assume that, ideally, users would have access to the source code of application implementations. Obviously, for commercial concern, there would be some proprietary and closed source SDN applications. To handle these applications, users need to ask for help from the developers and providers of the application. The interference detection (the second phase) depends on the output of symbolic execution (the first phase). In the first phase, symbolic execution runs locally on each application¡¯s source code. When the codebase of an application is unavailable, users can provide the detection tool to the developer and provider of the application and ask them to provide the outputs of the symbolic execution. 

## How do I get started?

The only inputs are the applications and .jpf for configurtaion.  Writign a .jpf file is easy. Like the firewallspf.spf file. It defines, ....
Don't worry. More introdution can be find in the XXX. 
In addition, the specification of example demo and the introduce about the steps is coming.

If you'd like support for additional currently-unsupported features, using the [GitHub issue tracker](https://github.com/MSAID/issues/new)
and we'll try to fix. Or you can eamil to li-yh15@mails.tsinghua.edu.cn. Or, you can -- we welcome pull requests!)
