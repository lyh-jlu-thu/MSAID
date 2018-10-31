import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
import java.util.NoSuchElementException;

public class Inone {
	
	// the entry
	
	private static void addData2File(String filePath, String fileName, String data) {
		File path = new File(filePath);
		File file = new File(path, fileName);
		addData2File(file, data);
	}
	
	
	private static void addData2File(File file, String conent) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			out.write(conent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static boolean isExistFile(String path, String fileName) {
		File file = new File(path + "/" + fileName);
		return file.exists() && file.length() > 0;
	}
	
	public static void main(String args[]) throws Exception {
		// execution for the tested n applications
		List<Map<String, String>> dataPeerlist = new ArrayList<Map<String, String>>();
		for (int j = 1; j <= 2; j++) {
			// get the information from the result of symbolic execution
			Map<String, String> dataPeer = new HashMap<String, String>();
			BufferedReader br = null;
			String str = null;
			try {
				br = new BufferedReader(new FileReader(new File("se" + j+".txt")));
				String[] arrs = null;
				for (str = br.readLine(); str != null; str = br.readLine()) {
					arrs = str.split("--");
					dataPeer.put(arrs[0], arrs[1]); // input; output  
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			br.close();

			Iterator<Map.Entry<String, String>> it = dataPeer.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String key = (String) entry.getKey();
				if (entry.getValue() == null) {
					it.remove();
				}
			}

			Boolean sflag = false;
			Iterator<Map.Entry<String, String>> it1 = dataPeer.entrySet().iterator();
			while (it1.hasNext()) {
				Map.Entry entry = (Map.Entry) it1.next();
				String values = (String) entry.getValue();
				if (values.indexOf("set") != -1) {
					sflag = true;
					break;
				}
			}
			if (sflag) {
				Synrule sr = new Synrule();
				dataPeer = sr.comp(dataPeer);
			}

			dataPeerlist.add(dataPeer);
		}

		int n = 2;
		List<Integer> listapp = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			listapp.add(i);
		}
		List<String> interall = new ArrayList<String>();
		Interference interfer = new Interference();
		Combin combin = new Combin(listapp, 2);
		Boolean flag;
		for (Object list : combin) {
			String tmp = list.toString();
			int i = Integer.parseInt(String.valueOf(tmp.charAt(0)));
			int j = Integer.parseInt(String.valueOf(tmp.charAt(1)));
			flag = interfer.test(i-1, j-1, dataPeerlist.get(i - 1), dataPeerlist.get(j - 1));
			if (flag) {
				interall.add(tmp);
			}
		}
		
		if (interall.size() != 0) {
			if (!isExistFile("/", "interresult")) {
				Iterator<String> it = interall.iterator();
				while (it.hasNext()) {
					String tmpstr = it.next();
					addData2File("/", "interresult", tmpstr + "\n");
				}
			}
		}

	}
}
