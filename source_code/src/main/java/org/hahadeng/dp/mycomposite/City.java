package org.hahadeng.dp.mycomposite;

import java.util.ArrayList;
import java.util.List;

/**
 * 城市
 *
 * @author 邓聪
 * @since 2025/6/4 17:37
 */
public class City implements PopulationNode {

    private final String name;

    List<Distract> distracts = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    void addDistract(Distract distract) {
        this.distracts.add(distract);
    }

    @Override
    public int computePopulation() {
        return distracts.stream().mapToInt(PopulationNode::computePopulation).sum();
    }
}
