package com.design.design.strategy.sort;

public class SortTest {

    public static void main(String[] args) {

        /**
         * 代码未优化时的版本
         */
        Sorter sorter=new Sorter();
        sorter.sortFile(args[0]);


    }
}
