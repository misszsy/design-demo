package com.design.design.strategy.sort;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现对一个文件进行排序的功能，文件中只包含整型数
 * 并且，相邻的数字通过都好来区隔。
 * 实现方案：
 *      1.将文件中的内容读取出来，并且通过逗号分割成一个一个的数字，放到内存数组中，
 *        然后编写某种排序算法（比如快排），或者直接使用编程语言提供的排序函数，对数组
 *        进行排序，最后再将数组中的数据写入文件
 *      2.当文件10GB大小，因为内存有限（比如只有8GB大小），没办法一次性加载文件的所有数据到内存中，
 *        这个时候就要利用外部排序算法。
 *      3.当文件更大，达到 100GB 大小的时候，为了利用 CPU 多核的优势，可以在外部排序基础之上进行优化，
 *        加入多线程并发排序功能，类似单机版的 "MapReduce"
 *      4.如果文件非常大，有 1TB 大小，即便是单机多线程排序，也会算很慢，这个时候可以使用真正的 MapReduce 框架，
 *        利用多级处理能力，提高排序的效率
 *
 *
 */
public class Sorter {

    private static final long GB=1000 * 1000 * 1000;

    private static final List<AlgRange> algs=new ArrayList<>();

    static {
        algs.add(new AlgRange(0,6*GB,SortAlgFactory.getSortAlg("QuickSort")));
        algs.add(new AlgRange(6*GB,10*GB,SortAlgFactory.getSortAlg("ExternalSort")));
        algs.add(new AlgRange(10*GB,100*GB,SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
        algs.add(new AlgRange(100*GB,Long.MAX_VALUE,SortAlgFactory.getSortAlg("MapReduceSort")));
    }

    /**
     * 编码规范中，提示函数的行数不能过多，最好不要超过一屏的大小，所以为了避免sortFile()函数过长
     * 把每种排序算法 从 sortFile() 函数中抽离出来，拆成 4个独立的排序函数。
     *
     * 如果只是开发一个简单的工具，下面的代码实现足够，毕竟代码不多，后续修改，扩展的需求也不多，怎么
     * 写也不会导致代码不可维护的地步。
     *
     * 但如果实在开发一个大型项目，排序文件只是其中的一个功能模块，那就要在代码设计，代码质量上下功夫，
     * 只有每个小的功能模块都写好，整个项目的代码才能不差。
     *
     *
     * @param filePath
     */
    public void sortFile(String filePath){
       //省略检验逻辑
       File file=new File(filePath);
       long fileSize=file.length();
    /*
      1.代码未优化时的调用方式
        if(fileSize < 6 * GB){
          quickSort(filePath);
        }else if(fileSize < 10 * GB){
          externalSort(filePath);
        }else if(fileSize < 100 * GB){
          concurrentExternalSort(filePath);
        }else {
          mapReduceSort(filePath);
        }
      2.因为每种排序类都是无状态的，没必要每次使用的使用，都重新创建一个新的对象，
        所以：可以使用工厂模式对对象的创建进行封装
        ISortAlg sortAlg;
        if(fileSize < 6 * GB){
          sortAlg=new QuickSort();
        }else if(fileSize < 10 * GB){
          sortAlg=new ExternalSort();
        }else if(fileSize < 100 * GB){
          sortAlg=new ConcurrentExternalSort();
        }else {
          sortAlg=new MapReduceSort();
        }
          sortAlg.sort(filePath);

      3.这是使用工厂模式重构后的代码方式，已经符合了策略模式的代码结构，现在可以使用策略模式将
        策略的定义，创建，使用解耦，让每一部分都不至于复杂，不过 sortFile 函数还是有一堆if-else逻辑，
        因为这里的if-else逻辑分支不多，也不复杂，这样写没问题你。
        但如果特别想移除掉 if-else 分支判断，可以基于查表法解决，其中的 “algs” 就是表
        ISortAlg sortAlg;
        if(fileSize < 6 * GB){
            sortAlg=SortAlgFactory.getSortAlg("QuickSort");
        }else if(fileSize < 10 * GB){
            sortAlg=SortAlgFactory.getSortAlg("ExternalSort");
        }else if(fileSize < 100 * GB){
            sortAlg=SortAlgFactory.getSortAlg("ConcurrentExternalSort");
        }else {
            sortAlg=SortAlgFactory.getSortAlg("MapReduceSort");
        }
     */
    /*
      4.这是消除 if-else 分支判断重构后的代码
        我们把可变的部分隔离到了策略工厂类和Sorter类中的静态代码段中，当要添加一个新的排序算法时，我们只需要
        修改策略工厂类和Sort类中的静态代码段，其他代码都不需要修改，这样就将代码改动最小化，集中化了。
     */
        ISortAlg sortAlg=null;
        for (AlgRange alg : algs) {
            if(alg.inRange(fileSize)){
                sortAlg=alg.getAlg();
                break;
            }
        }
        sortAlg.sort(filePath);
    }


    private static class AlgRange{
        private long start;
        private long end;
        private ISortAlg alg;

        public AlgRange(long start,long end,ISortAlg alg){
            this.start=start;
            this.end=end;
            this.alg=alg;
        }

        public ISortAlg getAlg() {
            return alg;
        }

        public boolean inRange(long size){
            return size >= start && size < end;
        }
    }

    private void quickSort(String filePath){
        //快速排序
    }

    private void externalSort(String filePath){
        //外部排序
    }

    private void concurrentExternalSort(String filePath){
        //多线程外部排序
    }

    private void mapReduceSort(String filePath){
        //利用MapReduce多机排序
    }
}
