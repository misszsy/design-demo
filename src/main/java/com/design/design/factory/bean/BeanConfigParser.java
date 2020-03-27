package com.design.design.factory.bean;

import java.io.InputStream;
import java.util.List;

/**
 * 解析配置文件为BeanDefinition 结构
 */
public interface BeanConfigParser {

    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);
}
