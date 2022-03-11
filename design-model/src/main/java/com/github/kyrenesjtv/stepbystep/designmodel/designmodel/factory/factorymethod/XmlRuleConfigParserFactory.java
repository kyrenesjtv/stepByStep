package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.factorymethod;

/**
 * @author huojianxiong
 * @Description XmlRuleConfigParserFactory
 * @Date 2022/3/11 17:02
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
