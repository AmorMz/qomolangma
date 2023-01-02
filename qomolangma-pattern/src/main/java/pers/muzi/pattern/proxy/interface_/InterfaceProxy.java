package pers.muzi.pattern.proxy.interface_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 对接口代理，是为了最大程度屏蔽复杂操作
 * 例如Mybatis框架的DAO接口，通过用户定义好的规范（接口）
 * 框架将自动的完成jdbc的一系列复杂操作
 * @param <T> 接口类型
 */
public class InterfaceProxy<T> implements InvocationHandler {

  // 记录当前代理接口的类型
  private final Class<T> mapperClass;

  public InterfaceProxy(Class<T> mapperClass) {
    this.mapperClass = mapperClass;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (Object.class.equals(method.getDeclaringClass())) {
      return method.invoke(this, args);
    }

    return "代理接口方法：" + mapperClass.getName() + "." + method.getName();
  }
}
