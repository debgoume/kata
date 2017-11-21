package com.sk.kata.aspect;

import com.sk.kata.exception.AccessForbiddenException;
import com.sk.kata.monitor.AccountServiceMonitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by Samba Kamara on 21/11/2017.
 */

@Aspect
@Component
public class AccountServiceAspect {

    @Autowired
    private AccountServiceMonitor accountServiceMonitor;

    @Pointcut("execution(* com.sk.kata.service.AccountServiceImpl.deposit(..))")
    public void deposit() {

    }

    @Pointcut("execution(* com.sk.kata.service.AccountServiceImpl.withdraw(..))")
    public void withdraw() {

    }

    @Pointcut("execution(* com.sk.kata.service.AccountServiceImpl.history(..))")
    public void history() {

    }

    @After("deposit()")
    public void depositHitCount () throws Throwable {
        accountServiceMonitor.setDepositHitCount(accountServiceMonitor.getDepositHitCount() + 1);
    }

    @Around("deposit()")
    public Object depositCountPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if(!accountServiceMonitor.isDepositAccess()){
            throw new AccessForbiddenException(HttpStatus.FORBIDDEN.toString());
        }

        long start = System.currentTimeMillis();
        Object output = proceedingJoinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        accountServiceMonitor.setDepositPerformanceTrace(elapsedTime);

        accountServiceMonitor.setDepositTotalPerformanceTrace(accountServiceMonitor.getDepositTotalPerformanceTrace() + accountServiceMonitor.getDepositPerformanceTrace());

        return output;
    }

    @After("withdraw()")
    public void withdrawHitCount () throws Throwable {
        accountServiceMonitor.setWithdrawHitCount(accountServiceMonitor.getWithdrawHitCount() + 1);
    }

    @Around("deposit()")
    public Object withdrawCountPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if(!accountServiceMonitor.isWithdrawAccess()){
            throw new AccessForbiddenException(HttpStatus.FORBIDDEN.toString());
        }

        long start = System.currentTimeMillis();
        Object output = proceedingJoinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        accountServiceMonitor.setWithdrawPerformanceTrace(elapsedTime);

        accountServiceMonitor.setWithdrawTotalPerformanceTrace(accountServiceMonitor.getWithdrawTotalPerformanceTrace() + accountServiceMonitor.getWithdrawPerformanceTrace());

        return output;
    }

    @After("history()")
    public void historyHitCount () throws Throwable {
        accountServiceMonitor.setHistoryHitCount(accountServiceMonitor.getHistoryHitCount() + 1);
    }

    @Around("history()")
    public Object historyCountPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if(!accountServiceMonitor.isHistoryAccess()){
            throw new AccessForbiddenException(HttpStatus.FORBIDDEN.toString());
        }

        long start = System.currentTimeMillis();
        Object output = proceedingJoinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        accountServiceMonitor.setHistoryPerformanceTrace(elapsedTime);

        accountServiceMonitor.setHistoryTotalPerformanceTrace(accountServiceMonitor.getHistoryTotalPerformanceTrace() + accountServiceMonitor.getHistoryPerformanceTrace());

        return output;
    }

}

