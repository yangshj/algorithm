package recursion;

/**
 * Description: 实现斐波那契数列
 *
 * @author : 杨帅军 (shuaijun.yang@ucarinc.com)
 * @since : 2020/8/3 11:28:13
 **/
public class Febonacci {

    /**
     * 用递归实现斐波那契数列
     * @param i 需要得到的第i项
     * @return 第i项内容
     */
    public static int febonaccis(int i){
        if(i == 2 || i == 1){
            return 1;
        }else{
            return febonaccis(i-1) + febonaccis(i - 2);
        }
    }

    /**
     * 用非递归实现斐波那契数列
     */
    public static long febonaccis2(int n) {
        long arr[] = new long[n+1];
        arr[0]=0;
        arr[1]=1;           //n不能为0，因为n为0时，arr大小为1，arr[1]越界。
        for(int i=2;i<=n;i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        for(int i=1; i<15; i++){
            System.out.print( febonaccis2(i) +"\t");
        }
        System.out.println("\r\n");
        for(int i=1; i<15; i++){
            System.out.print( febonaccis(i) +"\t");
        }
    }
}
