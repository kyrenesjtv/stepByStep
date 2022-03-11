package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.simplefactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huojianxiong
 * @Description RuleConfigParserFactory - 简单工厂
 * @Date 2022/3/11 16:00
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, IRuleConfigParser> RULE_MAP = new ConcurrentHashMap<>();

    static {
        RULE_MAP.put("json", new JsonRuleConfigParser());
        RULE_MAP.put("properties", new PropertiesRuleConfigParser());
        RULE_MAP.put("xml", new XmlRuleConfigParser());
        RULE_MAP.put("yaml", new YamlRuleConfigParser());
    }


    public static IRuleConfigParser createParser(String configFormatter) {
        if (configFormatter == null && configFormatter.isEmpty()) {
            return null;
        }
        return RULE_MAP.get(configFormatter);
    }
}
