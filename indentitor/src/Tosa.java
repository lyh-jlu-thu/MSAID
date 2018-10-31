
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Tosa {
    private static Log log = LogFactory.getLog(Tosa.class);

    public static void saveData2File(String Data,String filePath,String fileName){
        try {
            /* 闁告劖鐟ラ崣鍝t闁哄倸娲ｅ▎锟� */
            File writename = new File(filePath+"/"+fileName); // 闁烩晝顭堥顔炬崉椤栨氨绐為柨娑樿嫰椤┭囧几濠婂嫮姊鹃柡鍫濐槸閸垳鎲版担鍝ョ处缂佹柨顑勭粩瀛樼▔椤忓懏鐓�闁汇劌鍩tput闁靛棗锟斤拷xt闁哄倸娲ｅ▎锟�
            writename.createNewFile(); // 闁告帗绋戠紓鎾诲棘閻楀牊鐎ù鐙呮嫹
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(Data); // \r\n闁告鍘栫拹鐔煎箲閵忥綆鏀�
            out.flush(); // 闁硅泛锕︾槐锔撅拷娑櫭亸顖炲礃閸涱収鍟囬柛妯侯儏閸欏棝寮崶锔筋偨
            out.close(); // 闁哄牞鎷烽柛姘唉椤斿洤顕ュΔ锟介崣褔姊婚鐔哥�ù鐙呮嫹
        } catch (Exception e){
            log.error("SaveFileUtils error!",e);
        }

    }
}
