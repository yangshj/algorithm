package sort;

import com.alibaba.fastjson.JSON;

/**
 * Description: 冒泡排序
 *
 * @author : 杨帅军 (shuaijun.yang@ucarinc.com)
 * @since : 2020/8/3 13:49:29
 **/
public class BubbleSort {


    public static void sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] temp  = {1,5,3,4,7,6,9,2};
        sort(temp);
        System.out.println(JSON.toJSONString(temp));

    }


}
