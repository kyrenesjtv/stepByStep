package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.abstractfactory;


/**
 * @author huojianxiong
 * @Description IRuleConfigParser
 * @Date 2022/3/11 15:59
 */
public interface IConfigParserFactory {

    IRuleConfigParser createRuleParser();

    ISystemConfigParser createSystemParser();
    
}
