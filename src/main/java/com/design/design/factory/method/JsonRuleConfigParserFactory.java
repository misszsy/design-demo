package com.design.design.factory.method;

import com.design.design.factory.IRuleConfigParser;
import com.design.design.factory.JsonRuleConfigParser;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class JsonRuleConfigParserFactory  implements IRuleConfigParseFactory {

    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
