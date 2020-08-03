package sort;

import com.alibaba.fastjson.JSON;

/**
 * Description: 快速排序
 *
 * @author : 杨帅军 (shuaijun.yang@ucarinc.com)
 * @since : 2020/8/3 14:04:01
 **/
public class QuickSort {

    public static void sort(int array[], int low, int high) {// 传入low=0，high=array.length-1;
        int pivot, p_pos, i, t;// pivot->位索引;p_pos->轴值。
        if (low < high) {
            p_pos = low;
            pivot = array[p_pos];
            for (i = low + 1; i <= high; i++)
                if (array[i] > pivot) {
                    p_pos++;
                    t = array[p_pos];
                    array[p_pos] = array[i];
                    array[i] = t;
                }
            t = array[low];
            array[low] = array[p_pos];
            array[p_pos] = t;
            // 分而治之
            sort(array, low, p_pos - 1);// 排序左半部分
            sort(array, p_pos + 1, high);// 排序右半部分
        }
    }

    public static void sort(int array[]){
        sort(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] temp  = {1,5,3,4,7,6,9,2};
        sort(temp);
        System.out.println(JSON.toJSONString(temp));
    }
}
