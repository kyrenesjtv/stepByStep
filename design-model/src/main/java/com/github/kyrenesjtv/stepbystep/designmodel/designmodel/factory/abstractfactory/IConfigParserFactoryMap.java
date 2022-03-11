package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.abstractfactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huojianxiong
 * @Description IRuleConfigParser
 * @Date 2022/3/11 15:59
 */
public class IConfigParserFactoryMap {

    private static final Map<String, IConfigParserFactory> RULE_MAP = new ConcurrentHashMap<>();

    static {
        RULE_MAP.put("json", new JsonConfigParserFactory());
        RULE_MAP.put("properties", new PropertiesConfigParserFactory());
        RULE_MAP.put("xml", new XmlConfigParserFactory());
        RULE_MAP.put("yaml", new YamlConfigParserFactory());
    }


    public static IConfigParserFactory createParser(String configFormatter) {
        if (configFormatter == null && configFormatter.isEmpty()) {
            return null;
        }
        return RULE_MAP.get(configFormatter);
    }

}
