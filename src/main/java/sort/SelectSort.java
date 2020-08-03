package sort;

import com.alibaba.fastjson.JSON;

/**
 * Description: 选择排序
 * 将排序的数据分为已排序区间和未排序区间，一般是以第一个元素为已排序区间，然后依次遍历未排序区间，找到其最小值，
 * 和未排序区间的最后一个值进行比较，交换位置。未排序区间遍历完毕，则排序结束
 * @author : 杨帅军 (shuaijun.yang@ucarinc.com)
 * @since : 2020/8/3 13:58:39
 **/
public class SelectSort {

    public static void sort(int array[]) {
        int t = 0;
        for (int i = 0; i < array.length - 1; i++){
            int index=i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j])
                    index = j;
            }
            if(index!=i){ //找到了比array[i]小的则与array[i]交换位置
                t = array[i];
                array[i] = array[index];
                array[index] = t;
            }
        }
    }


    public static void main(String[] args) {
        int[] temp  = {1,5,3,4,7,6,9,2};
        sort(temp);
        System.out.println(JSON.toJSONString(temp));

    }
}
