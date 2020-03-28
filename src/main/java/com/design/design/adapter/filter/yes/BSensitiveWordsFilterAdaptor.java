package com.design.design.adapter.filter.yes;

import com.design.design.adapter.filter.BSensitiveWordsFilter;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private BSensitiveWordsFilter bFilter;

    @Override
    public String filter(String text) {
        String maskedText=bFilter.filter(text);
        return maskedText;
    }
}
