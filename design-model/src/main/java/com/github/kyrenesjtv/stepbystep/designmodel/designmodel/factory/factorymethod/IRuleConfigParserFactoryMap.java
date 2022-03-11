package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.factorymethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huojianxiong
 * @Description IRuleConfigParserFactoryMap
 * @Date 2022/3/11 17:04
 */
public class IRuleConfigParserFactoryMap {
    private static final Map<String, IRuleConfigParserFactory> RULE_MAP = new ConcurrentHashMap<>();

    static {
        RULE_MAP.put("json", new JsonRuleConfigParserFactory());
        RULE_MAP.put("properties", new PropertiesRuleConfigParserFactory());
        RULE_MAP.put("xml", new XmlRuleConfigParserFactory());
        RULE_MAP.put("yaml", new JsonRuleConfigParserFactory());
    }


    public static IRuleConfigParserFactory createParser(String configFormatter) {
        if (configFormatter == null && configFormatter.isEmpty()) {
            return null;
        }
        return RULE_MAP.get(configFormatter);
    }
}
