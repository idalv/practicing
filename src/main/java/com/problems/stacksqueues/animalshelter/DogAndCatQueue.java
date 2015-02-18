package com.problems.stacksqueues.animalshelter;


import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/18/15
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DogAndCatQueue {
    LinkedList<Animal> list = new LinkedList<Animal>();

    public void enqueue(Animal a) {
        list.addLast(a);

    }

    public Animal dequeueAny() {
        return list.removeFirst();
    }

    public Animal dequeCat() {
        LinkedList<Animal> dogList = new LinkedList<Animal>();

        while (!list.isEmpty() && list.getFirst() != Animal.CAT) {
            dogList.addLast(list.removeFirst());
        }

        Animal animal = null;
        if (!list.isEmpty()) {
            animal = list.removeFirst();
        }
        dogList.addAll(list);
        list = dogList;
        return animal;
    }

    public Animal dequeueDog() {
        LinkedList<Animal> catList = new LinkedList<Animal>();

        while (!list.isEmpty() && list.getFirst() != Animal.DOG) {
            catList.addLast(list.removeFirst());
        }

        Animal animal = null;
        if (!list.isEmpty()) {
            animal = list.removeFirst();
        }
        catList.addAll(list);
        list = catList;
        return animal;
    }
}
