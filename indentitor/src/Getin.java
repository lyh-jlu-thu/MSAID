import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created on 2017/3/6.
 */
public class Getin {
	
	public static String readFileByLines (String filePath,String fileName) {
        File file = new File(filePath+"/"+fileName);
        BufferedReader reader = null;
        StringBuilder data= new StringBuilder();
        readData(file,reader,data);
        return data.toString();
    }

    public static List<String> readFileByLines (String filePath) {
        File filep = new File(filePath);
        List<String> resultList = new ArrayList<String>();
        Arrays.stream(filep.listFiles()).forEach(file -> {
            BufferedReader reader = null;
            StringBuilder data = new StringBuilder();
            readData(file, reader, data);
            resultList.add(data.toString());
        });

        return resultList;
    }

    private static void readData(File file, BufferedReader reader, StringBuilder data) {
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 涓�娆¤鍏ヤ竴琛岋紝鐩村埌璇诲叆null涓烘枃浠剁粨鏉�
            while ((tempString = reader.readLine()) != null) {
                data.append(tempString);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e1) {
                }
            }
        }
    }

}
