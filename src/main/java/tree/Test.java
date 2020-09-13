package tree;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args){

        BPlusTree<Product, Integer> b = new BPlusTree<>(4);

        long time1 = System.nanoTime();

        int temp[] = {10,17,3,29,6,5,18,4,22,1,33,35};
        for(int j=0;j<temp.length;j++){
            int i = temp[j];
            Product p = new Product(i, "test", 1.0 * i);
            b.insert(p, p.getId());
        }

        long time2 = System.nanoTime();

        Product p1 = b.find(3);

        long time3 = System.nanoTime();

        System.out.println("插入耗时: " + (time2 - time1));
        System.out.println("查询耗时: " + (time3 - time2));

        ArrayList<String> list = new ArrayList();
        list.add("d");
        list.add(1,"d");
        list.remove("d");
    }
}
