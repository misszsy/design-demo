package com.design.design.factory.method;

import com.design.design.factory.IRuleConfigParser;
import com.design.design.factory.PropertiesRuleConfigParser;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParseFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
