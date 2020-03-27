package com.design.design.factory.method;


import com.design.design.factory.*;

public class RuleConfigSource02 {

    /**
     根据配置文件后缀，选择不同的解析器，讲存储在文件中
     配置解析成内存对象RuleConfig
     */
    public RuleConfig load(String ruleConfigFilePath){
        String ruleConfigFileExtension=getFileExtension(ruleConfigFilePath);
        //工厂类对象的创建逻辑又耦合进了 load() 函数中,需要重构，为工厂类在创建一个简单工厂，也就是工厂的工厂，消除if判断
        IRuleConfigParseFactory parseFactory=RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if(parseFactory==null){
            throw new InvalidRuleConfigException("sss");
        }
        IRuleConfigParser parser=parseFactory.createParser();
        String confingText="";
        RuleConfig ruleConfig=parser.parse(confingText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath){
        //...解析文件获取扩展名，比如rule.json,返回json
        return "json";
    }
}
