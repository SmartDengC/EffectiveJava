package org.hahadeng.aps;

import java.util.Random;

public class SteelFactoryGA {
    // 参数设置
    private static final int POP_SIZE = 100;
    private static final int MAX_GEN = 200;
    private static final double PC = 0.8;  // 交叉概率
    private static final double PM = 0.1;  // 变异概率

    // 变量边界
    private static final double X_MIN = 5.0;
    private static final double X_MAX = 30.0;
    private static final double Y_MIN = 500.0 / 140.0;   // 约3.5714
    private static final double Y_MAX = 4000.0 / 140.0;  // 约28.5714
    private static final double Z_MIN = 750.0 / 160.0;   // 4.6875
    private static final double Z_MAX = 3500.0 / 160.0;  // 21.875

    private static Random random = new Random();

    // 个体类
    static class Individual {
        double x, y, z;

        Individual(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        Individual copy() {
            return new Individual(x, y, z);
        }

        @Override
        public String toString() {
            return String.format("(%.2f, %.2f, %.2f)", x, y, z);
        }
    }

    // 适应度函数（利润计算）
    private static double fitness(Individual ind) {
        // 检查总时间约束
        if (ind.x + ind.y + ind.z > 40.0) {
            // 严重惩罚
            return -1e9;
        }
        // 计算利润
        return 5000 * ind.x + 4200 * ind.y + 4640 * ind.z;
    }

    // 初始化种群
    private static Individual[] initPopulation() {
        Individual[] population = new Individual[POP_SIZE];
        for (int i = 0; i < POP_SIZE; i++) {
            double x = X_MIN + random.nextDouble() * (X_MAX - X_MIN);
            double y = Y_MIN + random.nextDouble() * (Y_MAX - Y_MIN);
            double z = Z_MIN + random.nextDouble() * (Z_MAX - Z_MIN);
            population[i] = new Individual(x, y, z);
        }
        return population;
    }

    // 选择（轮盘赌）
    private static Individual[] select(Individual[] pop, double[] fits) {
        double totalFitness = 0;
        for (double fit : fits) {
            totalFitness += fit;
        }

        // 计算选择概率
        double[] probs = new double[POP_SIZE];
        for (int i = 0; i < POP_SIZE; i++) {
            probs[i] = fits[i] / totalFitness;
        }

        // 累积概率
        double[] cumProbs = new double[POP_SIZE];
        cumProbs[0] = probs[0];
        for (int i = 1; i < POP_SIZE; i++) {
            cumProbs[i] = cumProbs[i - 1] + probs[i];
        }

        Individual[] selected = new Individual[POP_SIZE];
        for (int i = 0; i < POP_SIZE; i++) {
            double r = random.nextDouble();
            int idx = 0;
            while (idx < POP_SIZE - 1 && r > cumProbs[idx]) {
                idx++;
            }
            selected[i] = pop[idx].copy();
        }
        return selected;
    }

    // 交叉（算术交叉）
    private static Individual[] crossover(Individual parent1, Individual parent2) {
        if (random.nextDouble() < PC) {
            double alpha = random.nextDouble();
            Individual child1 = new Individual(
                    alpha * parent1.x + (1 - alpha) * parent2.x,
                    alpha * parent1.y + (1 - alpha) * parent2.y,
                    alpha * parent1.z + (1 - alpha) * parent2.z
            );
            Individual child2 = new Individual(
                    alpha * parent2.x + (1 - alpha) * parent1.x,
                    alpha * parent2.y + (1 - alpha) * parent1.y,
                    alpha * parent2.z + (1 - alpha) * parent1.z
            );
            return new Individual[]{child1, child2};
        } else {
            return new Individual[]{parent1.copy(), parent2.copy()};
        }
    }

    // 变异（高斯扰动）
    private static Individual mutate(Individual individual) {
        if (random.nextDouble() < PM) {
            double x = individual.x + random.nextGaussian();
            double y = individual.y + random.nextGaussian();
            double z = individual.z + random.nextGaussian();

            // 确保在边界内
            x = Math.max(X_MIN, Math.min(X_MAX, x));
            y = Math.max(Y_MIN, Math.min(Y_MAX, y));
            z = Math.max(Z_MIN, Math.min(Z_MAX, z));

            return new Individual(x, y, z);
        } else {
            return individual.copy();
        }
    }

    // 主函数
    public static void main(String[] args) {
        Individual[] pop = initPopulation();
        double bestFitness = -Double.MAX_VALUE;
        Individual bestIndividual = null;

        for (int gen = 0; gen < MAX_GEN; gen++) {
            // 计算适应度
            double[] fits = new double[POP_SIZE];
            for (int i = 0; i < POP_SIZE; i++) {
                fits[i] = fitness(pop[i]);
            }

            // 更新最佳
            int maxIdx = 0;
            for (int i = 1; i < POP_SIZE; i++) {
                if (fits[i] > fits[maxIdx]) {
                    maxIdx = i;
                }
            }

            if (fits[maxIdx] > bestFitness) {
                bestFitness = fits[maxIdx];
                bestIndividual = pop[maxIdx].copy();
            }

            // 选择
            Individual[] selected = select(pop, fits);

            // 交叉
            Individual[] newPop = new Individual[POP_SIZE];
            int newPopIdx = 0;
            for (int i = 0; i < POP_SIZE; i += 2) {
                Individual parent1 = selected[i];
                Individual parent2 = (i + 1 < POP_SIZE) ? selected[i + 1] : selected[i];

                Individual[] children = crossover(parent1, parent2);
                newPop[newPopIdx++] = children[0];
                if (newPopIdx < POP_SIZE) {
                    newPop[newPopIdx++] = children[1];
                }
            }

            // 变异
            for (int i = 0; i < POP_SIZE; i++) {
                newPop[i] = mutate(newPop[i]);
            }

            pop = newPop;

            // 每50代输出进度
            if (gen % 50 == 0) {
                System.out.printf("Generation %d: Best fitness = %.2f%n", gen, bestFitness);
            }
        }

        // 输出最终结果
        if (bestIndividual != null) {
            double bandsOpt = 200 * bestIndividual.x;
            double coilsOpt = 140 * bestIndividual.y;
            double plateOpt = 160 * bestIndividual.z;
            double totalTime = bestIndividual.x + bestIndividual.y + bestIndividual.z;

            System.out.println("\n最优解：");
            System.out.printf("生产Bands的小时数: %.2f, 产量: %.2f 吨%n", bestIndividual.x, bandsOpt);
            System.out.printf("生产Coils的小时数: %.2f, 产量: %.2f 吨%n", bestIndividual.y, coilsOpt);
            System.out.printf("生产Plate的小时数: %.2f, 产量: %.2f 吨%n", bestIndividual.z, plateOpt);
            System.out.printf("总工作时间: %.2f 小时%n", totalTime);
            System.out.printf("最大利润: %.2f 元%n", bestFitness);

            System.out.println("\n因此，下周应生产：");
            System.out.printf("- Bands: %.2f 吨%n", bandsOpt);
            System.out.printf("- Coils: %.2f 吨%n", coilsOpt);
            System.out.printf("- Plate: %.2f 吨%n", plateOpt);
            System.out.printf("以实现最大利润 %.2f 元%n", bestFitness);
        } else {
            System.out.println("未找到最优解");
        }
    }
}
