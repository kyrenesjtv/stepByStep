package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.simplefactory;

/**
 * @author huojianxiong
 * @Description RuleConfigParserFactory - 简单工厂
 * @Date 2022/3/11 16:00
 */
public class RuleConfigParserFactory {

    public static IRuleConfigParser createParser(String configFormatter) {
        IRuleConfigParser ruleConfigParser = null;
        if ("json".equalsIgnoreCase(configFormatter)) {
            ruleConfigParser = new JsonRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(configFormatter)) {
            ruleConfigParser = new PropertiesRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(configFormatter)) {
            ruleConfigParser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(configFormatter)) {
            ruleConfigParser = new YamlRuleConfigParser();
        }
        return ruleConfigParser;
    }
}
