package com.bagile.tms.config.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Aspect
public class TracingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass() );

    @Before("within(com.bagile.tms.services..*)")
    public void entering(JoinPoint joinPoint){
        logger.info("Executing -- : " + joinPoint.getStaticPart().getSignature().toString());
    }

    @After("within(com.bagile.tms.services..*)")
    public void exiting(JoinPoint joinPoint){
        logger.info("Finished -- : " + joinPoint.getStaticPart().getSignature().toString());
    }

    @Around("trackTime()")
    public Object track(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("tracking time for " + joinPoint.toString());
        return joinPoint.proceed();
    }

    @Pointcut("@annotation(com.bagile.tms.config.aspects.TrackTime)")
    public void trackTime(){}
}
