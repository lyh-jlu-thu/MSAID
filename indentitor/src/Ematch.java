import java.util.ArrayList;
import java.util.List;

public class Ematch {
	public static List<String> construct(String str) {
		List<String> listapp = new ArrayList<String>();
		String in_port = null;
		String eth_dst = null;
		String eth_src = null;
		String eth_type = null;
		String ip_proto = null;
		String ipv4_src = null;
		String ipv4_dst = null;
		String tcp_src = null;
		String tcp_dst = null;
		String mask_src = null;
		String mask_dst = null;
		String[] strs = str.split("in_port=");
		String[] strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			in_port = strs2[0];
		}
		strs = str.split("eth_dst=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			eth_dst = strs2[0];
		}
		strs = str.split("eth_src=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			eth_src = strs2[0];
		}
		strs = str.split("eth_type=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			eth_type = strs2[0];
		}
		strs = str.split("ip_proto=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			ip_proto = strs2[0];
		}
		strs = str.split("ipv4_src=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			ipv4_src = strs2[0];
		}
		strs = str.split("ipv4_dst=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			ipv4_dst = strs2[0];
		}
		strs = str.split("tcp_src=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			tcp_src = strs2[0];
		}
		strs = str.split("tcp_dst=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			tcp_dst = strs2[0];
		}
		strs = str.split("mask_rc=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			mask_src = strs2[0];
		}
		strs = str.split("mask_dst=");
		strs2 = strs[1].split(",");
		if (strs2[0] != null) {
			mask_dst = strs2[0];
		}
		listapp.add(in_port);
		listapp.add(eth_dst);
		listapp.add(eth_src);
		listapp.add(eth_type);
		listapp.add(ip_proto);
		listapp.add(ipv4_src);
		listapp.add(ipv4_dst);
		listapp.add(tcp_src);
		listapp.add(tcp_dst);
		listapp.add(mask_src);
		listapp.add(mask_dst);
		return listapp;

	}
	// OFMatchV3Ver13(in_port=1, eth_dst=00:44:33:22:11:00,
	// eth_src=00:11:22:33:44:55, eth_type=0x800, ip_proto=0x6,
	// ipv4_src=0.0.0.0, ipv4_dst=0.0.0.0, tcp_src=80, tcp_dst=81)

	public static boolean test(String data1, String data2) {
		Boolean flag = false;
		List<String> listapp = new ArrayList<String>();
		List<String> listapp2 = new ArrayList<String>();
		listapp = construct(data1);
		listapp2 = construct(data2);
		if (compaers(listapp.get(5), listapp.get(6), listapp.get(9), listapp.get(10), listapp2.get(5), listapp2.get(6),
				listapp2.get(9), listapp2.get(10))) {
			if (flag = false) {
				flag = true;
			}
		}
		return flag;
	}

	public static boolean compaers(String data1, String data2, String data3, String data4, String tdata1, String tdata2,
			String tdata3, String tdata4) {
		Boolean flag = true;
		List<String> listapp = new ArrayList<String>();
		List<String> listapp2 = new ArrayList<String>();
		listapp = construct(data1);
		listapp2 = construct(data2);
		Proadar pro = new Proadar();
		String sn1 = pro.getLowAddr(data1, data3);
		String sn2 = pro.getHighAddr(data1, data3);
		String sn3 = pro.getLowAddr(data2, data4);
		String sn4 = pro.getHighAddr(data2, data4);
		Long n1 = pro.ip2long(sn1);
		Long n2 = pro.ip2long(sn2);
		Long n3 = pro.ip2long(sn3);
		Long n4 = pro.ip2long(sn4);

		String tsn1 = pro.getLowAddr(tdata1, tdata3);
		String tsn2 = pro.getHighAddr(tdata1, tdata3);
		String tsn3 = pro.getLowAddr(tdata2, tdata4);
		String tsn4 = pro.getHighAddr(tdata2, tdata4);
		Long tn1 = pro.ip2long(tsn1);
		Long tn2 = pro.ip2long(tsn2);
		Long tn3 = pro.ip2long(tsn3);
		Long tn4 = pro.ip2long(tsn4);
		if (n2 < tn1 || n1 > tn2 || n4 < tn3 || n3 > tn3) {
			if (flag = true) {
				flag = false;
			}
		}
		// if(n1<=tn1 && n2<=tn2){
		// if(n3<=tn3 && n4<=tn4){
		// if(flag=false){
		// flag=true;
		// }
		// }
		// }
		//
		// if(n1<=tn1 && n2<=tn2){
		// if(tn3<=n3 && tn4<=n4){
		// if(flag=false){
		// flag=true;
		// }
		// }
		// }
		//
		//
		// if(n1<=tn1 && n2<=tn2){
		// if(n3<=tn3 && n4<=tn4){
		// if(flag=false){
		// flag=true;
		// }
		// }
		// }
		//
		// if(n1<=tn1 && n2<=tn2){
		// if(n3<=tn3 && n4<=tn4){
		// if(flag=false){
		// flag=true;
		// }
		// }
		// }
		return flag;
	}

	public static boolean inser(String data1, String data2) {
		Boolean flag = false;
		List<String> listapp = new ArrayList<String>();
		List<String> listapp2 = new ArrayList<String>();
		listapp = construct(data1);
		listapp2 = construct(data2);
		if (compaers2(listapp.get(5), listapp.get(6), listapp.get(9), listapp.get(10), listapp2.get(5), listapp2.get(6),
				listapp2.get(9), listapp2.get(10))) {
			if (flag = false) {
				flag = true;
			}
		}
		return flag;
	}

	public static boolean compaers2(String data1, String data2, String data3, String data4, String tdata1,
			String tdata2, String tdata3, String tdata4) {
		// shuyu

		Boolean flag = false;
		List<String> listapp = new ArrayList<String>();
		List<String> listapp2 = new ArrayList<String>();
		listapp = construct(data1);
		listapp2 = construct(data2);
		Proadar pro = new Proadar();
		String sn1 = pro.getLowAddr(data1, data3);
		String sn2 = pro.getHighAddr(data1, data3);
		String sn3 = pro.getLowAddr(data2, data4);
		String sn4 = pro.getHighAddr(data2, data4);
		Long n1 = pro.ip2long(sn1);
		Long n2 = pro.ip2long(sn2);
		Long n3 = pro.ip2long(sn3);
		Long n4 = pro.ip2long(sn4);

		String tsn1 = pro.getLowAddr(tdata1, tdata3);
		String tsn2 = pro.getHighAddr(tdata1, tdata3);
		String tsn3 = pro.getLowAddr(tdata2, tdata4);
		String tsn4 = pro.getHighAddr(tdata2, tdata4);
		Long tn1 = pro.ip2long(tsn1);
		Long tn2 = pro.ip2long(tsn2);
		Long tn3 = pro.ip2long(tsn3);
		Long tn4 = pro.ip2long(tsn4);

		if (n1 <= tn1 && n2 <= tn2) {
			if (n3 <= tn3 && n4 <= tn4) {
				if (flag = false) {
					flag = true;
				}
			}
		}
		return flag;
	}

	public String replaces(String str2, String ctmp2, String ctmp) {
		String result = null;
		// List<String> listapp = new ArrayList<String>();
		// listapp=construct(str2);
		// if(ctmp2=="src"){
		// listapp.set(5, ctmp);
		// }else if(ctmp2=="dst"){
		// listapp.set(6, ctmp);
		// }
		if (ctmp2 == "src") {
			result = str2;
			String[] strs = str2.split("ipv4_src=");
			String[] strs2 = strs[1].split(",");
			String repl = strs2[0];
			result.replace(repl, ctmp);
		} else if (ctmp2 == "dst") {
			result = str2;
			String[] strs = str2.split("ipv4_dst=");
			String[] strs2 = strs[1].split(",");
			String repl = strs2[0];
			result.replace(repl, ctmp);
		}
		return result;
	}

	// private String reconst(List<String> listapp) {
	// StringBuffer result;
	// result.append
	// return null;
	// }

}
