package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.factorymethod;

/**
 * @author huojianxiong
 * @Description YamlRuleConfigParserFactory
 * @Date 2022/3/11 17:03
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
