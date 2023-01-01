package pers.muzi.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import pers.muzi.pattern.proxy.BusinessService;
import pers.muzi.pattern.proxy.BusinessServiceImpl;
import pers.muzi.pattern.proxy.PerformanceLog;
import pers.muzi.pattern.proxy.PerformanceLogImpl;

public class DynamicProxy {

  public static void main(String[] args) throws InterruptedException {
    BusinessService businessService = (BusinessService) Proxy.newProxyInstance(
        BusinessServiceImpl.class.getClassLoader(),
        BusinessServiceImpl.class.getInterfaces(),
        new DynamicProxyHandler(new BusinessServiceImpl())
    );

    businessService.foo();
  }


  static class DynamicProxyHandler implements InvocationHandler {

    // 被代理对象
    private Object subject;

    public DynamicProxyHandler(Object subject) {
      this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      long startTime = System.currentTimeMillis();
      Object result = method.invoke(subject, args);
      long endTime = System.currentTimeMillis();

      PerformanceLog performanceLog = new PerformanceLogImpl();
      String log = performanceLog.generateLog("test", startTime, endTime);
      System.out.println(log);
      // log.info(log); 插入性能日志
      return result;
    }
  }
}
