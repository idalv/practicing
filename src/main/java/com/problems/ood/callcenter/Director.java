package com.problems.ood.callcenter;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/4/15
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class Director extends Employee {

    public Director(String name) {
        super(name);
    }

    @Override
    protected Employee getEscalationPerson() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected List<Call.Type> getTypesOfProblems() {
        return Arrays.asList(Call.Type.EASY, Call.Type.MEDIUM, Call.Type.HARD);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
