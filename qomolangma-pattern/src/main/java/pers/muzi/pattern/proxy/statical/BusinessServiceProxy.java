package pers.muzi.pattern.proxy.statical;

import pers.muzi.pattern.proxy.BusinessService;
import pers.muzi.pattern.proxy.BusinessServiceImpl;
import pers.muzi.pattern.proxy.PerformanceLog;
import pers.muzi.pattern.proxy.PerformanceLogImpl;

public class BusinessServiceProxy implements BusinessService {

  private BusinessServiceImpl businessServiceImpl;

  public BusinessServiceProxy() {
    try {
      this.businessServiceImpl = (BusinessServiceImpl) Class.forName(
          "pers.muzi.pattern.proxy.BusinessServiceImpl"
      ).newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void foo() throws InterruptedException {
    long startTime = System.currentTimeMillis();
    this.businessServiceImpl.foo();
    long endTime = System.currentTimeMillis();

    PerformanceLog performanceLog = new PerformanceLogImpl();
    String log = performanceLog.generateLog("test", startTime, endTime);
    System.out.println(log);
    // log.info(log); 插入性能日志
  }

  public static void main(String[] args) throws InterruptedException {
    BusinessService businessService = new BusinessServiceProxy();
    businessService.foo();
  }
}
