package org.hahadeng.dp.mycomposite;

import java.util.ArrayList;
import java.util.List;

/**
 * 省
 *
 * @author 邓聪
 * @since 2025/6/4 17:49
 */
public class Province implements PopulationNode {

    private final String name;

    List<City> cities = new ArrayList<>();

    public Province(String name) {
        this.name = name;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    @Override
    public int computePopulation() {
        return cities.stream().mapToInt(City::computePopulation).sum();
    }
}
