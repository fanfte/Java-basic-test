package bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by tianen on 2019/6/11
 *
 * @author fanfte
 * @date 2019/6/11
 **/
public class TestGuavaBloomFilter {

    public static void main(String[] args) {
        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }

        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        System.out.println(filter.mightContain(3));
        System.out.println(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }
}
