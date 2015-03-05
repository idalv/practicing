package com.problems.ood.callcenter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/4/15
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Employee {
    private boolean isAvailable = true;

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public final void handleCall(Call call) {
        if (isAvailable && canHandle(call)) {
            isAvailable = false;
            handle(call);
            isAvailable = true;
        } else {
            escalade(call);
        }
    }

    private void escalade(Call call) {
        getEscalationPerson().handleCall(call);
    }

    private boolean canHandle(Call call) {
        return getTypesOfProblems().contains(call.type);
    }

    protected abstract Employee getEscalationPerson();
    protected abstract List<Call.Type> getTypesOfProblems();
    protected void handle(Call call) {
        System.out.println("Handled by " + name);
    }
}
