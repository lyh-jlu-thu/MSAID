import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Intereach {
	public static boolean test(String data1, String data2) {
		// r1, r2;
		// first get multiple os;
		Boolean flag = false;
		Map<String, List<String>> a1 = new HashMap<String, List<String>>();
		Map<String, List<String>> b2 = new HashMap<String, List<String>>();
		a1 = convert(data1);
		b2 = convert(data2);
		Iterator<Map.Entry<String, List<String>>> it = a1.entrySet().iterator();
		Iterator<Map.Entry<String, List<String>>> it1 = b2.entrySet().iterator();
		while (it.hasNext()) {
			while (it1.hasNext()) {
				Ematch mat=new Ematch();
				Map.Entry entry1 = (Map.Entry) it1.next();
				Map.Entry entry = (Map.Entry) it.next();
				List<String> va1 = (List<String>) entry1.getValue();
				List<String> va = (List<String>) entry.getValue();
				String k1 = (String) entry1.getKey();
				String k = (String) entry.getKey();
				if (k1 != "del") {
					if (k != "del") {
						if (va1.get(0) == va.get(0)) {
							if (mat.test(va.get(2), va1.get(2))) {
								//whether have common
								if(va.get(3)!=va.get(3)){
								if (flag == false) {
									flag = true;
								}
								}
//								if(va.get(1)!=va.get(1)){
//									//over entry
//								}
//								else{
//									//miss entry
//								}
							}
						}
					}
				}
			}
		}
		return flag;
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
		}
		return dataPeer;
	}

}
//	public static Map<String, List<String>> convert(String data) {
//		// first get multiple os;
//		String[] a = data.split(",");
//		// one os;
//		Map<String, List<String>> dataPeer = new HashMap<String, List<String>>();
//		for (int i = 0; i < a.length; i++) {
//			String[] aa = a[i].split(" ");
//			List<String> listapp = new ArrayList<String>();
//			listapp.add(aa[1]);
//			listapp.add(aa[2]);
//			listapp.add(aa[3]);
//			listapp.add(aa[4]);
//			dataPeer.put(aa[0], listapp);
//			// add, sw, prior, match, action;
//		}
//		return dataPeer;
//	}
