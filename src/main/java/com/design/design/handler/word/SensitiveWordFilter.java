package com.design.design.handler.word;

/**
 * 敏感词过滤方案
 */
public interface SensitiveWordFilter {

    boolean doFilter(Content content);
}
