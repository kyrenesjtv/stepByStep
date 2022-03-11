package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.factorymethod;

/**
 * @author huojianxiong
 * @Description PropertiesRuleConfigParserFactory
 * @Date 2022/3/11 17:01
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
