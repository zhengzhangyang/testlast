/**
 * @ClassName E
 * @Author Zhengzy
 * @Date 2020-11-03 14:24
 * @Version 1.0
 **/
public class E {
    public static void main(String[] args) {
    /*    String a = "944006010006430443_13376302_20191123_2100_29091495101020303678810.pdf";
        String[] receiptArr = a.replace(".pdf", "").split("_");
        for (int i = 0; i < receiptArr.length; i++) {
            System.out.println(receiptArr[i]);
        }*/
        String pdfFileName = "1dfsdfdf521609_20201204_3240792011200900495863_C_LCS_000001_001111.pdf";
        // 账号_日期_流水号_借贷_摘要
        String istNbr = "";
        String[] tempArr = pdfFileName.split("_");
        for (int i = 0; i < 5; i++) {
                istNbr += tempArr[i] + "_";
        }
        istNbr = istNbr.substring(0, istNbr.lastIndexOf("_"));
        String isNbr = "15000100205824_20201120_3240792011200900495863_C_LCS";
        System.out.println(isNbr.equals(istNbr));
/*        System.out.println(getTableName("15000097795772"));
    }

    public static String getTableName(String pActNum){
        int sum = 0;
        for(int i=0;i<pActNum.length();i++){
            sum += pActNum.charAt(i);
        }
        return "RECEIPTDATA" + (sum%10);
    }*/
    }
}
