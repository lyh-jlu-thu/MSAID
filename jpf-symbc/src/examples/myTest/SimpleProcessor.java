package myTest;

import org.onlab.packet.Ethernet;
import org.onosproject.net.Host;
import org.onosproject.net.HostId;
import org.onosproject.net.host.HostService;

public class SimpleProcessor{
    public void process(short type,byte add1,byte add2,byte add3,byte add4,byte add5,byte add6) {
		Ethernet ethPkt = new Ethernet();
		ethPkt.setEtherType(type);
		byte[] address = new byte[6];
		address[0] = add1;
		address[1] = add2;
		address[2] = add3;
		address[3] = add4;
		address[4] = add5;
		address[5] = add6;
		ethPkt.setDestinationMACAddress(address);
        if (ethPkt == null) {
            return;
        }

        // Bail if this is deemed to be a control packet.
        if (isControlPacket(ethPkt)) {
            return;
        }

        // Skip IPv6 multicast packet when IPv6 forward is disabled.
        if (!false && isIpv6Multicast(ethPkt)) {
            return;
        }
        
        HostId id = HostId.hostId(ethPkt.getDestinationMAC());

        // Do not process link-local addresses in any way.
        if (id.mac().isLinkLocal()) {
            return;
        }
        
        // Do we know who this is for? If not, flood and bail.
        HostService hostService = new HostServiceAdapter();
        Host dst = hostService.getHost(id);
//        if (dst == null) {
//            flood(context);
//            return;
//        }
//        // Are we on an edge switch that our destination is on? If so,
//        // simply forward out to the destination and bail.
//        if (pkt.receivedFrom().deviceId().equals(dst.location().deviceId())) {
//            if (!context.inPacket().receivedFrom().port().equals(dst.location().port())) {
//                installRule(context, dst.location().port());
//            }
//            return;
//        }
	}
    
    public void process1(short type) {
		Ethernet ethPkt = new Ethernet();
		ethPkt.setEtherType(type);
        if (ethPkt == null) {
            return;
        }

        // Bail if this is deemed to be a control packet.
        if (isControlPacket(ethPkt)) {
            return;
        }

        // Skip IPv6 multicast packet when IPv6 forward is disabled.
//        if (!false && isIpv6Multicast(ethPkt)) {
//            return;
//        }
	}
	public static void main(String[] args){
		byte s = 2;
		SimpleProcessor pp = new SimpleProcessor();
		pp.process(Ethernet.TYPE_IPV4,(byte)0x01,(byte)0x01,(byte)0x01,(byte)0x01,(byte)0x01,(byte)0x01);
	}
    // Indicates whether this is a control packet, e.g. LLDP, BDDP
    private boolean isControlPacket(Ethernet eth) {
        short type = eth.getEtherType();
        return type == Ethernet.TYPE_LLDP || type == Ethernet.TYPE_BSN;
    }

    // Indicated whether this is an IPv6 multicast packet.
    private boolean isIpv6Multicast(Ethernet eth) {
        return eth.getEtherType() == Ethernet.TYPE_IPV6 && eth.isMulticast();
    }
}
