package org.hahadeng.aps;

/**
 * @author 邓聪
 * @since 2025/8/27 17:32
 */

import org.apache.commons.math3.optim.*;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SteelProductionOptimizer {

    public static void main(String[] args) {
        // 问题参数
        final double BANDS_HOURLY_RATE = 200; // 吨/小时
        final double COILS_HOURLY_RATE = 140; // 吨/小时
        final double PLATE_HOURLY_RATE = 160; // 吨/小时

        final double BANDS_PROFIT = 25; // 元/吨
        final double COILS_PROFIT = 30; // 元/吨
        final double PLATE_PROFIT = 29; // 元/吨

        final double MAX_BANDS = 6000; // 吨
        final double MIN_BANDS = 1000; // 吨
        final double MAX_COILS = 4000; // 吨
        final double MIN_COILS = 500; // 吨
        final double MAX_PLATE = 3500; // 吨
        final double MIN_PLATE = 750; // 吨

        final double MAX_HOURS = 40; // 小时

        // 创建目标函数：最大化利润
        LinearObjectiveFunction objective = new LinearObjectiveFunction(
                new double[]{BANDS_PROFIT, COILS_PROFIT, PLATE_PROFIT},
                0
        );

        // 创建约束条件
        List<LinearConstraint> constraints = new ArrayList<>();

        // 1. 时间约束: x/200 + y/140 + z/160 <= 40
        constraints.add(new LinearConstraint(
                new double[]{1 / BANDS_HOURLY_RATE, 1 / COILS_HOURLY_RATE, 1 / PLATE_HOURLY_RATE},
                Relationship.LEQ,
                MAX_HOURS
        ));

        // 2. 生产量约束
        constraints.add(new LinearConstraint(new double[]{1, 0, 0}, Relationship.GEQ, MIN_BANDS)); // Bands下限
        constraints.add(new LinearConstraint(new double[]{1, 0, 0}, Relationship.LEQ, MAX_BANDS)); // Bands上限
        constraints.add(new LinearConstraint(new double[]{0, 1, 0}, Relationship.GEQ, MIN_COILS)); // Coils下限
        constraints.add(new LinearConstraint(new double[]{0, 1, 0}, Relationship.LEQ, MAX_COILS)); // Coils上限
        constraints.add(new LinearConstraint(new double[]{0, 0, 1}, Relationship.GEQ, MIN_PLATE)); // Plate下限
        constraints.add(new LinearConstraint(new double[]{0, 0, 1}, Relationship.LEQ, MAX_PLATE)); // Plate上限

        // 3. 非负约束
        constraints.add(new LinearConstraint(new double[]{1, 0, 0}, Relationship.GEQ, 0));
        constraints.add(new LinearConstraint(new double[]{0, 1, 0}, Relationship.GEQ, 0));
        constraints.add(new LinearConstraint(new double[]{0, 0, 1}, Relationship.GEQ, 0));

        // 创建优化问题
        LinearConstraintSet constraintSet = new LinearConstraintSet(constraints);
        PointValuePair solution = null;

        long startTime = System.nanoTime();

        try {
            // 使用线性规划求解
            solution = new SimplexSolver().optimize(
                    objective,
                    constraintSet,
                    GoalType.MAXIMIZE,
                    new NonNegativeConstraint(true)
            );
        } catch (Exception e) {
            System.err.println("优化过程中出错: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6; // 毫秒

        if (solution == null) {
            System.out.println("未找到可行解");
            return;
        }

        // 提取结果
        double[] point = solution.getPoint();
        double bands = point[0];
        double coils = point[1];
        double plate = point[2];
        double profit = solution.getValue();

        // 计算时间利用
        double timeUsed = (bands / BANDS_HOURLY_RATE) +
                (coils / COILS_HOURLY_RATE) +
                (plate / PLATE_HOURLY_RATE);

        // 格式化输出
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DecimalFormat intDf = new DecimalFormat("#,##0");

        System.out.println("=".repeat(60));
        System.out.println("钢铁厂生产优化结果");
        System.out.println("=".repeat(60));
        System.out.println("⚙️ 最优生产计划:");
        System.out.printf("- Bands: %s 吨 (%.2f%% 上限)\n",
                df.format(bands), bands / MAX_BANDS * 100);
        System.out.printf("- Coils: %s 吨 (%.2f%% 上限)\n",
                df.format(coils), coils / MAX_COILS * 100);
        System.out.printf("- Plate: %s 吨 (%.2f%% 上限)\n",
                df.format(plate), plate / MAX_PLATE * 100);

        System.out.println("\n⏱️ 资源利用:");
        System.out.printf("- 总生产时间: %.2f / %.0f 小时 (利用率: %.2f%%)\n",
                timeUsed, MAX_HOURS, timeUsed / MAX_HOURS * 100);
        System.out.printf("- Bands生产时间: %.2f 小时\n", bands / BANDS_HOURLY_RATE);
        System.out.printf("- Coils生产时间: %.2f 小时\n", coils / COILS_HOURLY_RATE);
        System.out.printf("- Plate生产时间: %.2f 小时\n", plate / PLATE_HOURLY_RATE);

        System.out.println("\n💰 经济效益:");
        System.out.printf("- 总利润: %s 元\n", intDf.format(profit));
        System.out.printf("- Bands贡献利润: %s 元\n", intDf.format(bands * BANDS_PROFIT));
        System.out.printf("- Coils贡献利润: %s 元\n", intDf.format(coils * COILS_PROFIT));
        System.out.printf("- Plate贡献利润: %s 元\n", intDf.format(plate * PLATE_PROFIT));
        System.out.printf("- 每小时平均利润: %.2f 元/小时\n", profit / timeUsed);

        System.out.println("\n✅ 约束检查:");
        System.out.println("- 时间约束: " + (timeUsed <= MAX_HOURS ? "满足" : "违反"));
        System.out.printf("- Bands生产量: %.0f ≤ %.0f ≤ %.0f: %s\n",
                MIN_BANDS, bands, MAX_BANDS,
                (bands >= MIN_BANDS && bands <= MAX_BANDS) ? "满足" : "违反");
        System.out.printf("- Coils生产量: %.0f ≤ %.0f ≤ %.0f: %s\n",
                MIN_COILS, coils, MAX_COILS,
                (coils >= MIN_COILS && coils <= MAX_COILS) ? "满足" : "违反");
        System.out.printf("- Plate生产量: %.0f ≤ %.0f ≤ %.0f: %s\n",
                MIN_PLATE, plate, MAX_PLATE,
                (plate >= MIN_PLATE && plate <= MAX_PLATE) ? "满足" : "违反");

        System.out.println("\n⏱️ 计算性能:");
        System.out.printf("- 优化耗时: %.4f 毫秒\n", duration);
        System.out.println("=".repeat(60));
    }
}
