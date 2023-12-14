package tn.esprit.tp1yassinejallouli4twin7.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* tn.esprit.tp1yassinejallouli4twin7.services.IMPL.*.get*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.error("In method " + name + " : ");
    }
//"execution(Modifiers-pattern? Ret-type-pattern Declaring-type-pattern?Name-
//pattern(param-pattern) Throws-pattern?)"
    //"execution(*.* tn.esprit.tp1yassinejallouli4twin7.services.IMPL.*.*(..)) "
    @After(" execution(* tn.esprit.tp1yassinejallouli4twin7.services.IMPL.*.sett*(..)) ")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.warn("Out of method " + name + " : ");
    }

}
