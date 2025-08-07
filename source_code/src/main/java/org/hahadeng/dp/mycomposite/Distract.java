package org.hahadeng.dp.mycomposite;

/**
 * 区
 *
 * @author 邓聪
 * @since 2025/6/4 17:38
 */
public class Distract implements PopulationNode {

    private final String name;

    private int population;

    public Distract(String name, int population) {
        this.name = name;
        this.population = population;
    }

    @Override
    public int computePopulation() {
        return population;
    }
}
