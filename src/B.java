import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName B
 * @Author Zhengzy
 * @Date 2020-10-16 16:34
 * @Version 1.0
 **/
public class B {
    public static void main(String[] args) {

        String oppNm = "星期二a3423是";

        try {
            int num = getChineseSize(oppNm);
            int a2 = oppNm.getBytes("gbk").length;
            int a1= oppNm.length();
            int sNum = 60-num;
            String e = (String.format("%"+ sNum +"s", oppNm));// 户名  文件中的户名
            int byteNumAll = e.getBytes("gbk").length ;  // 上送文件的字节数
            int c = 2;


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取内容中-汉字个数
     * @param content - 内容
     * @return int
     */
    public static int getChineseSize(String content) {
        int count = 0;//汉字数量
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        int len = m.groupCount();
        while (m.find()) {
            for (int i = 0; i <= len; i++) {
                count = count + 1;
            }
        }
        return count;
    }
}
