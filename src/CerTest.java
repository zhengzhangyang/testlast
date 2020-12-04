import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;

/**
 * @ClassName CerTest
 * @Author Zhengzy
 * @Date 2020-10-21 14:50
 * @Version 1.0
 **/
public class CerTest {
    public static void main(String[] args) throws FileNotFoundException, CertificateException {
        String keyStorefile1 = "C:\\dsp_Beat_20201015201320\\dsp\\config\\portfiles\\MYBank01\\tianweiluoyang\\antebank_tianwei_ly.pfx";
        String keyStorefile2 = "C:\\dsp_Beat_20200927094339\\dsp\\config\\portfiles\\MYBank01\\tianweihipac\\tianwei_20200930.pfx";
        String keyStorefile3 = "C:\\dsp_Beat_20201015201320\\dsp\\config\\portfiles\\MYBank01\\tianweimy\\antebank_tianwei_my.pfx";
        String keyPassword = "12345678";
        getPvkformPfx(keyStorefile1, keyPassword);
    }
    /**
     * getPvkformPfx: 从PFX文件中获取私钥
     * @param strPfx 文件存储目录
     * @param strPassword PFX密码
     */
    private  static PrivateKey getPvkformPfx(String strPfx, String strPassword){
        try {
            FileInputStream fis = new FileInputStream(strPfx);
            //密码处理
            char[] nPassword = null;
            if ((strPassword == null) || strPassword.trim().equals("")){
                nPassword = null;
            } else {
                nPassword = strPassword.toCharArray();
            }
            //加载读取PFX文件
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(fis, nPassword);
            fis.close();
            Enumeration enumas = ks.aliases();
            //从文件中获取秘钥
            String keyPFXFile = null;
            if (enumas.hasMoreElements()) {
                keyPFXFile = (String)enumas.nextElement();
            }
            PrivateKey prikey = (PrivateKey) ks.getKey(keyPFXFile, nPassword);
            Certificate cert = ks.getCertificate(keyPFXFile);
            PublicKey pubkey = cert.getPublicKey();
            System.out.println("cert class = " + cert.getClass().getName());
            System.out.println("cert = " + cert);
            System.out.println("public key = " + pubkey);
            System.out.println("private key = " + prikey);
            BASE64Encoder bse = new BASE64Encoder();
            System.out.println("private encode = " + bse.encode(prikey.getEncoded()));
            return prikey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
