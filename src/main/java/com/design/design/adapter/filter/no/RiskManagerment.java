package com.design.design.adapter.filter.no;

import com.design.design.adapter.filter.ASensitiveWordsFilter;
import com.design.design.adapter.filter.BSensitiveWordsFilter;
import com.design.design.adapter.filter.CSensitiveWordsFilter;

/**
   未使用适配器模式之前的代码：代码的可测试性、扩展性不好
 */
public class RiskManagerment {

    private ASensitiveWordsFilter aFilter=new ASensitiveWordsFilter();
    private BSensitiveWordsFilter bFilter=new BSensitiveWordsFilter();
    private CSensitiveWordsFilter cFilter=new CSensitiveWordsFilter();


    public String filterSenstiveWords(String text){
        String maskedText=aFilter.filterSexyWords(text);
        maskedText=aFilter.filterPoliticalWords(maskedText);
        maskedText=bFilter.filter(maskedText);
        maskedText=cFilter.filter(maskedText,"***");
        return maskedText;
    }
}
