package com.example.sacmworkshop.service.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Logging aspect.
 */
@Aspect
@Component
@Slf4j
public class LoggingAspect {

  @Before("within(com.example.sacmworkshop..*)")
  public void apply(JoinPoint jp) {
    log.info("{}.{} was executed with argument(s): {}",
        jp.getSignature().getDeclaringTypeName(),
        jp.getSignature().getName(),
        jp.getArgs());
  }
}
