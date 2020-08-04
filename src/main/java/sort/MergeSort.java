package sort;

import com.alibaba.fastjson.JSON;

/**
 * Description: 归并排序
 *
 * @author : 杨帅军 (shuaijun.yang@ucarinc.com)
 * @since : 2020/8/4 18:02:04
 **/
public class MergeSort {

    public static void sort(int[] nums) {
        //创建与原数组相同长度的数组
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length-1);
    }

    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if(left < right) {
            //从中间将数组分成两半
            int mid = (left + right) >> 1;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp, mid+1, right);
            //将两个数组重新合并
            merge(nums, temp, left, mid+1, right);
        }
    }

    private static void merge(int[] nums, int[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        //对比左右两个数组并将较小的数先放到辅助数组
        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if(nums[leftPos] <= nums[rightPos]) {
                temp[tmpPos++] = nums[leftPos++];
            }else {
                temp[tmpPos++] = nums[rightPos++];
            }
        }
        //把左边数组剩下的原数放到辅助数组
        while(leftPos <= leftEnd) {
            temp[tmpPos++] = nums[leftPos++];
        }
        //把右边数组剩下的原数放到辅助数组
        while(rightPos <= rightEnd) {
            temp[tmpPos++] = nums[rightPos++];
        }
        //把辅助数组复制到原数组
        for(int i = 0; i < numElements; i++,rightEnd--) {
            nums[rightEnd] = temp[rightEnd];
        }
    }

    public static void main(String[] args) {
        int[] temp  = {1,5,3,4,7,6,9,2};
        sort(temp);
        System.out.println(JSON.toJSONString(temp));
    }
}
