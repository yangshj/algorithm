package rsa;

/**
 * Description: 可以用代码来计算d的值
 *
 * @author : 杨帅军 (shuaijun.yang@ucarinc.com)
 * @since : 2020/9/16 16:44:50
 **/
public class TestD {

    public static void main(String[] args) {
        // E * D mod L = 1
        // L = 60; E=7,11,13,17,19,23,29,31,37,41
        // 求D, D满足 1<D<L
        int e = 41;
        for(int i=0; i<60; i++){
            if((i*e)%60==1){
                System.out.println("d= "+i);
            }
        }
    }
}
