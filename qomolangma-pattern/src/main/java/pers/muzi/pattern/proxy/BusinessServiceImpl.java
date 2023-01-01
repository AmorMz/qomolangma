package pers.muzi.pattern.proxy;

import java.util.concurrent.TimeUnit;

public class BusinessServiceImpl implements BusinessService {
  @Override
  public void foo() throws InterruptedException {
    System.out.println("...业务逻辑执行中");
    TimeUnit.SECONDS.sleep(1);
  }
}
