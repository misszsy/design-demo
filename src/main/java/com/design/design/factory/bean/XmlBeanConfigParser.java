package com.design.design.factory.bean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class XmlBeanConfigParser implements BeanConfigParser {

    @Override
    public List<BeanDefinition> parse(InputStream in) {
        String content="";
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List<BeanDefinition> beanDefinitions=new ArrayList<>();
        return beanDefinitions;
    }
}
