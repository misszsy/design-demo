package com.design.design.adapter.filter.yes;

import com.design.design.adapter.filter.ASensitiveWordsFilter;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private ASensitiveWordsFilter aFilter;

    @Override
    public String filter(String text) {
        String maskedText=aFilter.filterSexyWords(text);
        maskedText=aFilter.filterPoliticalWords(maskedText);
        return maskedText;
    }
}
