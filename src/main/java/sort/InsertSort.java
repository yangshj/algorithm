package sort;

import com.alibaba.fastjson.JSON;

/**
 * Description: 插入排序
 * 将排序数据分为已排序区间和未排序区间，依次遍历未排序区间，和已排序区间的值进行比较，
 * 将其插入到合适的位置上，直至将未排序的区间数据遍历完
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
