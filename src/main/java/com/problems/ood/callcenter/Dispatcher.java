package com.problems.ood.callcenter;

import com.problems.linkedlists.LinkedLists;

import java.awt.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/4/15
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dispatcher {
    private static Dispatcher instance;

    private Queue<Employee> respondents = new LinkedList<Employee>();

    private Dispatcher() {
    }

    public static Dispatcher getInstance() {
        if (instance == null) {
            instance = new Dispatcher();
        }

        return instance;
    }

    public void dispatchCall(Call call) {
        Employee employee = respondents.poll();
        employee.handleCall(call);
        respondents.add(employee);
    }

    public void addRespondent(Employee... employee) {
        for (Employee emp : employee) {
            respondents.add(emp);
        }
    }
}
