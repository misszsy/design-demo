package com.design.design.factory.method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zsy
 * @version 1.1  controller
 * @date
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String,IRuleConfigParseFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParseFactory getParserFactory(String type){
        if(type==null || type.isEmpty()){
            return null;
        }
        IRuleConfigParseFactory parseFactory=cachedFactories.get(type);
        return parseFactory;
    }
}
