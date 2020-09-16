package rsa;

import java.math.BigDecimal;

/**
 * Description:
 *
 *  https://my.oschina.net/yangshj/blog/1933964
 *
 * @author : 杨帅军 (shuaijun.yang@ucarinc.com)
 * @since : 2020/9/16 16:33:52
 **/
public class SimpleRSA {
    /**
     * 加密、解密算法
     * @param key 公钥或密钥
     * @param message 数据
     * @return
     */
    public static long rsa(int baseNum, int key, long message){
        if(baseNum < 1 || key < 1){
            return 0L;
        }
        //加密或者解密之后的数据
        BigDecimal rsaMessage;
        //加密核心算法(采用BigDecimal避免超过long最大值，丢失精度)\
        //message的key次方 % baseNum
        BigDecimal init = new BigDecimal(message + "");
        BigDecimal message1 = new BigDecimal(message + "");
        BigDecimal baseNum1 = new BigDecimal(baseNum + "");
        for(int i = 1; i < key; i++){
            init = message1.multiply(init);
        }
        rsaMessage = init.divideAndRemainder(baseNum1)[1];
        long s = rsaMessage.longValue();
        return s;
    }

    public static void main(String[] args){
        //基数 n
        int baseNum = 7*11;
        //公钥 e
        int keyE = 37;
        //密钥 d
        int keyD = 13;
        //未加密的数据 x
        long msg = 6L;
        //加密后的数据 x^e mod n = ( 6^37 % 77 ) = 41 = y
        long encodeMsg = rsa(baseNum, keyE, msg);
        //解密后的数据 y^d mod n = ( 41^13 % 77 ) = 6 = x
        // n=77 e=37 y=41 求x, 满足x的可能有很多。 pq销毁了，无法推出d，因此无法解密
        long decodeMsg = rsa(baseNum, keyD, encodeMsg);

        System.out.println("加密前：" + msg);
        System.out.println("加密后：" + encodeMsg);
        System.out.println("解密后：" + decodeMsg);
    }
}
