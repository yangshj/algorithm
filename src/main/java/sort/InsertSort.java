package sort;

import com.alibaba.fastjson.JSON;

/**
 * Description: 插入排序
 *
 * @author : 杨帅军 (shuaijun.yang@ucarinc.com)
 * @since : 2020/8/3 14:01:22
 **/
public class InsertSort {

    public static void sort(int array[]) {
        int i, j, t = 0;
        for (i = 1; i < array.length; i++) {
            if(array[i]<array[i-1]){
                t = array[i];
                for (j = i - 1; j >= 0 && t < array[j]; j--) {
                    array[j + 1] = array[j];
                }
                //插入array[i]
                array[j + 1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] temp  = {1,5,3,4,7,6,9,2};
        sort(temp);
        System.out.println(JSON.toJSONString(temp));

    }
}
