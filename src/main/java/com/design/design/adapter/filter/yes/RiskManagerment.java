package com.design.design.adapter.filter.yes;


import java.util.ArrayList;
import java.util.List;

/**
   使用了适配器之后
    扩展性更好，更加符合开闭原则，如果添加一个新的敏感词过滤系统
    这个类则完全不需要改动，而且基于接口而非实现变成，代码的可测试性更好
 */
public class RiskManagerment {

    private List<ISensitiveWordsFilter> filters=new ArrayList<>();

    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter){
        filters.add(filter);
    }

    public String filterSenstiveWords(String text){
        String maskedText=text;
        for (ISensitiveWordsFilter filter:filters){
            maskedText=filter.filter(maskedText);
        }
        return maskedText;
    }
}
