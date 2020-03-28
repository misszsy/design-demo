package com.design.design.adapter.filter.yes;

import com.design.design.adapter.filter.CSensitiveWordsFilter;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private CSensitiveWordsFilter cFilter;

    @Override
    public String filter(String text) {
        String maskedText=cFilter.filter(text,"***");
        return maskedText;
    }
}
