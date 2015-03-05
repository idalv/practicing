package com.problems.ood.callcenter;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/4/15
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Respondent extends Employee {
    private Manager manager;

    public Respondent(String name, Manager manager) {
        super(name);
        this.manager = manager;
    }

    @Override
    protected Employee getEscalationPerson() {
        return manager;
    }

    @Override
    protected List<Call.Type> getTypesOfProblems() {
        return Arrays.asList(Call.Type.EASY);
    }
}
