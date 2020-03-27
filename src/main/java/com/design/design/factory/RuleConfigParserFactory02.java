package com.design.design.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 是加入缓存后的第二种实现简单工厂模式方式
 * 因为每次调用 RuleConfigParserFactory01 的 createParser() 的时候，都要创建一个新的 parser。
 * 实际上，如果 parser 可以复用，为了节省内存和对象创建的时间，我们可以将 parser
 * 事先创建好缓存起来。当调用 createParser() 函数的时候，我们从缓存中取出 parser 对象直接使用。
 *
 */
public class RuleConfigParserFactory02 {

    private static final Map<String,IRuleConfigParser> cacheParsers=new HashMap<>();

    static {
        cacheParsers.put("json",new JsonRuleConfigParser());
        cacheParsers.put("xml",new XmlRuleConfigParser());
        cacheParsers.put("yaml",new YamlRuleConfigParser());
        cacheParsers.put("properties",new PropertiesRuleConfigParser());
    }
    
    public static IRuleConfigParser createParser(String configFormat){
        if (configFormat == null || configFormat.isEmpty()) {
            //返回null还是IllegalArgumentException全凭你自己说了算
            return null;
        }
        IRuleConfigParser parser=cacheParsers.get(configFormat.toLowerCase());
        return parser;
    }
}
