package pers.muzi.pattern.proxy;

public interface PerformanceLog {
  String generateLog(String businessName, long startTime, long endTime);
}
