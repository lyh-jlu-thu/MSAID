import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Synrule {
	public static Map<String, String> comp(Map<String, String> dataPeer) {
		// devide to two sets;
		Map<String, String> tmps = null;
		Map<String, String> tmpnos = null;
		Map<String, String> tmp = null;
		Boolean flag = false;
		Iterator<Map.Entry<String, String>> it = dataPeer.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String va = (String) entry.getValue();
			if (va.indexOf("set") != -1) {
				tmpnos.put((String) entry.getKey(), va);
				// need to update
			} else {
				tmps.put((String) entry.getKey(), va);
				// need to update
			}
		}
		//
		Iterator<Map.Entry<String, String>> it1 = tmps.entrySet().iterator();
		// input and rs;
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String va = (String) entry.getValue();
			// every rs (set)
			va = Update(va);
			// the figure in draft (del sw, match..)
			// update entry;
			tmps.put((String) entry.getKey(), va);
		}
		// map together;
		tmp.putAll(tmps);
		tmp.putAll(tmpnos);
		return tmp;
	}

	public static String Update(String va) {
		// ervery rs, update rs;
		String vas;
		Map<String, List<String>> tmp;
		tmp = convert(va); // rs, return del, (sw, match); install (sw,
							// match...)

		Map<String, List<String>> nostmp = null;
		Map<String, List<String>> stmp = null;

		Iterator<Map.Entry<String, List<String>>> it1 = tmp.entrySet().iterator();// del,
																					// ,
																					// (sw,
																					// match);
																					// install
																					// (sw,
																					// match...)

		while (it1.hasNext()) {
			Map.Entry entry = (Map.Entry) it1.next();
			List<String> vals = (List<String>) entry.getValue();
			if (wset(vals)) {
				stmp.put((String) entry.getKey(), vals); // del, , (sw, match);
															// install (sw,
															// match...)
			} else {
				nostmp.put((String) entry.getKey(), vals);
			}
		}
		// os is two set, s, nos

		Iterator<Map.Entry<String, List<String>>> it2 = stmp.entrySet().iterator();
		Iterator<Map.Entry<String, List<String>>> it3 = nostmp.entrySet().iterator();
		Map<String, List<String>> tmpl;
		while (it2.hasNext()) {
			Map.Entry entry = (Map.Entry) it2.next();
			List<String> l2 = (List<String>) entry.getValue();
			// del, , (sw, match); install (sw, match...)
			while (it3.hasNext()) {
				tmpl = null;
				Map.Entry entry3 = (Map.Entry) it3.next();
				List<String> l3 = (List<String>) entry3.getValue();

				tmpl = osyr((String) entry.getKey(), l2, (String) entry3.getKey(), l3);
				// del, , (sw, match); install (sw, match...)
				if (tmpl != null) {
					nostmp.putAll(tmpl);
				}
			}
			stmp.remove(l2);
		}
		String res = inconvert(nostmp);
		return res;
	}
	
	public static String getMat(String str, String str2, String str3){
		//Poscode from 6 to 9
		String ctmp = null;
		String ctmp2 = null;
		String[] strs = str.split("set=");
		String[] strs2 = strs[1].split("");
		if (strs2[0] != null) {
			if(strs2[0]=="src"){
				strs2 = strs[2].split(",");
				ctmp=strs2[0];
				ctmp2="src";
			}else{
				if(strs2[0]=="dst"){
					strs2 = strs[2].split(",");
					ctmp=strs2[0];
					ctmp2="dst";
				}
			}
		}
		Ematch tem =new Ematch();
		String results = tem.replaces(str2, ctmp2, ctmp);
		return results;
	}
	public static String getSm(List<String> str){
		//compute the match after apply set;
		String tmp;
		String ctmp = null;
		String ctmp2 = null;
		if (str.get(3).indexOf("src")!=-1){
			ctmp2="src";
		}
		if (str.get(3).indexOf("dst")!=-1){
			ctmp2="dst";
		}
		String[] strs = str.get(3).split("set=");
		String[] strs2 = strs[1].split("");
		if (strs2[0] != null) {
			if(strs2[0]=="src"){
				strs2 = strs[2].split(",");
				ctmp=strs2[0];
			}else{
				if(strs2[0]=="dst"){
					strs2 = strs[2].split(",");
					ctmp=strs2[0];
				}
			}
		}
		Ematch tem =new Ematch();
		String results = tem.replaces(str.get(2), ctmp2, ctmp);
		return results;		
	}
	
	public static Map<String, List<String>> osyr(String k1, List<String> tmpl1, String k2, List<String> tmpl2) {
		//tmpl2 contains no set 
		Map<String, List<String>> tmpnew = null;
		List<String> listapp = new ArrayList<String>();
		Ematch mat = new Ematch();
		String matchs;
		if (mat.inser(tmpl1.get(2), getSm(tmpl2))) {
			// match
			if (k1 != "del") {
				if (k2 != "del") {
					if (tmpl1.get(0) == tmpl2.get(0)) {
						// sw=sw
						// get entry's match;
						matchs = getMat(tmpl1.get(2), tmpl2.get(2), tmpl1.get(3));
						listapp = null;
						matchs = null;
						listapp.add(k2);
						// action
						listapp.add(tmpl2.get(0));
						// sw
						listapp.add(
								String.valueOf(min(Integer.parseInt(tmpl1.get(1)), Integer.parseInt(tmpl2.get(1)))));
						// prio
						listapp.add(matchs);
						// match;
						listapp.add(tmpl2.get(3));
						// ac
					}
				}
			}
		}
		return tmpnew;

	}

	private static int min(int parseInt, int parseInt2) {
		int minal = parseInt2;
		if (parseInt < parseInt2)
			minal = parseInt;
		return minal;
	}

	public static Boolean wset(List<String> a) {
		Boolean flag = false;
		if (a.get(3).indexOf("set") != -1) {
			if (flag = false) {
				flag = true;
			}
		}
		return flag;
	}

	public static String inconvert(Map<String, List<String>> datas) {
		// String tmp=null;
		StringBuilder str = new StringBuilder();
		Iterator<Map.Entry<String, List<String>>> it2 = datas.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry entry3 = (Map.Entry) it2.next();
			List<String> tmplaa = (List<String>) entry3.getValue();
			str.append((String) entry3.getKey() + "&" + tmplaa.get(0) + " " + tmplaa.get(1) + " " + tmplaa.get(2) + " "
					+ tmplaa.get(3) + ";");// one
			// os
		}

		//
		// for (int i = 0; i < data.size(); i++) {
		//// List<String> tmplaa = data.get(i);
		// str.append(tmplaa.get(0) + " " + tmplaa.get(1) + " " + tmplaa.get(2)
		// + " " + tmplaa.get(3) + ",");// one
		// // os
		// }
		// add, sw, prior, match, action;
		return str.toString();
	}

	public static Map<String, List<String>> convert(String data) {
		// first get multiple os;
		String[] na = data.split(";");
		// del, , (sw, match);
		// install (sw,
		// match...)
		Map<String, List<String>> dataPeer = new HashMap<String, List<String>>();
		for (int i = 0; i < na.length; i++) {
			String[] a = data.split("&");
			// del, , (sw, match);
			// for (int i = 0; i < a.length; i++) {
			String[] aa = a[1].split(" ");
			List<String> listapp = new ArrayList<String>();
			listapp.add(aa[0]);
			listapp.add(aa[1]);
			listapp.add(aa[2]);
			listapp.add(aa[3]);
			dataPeer.put(a[0], listapp);
			// }
			// }
			// String[] a = data.split(",");
			// // one os;
			// Map<String, List<String>> dataPeer = new HashMap<String,
			// List<String>>();
			// for (int i = 0; i < a.length; i++) {
			// String[] aa = a[i].split(" ");
			// List<String> listapp = new ArrayList<String>();
			// listapp.add(aa[1]);
			// listapp.add(aa[2]);
			// listapp.add(aa[3]);
			// listapp.add(aa[4]);
			// dataPeer.put(aa[0], listapp);
			// // add, sw, prior, match, action;
		}
		return dataPeer;
	}

}
