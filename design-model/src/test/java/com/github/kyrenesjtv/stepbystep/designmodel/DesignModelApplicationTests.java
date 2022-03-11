package com.github.kyrenesjtv.stepbystep.designmodel;

import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.abstractfactory.IConfigParserFactory;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.abstractfactory.IConfigParserFactoryMap;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.abstractfactory.ISystemConfigParser;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.factorymethod.IRuleConfigParserFactory;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.factorymethod.IRuleConfigParserFactoryMap;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.simplefactory.IRuleConfigParser;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.simplefactory.RuleConfigParserFactory;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.simplefactory.RuleConfigParserFactoryMap;
import com.github.kyrenesjtv.stepbystep.designmodel.designmodel.singleton.enums.EnumTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DesignModelApplicationTests {

    @Test
    void contextLoads() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        Integer integer = integers.stream().max((o1, o2) -> o1 > o2 ? 1 : -1).orElse(0);
        System.out.println(integer);
    }

    @Test
    void testEnum() {
//        EnumClass instance = EnumClass.INSTANCE;
//        instance.doSomething();
//        EnumTest red = EnumTest.RED;
//        int id = red.getId();
//        System.out.println();

//        for (int i = 0; i < 10000; i++) {
//            new Thread(() -> {
//                int i1 = EnumClass.INSTANCE.doSomething();
//                System.out.println(i1);
//            }).start();
//        }
        int id1 = EnumTest.RED.getId();
//        EnumTest.RED.setId(2);
        int id2 = EnumTest.RED.getId();
        System.out.println(id1);
        System.out.println(id2);

    }

    @Test
    void simpleFactory() {
        IRuleConfigParser configParser = RuleConfigParserFactory.createParser("json");
        configParser.parser();

//        IRuleConfigParser configParser1 = RuleConfigParserFactoryMap.createParser("xxx");
        IRuleConfigParser configParser1 = RuleConfigParserFactoryMap.createParser("json");
        configParser1.parser();
        System.out.println(123);
    }

    @Test
    void factoryMethod() {
        IRuleConfigParserFactory ruleConfigParserFactory = IRuleConfigParserFactoryMap.createParser("json");
        com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.factorymethod.IRuleConfigParser parser = ruleConfigParserFactory.createParser();
        parser.parser();
    }

    @Test
    void abstractfactory() {
        IConfigParserFactory json = IConfigParserFactoryMap.createParser("json");
        com.github.kyrenesjtv.stepbystep.designmodel.designmodel.factory.abstractfactory.IRuleConfigParser ruleParser = json.createRuleParser();
        ISystemConfigParser systemParser = json.createSystemParser();
        ruleParser.parser();
        systemParser.parser();
    }
}
