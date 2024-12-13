package org.hahadeng.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 邓聪
 */
public class Chooser<T> {
    private final List<T> choiceList;

    public Chooser(Collection<T> choiceList) {
        this.choiceList = new ArrayList<>(choiceList);
    }
    public T choose(){
        Random rdm = ThreadLocalRandom.current();
        return choiceList.get(rdm.nextInt(choiceList.size()));
    }
}
