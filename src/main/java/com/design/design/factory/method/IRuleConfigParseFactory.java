package com.design.design.factory.method;

import com.design.design.factory.IRuleConfigParser;

/**
 * 简单工厂方法模式的接口
 */
public interface IRuleConfigParseFactory {

    IRuleConfigParser createParser();
}
