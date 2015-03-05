package com.problems.ood.callcenter;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 3/4/15
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class DispatcherTest {
    @Test
    public void testDispatchCall() {
        Director director = new Director("Tim Robbins");
        Manager manager1 = new Manager("Mel Gibson", director);
        Manager manager2 = new Manager("David Beckam", director);
        Respondent resp1 = new Respondent("Ivan Ivanov", manager1);
        Respondent resp2 = new Respondent("Petar Petrov", manager1);
        Respondent resp3 = new Respondent("Krasi Krasev", manager2);
        Respondent resp4 = new Respondent("Niki Nikolov", manager2);

        Dispatcher dispatcher = Dispatcher.getInstance();
        dispatcher.addRespondent(resp1, resp2, resp3, resp4);

        dispatcher.dispatchCall(new Call(Call.Type.EASY));
        dispatcher.dispatchCall(new Call(Call.Type.MEDIUM));
        dispatcher.dispatchCall(new Call(Call.Type.HARD));
    }
}
