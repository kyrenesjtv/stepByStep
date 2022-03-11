package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.abstractfactory;

/**
 * @author huojianxiong
 * @Description JsonConfigParserFactory
 * @Date 2022/3/11 18:08
 */
public class XmlConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new PropertiesRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new PropertiesSystemConfigParser();
    }
}
