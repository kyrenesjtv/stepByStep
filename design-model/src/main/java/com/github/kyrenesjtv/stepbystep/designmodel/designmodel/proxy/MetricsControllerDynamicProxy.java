package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author huojianxiong
 * @Description UserControllerDynamicProxy - 动态代理
 * @Date 2022/3/15 16:55
 */
public class MetricsControllerDynamicProxy {

    private MetricsCollector metricsCollector;

    public MetricsControllerDynamicProxy(MetricsCollector metricsCollector) {
        this.metricsCollector = metricsCollector;
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, dynamicProxyHandler);
    }

    private class DynamicProxyHandler implements InvocationHandler {

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(proxiedObject, args);
            metricsCollector.recordRequest();
            return result;
        }
    }
}
