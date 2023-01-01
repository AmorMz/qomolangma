package pers.muzi.pattern.proxy;

public class PerformanceLogImpl implements PerformanceLog {
  @Override
  public String generateLog(String businessName, long startTime, long endTime) {
    return businessName + ",执行用时：" + (endTime - startTime) + "ms";
  }
}
