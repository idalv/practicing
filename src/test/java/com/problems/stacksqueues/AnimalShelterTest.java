package com.problems.stacksqueues;

import com.problems.stacksqueues.animalshelter.Animal;
import org.junit.Assert;
import org.junit.Test;
import com.problems.stacksqueues.animalshelter.DogAndCatQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/18/15
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimalShelterTest {
    @Test
    public void testShelter() {
        DogAndCatQueue queue = new DogAndCatQueue();
        queue.enqueue(Animal.CAT);
        queue.enqueue(Animal.CAT);
        queue.enqueue(Animal.DOG);
        queue.enqueue(Animal.CAT);
        queue.enqueue(Animal.DOG);
        queue.enqueue(Animal.CAT);

        Assert.assertEquals(Animal.CAT, queue.dequeueAny());
        Assert.assertEquals(Animal.DOG, queue.dequeueDog());
        Assert.assertEquals(Animal.CAT, queue.dequeueAny());
        Assert.assertEquals(Animal.CAT, queue.dequeueAny());
        Assert.assertEquals(Animal.CAT, queue.dequeCat());
        Assert.assertEquals(Animal.DOG, queue.dequeueAny());
    }
}
