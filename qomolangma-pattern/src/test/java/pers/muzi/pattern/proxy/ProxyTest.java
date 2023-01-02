package pers.muzi.pattern.proxy;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;

import pers.muzi.pattern.proxy.interface_.InterfaceProxy;
import pers.muzi.pattern.proxy.interface_.UserDAO;

public class ProxyTest {

  @Test
  public void testInterfaceProxy() {

    UserDAO userDAOProxy = (UserDAO) Proxy.newProxyInstance(
        UserDAO.class.getClassLoader(),
        new Class[]{UserDAO.class},
        new InterfaceProxy<>(UserDAO.class)
    );

    String name = userDAOProxy.selectNameById(1);
    Assert.assertEquals("代理接口方法：pers.muzi.pattern.proxy.interface_.UserDAO.selectNameById", name);
//    boolean equals = userDAOProxy.equals(new Object());
//    System.out.println(equals);
  }
}
