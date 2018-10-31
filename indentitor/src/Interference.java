import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Interference {
	
	public static boolean test(int i, int j, Map<String, String>dataPeer1, Map<String, String> dataPeer2) {
		Boolean flag=false;
		List<String> interall = new ArrayList<String>();
		// at start, no conflicts in the maps
		Iterator<Map.Entry<String, String>> it = dataPeer1.entrySet().iterator();  
		Iterator<Map.Entry<String, String>> it1 = dataPeer2.entrySet().iterator();  
        while(it.hasNext()){ 
        	 while(it1.hasNext()){ 
             	Map.Entry entry1= (Map.Entry) it1.next(); 
             	Map.Entry entry= (Map.Entry) it.next(); 
             	String va1=(String) entry1.getValue();
             	String va=(String) entry.getValue();
             	Intereach ie=new Intereach();
             	ie.test(va1,va); // output1 and output2 (r1, r2)
             	if(flag=false){
             		if(ie.test(va1,va)){
             			flag=true;
             		}
             	}
             	if(ie.test(va1,va)){
             		interall.add(va1+";;"+va);
 				}
 			}	 
        }
		if (interall.size() != 0) {
			String s=String.valueOf(i);
			String s1=String.valueOf(j);
			if (!isExistFile("/", s+"and"+s1)) {
				Iterator<String> it11 = interall.iterator();
				while (it11.hasNext()) {
					String tmpstr = it11.next();
					addData2File("/",  s+"and"+s1, tmpstr + "\n");
				}
			}
		}
		return flag;
	}
	
	
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
	
}
