package com.problems.ood.callcenter;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/4/15
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Manager extends Employee {
    private Director director;

    public Manager(String name, Director director) {
        super(name);
        this.director = director;
    }

    @Override
    protected Employee getEscalationPerson() {
        return director;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected List<Call.Type> getTypesOfProblems() {
        return Arrays.asList(Call.Type.EASY, Call.Type.MEDIUM);
    }
}
