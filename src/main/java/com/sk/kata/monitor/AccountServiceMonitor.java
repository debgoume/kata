package com.sk.kata.monitor;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

/**
 * Created by Samba Kamara on 21/11/2017.
 */


@Service
@ManagedResource(objectName = "com.sk.kata.service.monitor:name=AccountService", description = "monitor AccountService methods")
public class AccountServiceMonitor {

    //deposit method monitoring attributes
    private boolean depositAccess = true;
    private long depositHitCount;
    private long depositPerformanceTrace;
    private long depositTotalPerformanceTrace;

    //withdraw method monitoring attributes
    private boolean withdrawAccess = true;
    private long withdrawHitCount;
    private long withdrawPerformanceTrace;
    private long withdrawTotalPerformanceTrace;

    //history method monitoring attributes
    private boolean historyAccess = true;
    private long historyHitCount;
    private long historyPerformanceTrace;
    private long historyTotalPerformanceTrace;


    @ManagedAttribute(description = "is service depositAccess" )
    public boolean isDepositAccess() {
        return depositAccess;
    }

    @ManagedAttribute
    public void setDepositAccess(boolean depositAccess) {
        this.depositAccess = depositAccess;
    }

    @ManagedAttribute(description = "number of hits" )
    public long getDepositHitCount() {
        return depositHitCount;
    }

    @ManagedAttribute
    public void setDepositHitCount(long depositHitCount) {
        this.depositHitCount = depositHitCount;
    }

    @ManagedAttribute
    public long getDepositPerformanceTrace() {
        return depositPerformanceTrace;
    }

    @ManagedAttribute
    public void setDepositPerformanceTrace(long depositPerformanceTrace) {
        this.depositPerformanceTrace = depositPerformanceTrace;
    }

    @ManagedAttribute
    public void setDepositTotalPerformanceTrace(long depositTotalPerformanceTrace) {
        this.depositTotalPerformanceTrace = depositTotalPerformanceTrace;
    }

    @ManagedAttribute
    public long getDepositTotalPerformanceTrace() {
        return depositTotalPerformanceTrace;
    }

    @ManagedAttribute
    public boolean isWithdrawAccess() {
        return withdrawAccess;
    }

    @ManagedAttribute
    public void setWithdrawAccess(boolean withdrawAccess) {
        this.withdrawAccess = withdrawAccess;
    }

    @ManagedAttribute
    public long getWithdrawHitCount() {
        return withdrawHitCount;
    }

    @ManagedAttribute
    public void setWithdrawHitCount(long withdrawHitCount) {
        this.withdrawHitCount = withdrawHitCount;
    }

    @ManagedAttribute
    public long getWithdrawPerformanceTrace() {
        return withdrawPerformanceTrace;
    }

    @ManagedAttribute
    public void setWithdrawPerformanceTrace(long withdrawPerformanceTrace) {
        this.withdrawPerformanceTrace = withdrawPerformanceTrace;
    }

    @ManagedAttribute
    public long getWithdrawTotalPerformanceTrace() {
        return withdrawTotalPerformanceTrace;
    }

    @ManagedAttribute
    public void setWithdrawTotalPerformanceTrace(long withdrawTotalPerformanceTrace) {
        this.withdrawTotalPerformanceTrace = withdrawTotalPerformanceTrace;
    }

    @ManagedAttribute
    public boolean isHistoryAccess() {
        return historyAccess;
    }

    @ManagedAttribute
    public void setHistoryAccess(boolean historyAccess) {
        this.historyAccess = historyAccess;
    }

    @ManagedAttribute
    public long getHistoryHitCount() {
        return historyHitCount;
    }

    @ManagedAttribute
    public void setHistoryHitCount(long historyHitCount) {
        this.historyHitCount = historyHitCount;
    }

    @ManagedAttribute
    public long getHistoryPerformanceTrace() {
        return historyPerformanceTrace;
    }

    @ManagedAttribute
    public void setHistoryPerformanceTrace(long historyPerformanceTrace) {
        this.historyPerformanceTrace = historyPerformanceTrace;
    }

    @ManagedAttribute
    public long getHistoryTotalPerformanceTrace() {
        return historyTotalPerformanceTrace;
    }

    @ManagedAttribute
    public void setHistoryTotalPerformanceTrace(long historyTotalPerformanceTrace) {
        this.historyTotalPerformanceTrace = historyTotalPerformanceTrace;
    }
}

