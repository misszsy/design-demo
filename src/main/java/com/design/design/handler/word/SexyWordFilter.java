package com.design.design.handler.word;

public class SexyWordFilter implements SensitiveWordFilter {

    @Override
    public boolean doFilter(Content content) {
        boolean legal=true;
        return true;
    }


}
