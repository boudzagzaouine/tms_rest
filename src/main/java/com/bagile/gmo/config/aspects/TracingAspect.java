package com.bagile.gmo.config.aspects;

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

    @Before("within(com.bagile.gmo.services..*)")
    public void entering(JoinPoint joinPoint){
        logger.info("Executing -- : " + joinPoint.getStaticPart().getSignature().toString());
    }

    @After("within(com.bagile.gmo.services..*)")
    public void exiting(JoinPoint joinPoint){
        logger.info("Finished -- : " + joinPoint.getStaticPart().getSignature().toString());
    }

    @Around("trackTime()")
    public Object track(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("tracking time for " + joinPoint.toString());
        return joinPoint.proceed();
    }

    @Pointcut("@annotation(com.bagile.gmo.config.aspects.TrackTime)")
    public void trackTime(){}
}
