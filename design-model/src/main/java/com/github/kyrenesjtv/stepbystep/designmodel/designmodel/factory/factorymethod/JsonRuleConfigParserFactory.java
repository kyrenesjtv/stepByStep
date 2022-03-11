package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.factorymethod;

/**
 * @author huojianxiong
 * @Description JsonRuleConfigParserFactory
 * @Date 2022/3/11 17:00
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
