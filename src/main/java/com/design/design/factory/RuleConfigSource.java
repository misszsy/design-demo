package com.design.design.factory;


public class RuleConfigSource {

    /**
     根据配置文件后缀，选择不同的解析器，讲存储在文件中
     配置解析成内存对象RuleConfig
     */
    public RuleConfig load(String ruleConfigFilePath){
        String ruleConfigFileExtension=getFileExtension(ruleConfigFilePath);

        /*
          IRuleConfigParser parser=createParser(ruleConfigFileExtension); 未使用简单工厂模式时的是调用本类上的私有现将createParser()函数
          IRuleConfigParser parser= RuleConfigParserFactory01.createParser(ruleConfigFileExtension); 简单工厂模式调用方式
        */
        //这是使用了加入缓存后的简单工厂模式调用方式
        IRuleConfigParser parser= RuleConfigParserFactory02.createParser(ruleConfigFileExtension);
        if(parser==null){
            throw new InvalidRuleConfigException( "Rule config file format is not supported: " + ruleConfigFilePath);
        }
        String configText = "";
        RuleConfig ruleConfig=parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath){
        //...解析文件获取扩展名，比如rule.json,返回json
        return "json";
    }

    /*
        为了让类职责更加单一，代码更加清晰，
        现将createParser()函数剥离到一个独立的类中，让这个类只负责对象的创建
        这个类就是蒋丹工程模式类
    */
   /* private IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        return parser;
    }*/
}
