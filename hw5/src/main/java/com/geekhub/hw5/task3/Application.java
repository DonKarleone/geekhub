package com.geekhub.hw5.task3;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> testList = CollectionUtils.generate(() -> random.nextInt(2000) - 1000, ArrayList::new, 8);
        testList.add(440);
        testList.add(440);
        testList.add(-111);
        testList.add(-111);
        testList.add(440);

        System.out.println("Test list: " + testList);

        List<Integer> onlyPositive = CollectionUtils.filter(testList, e -> e >= 0);
        System.out.println("filter: Only positive: " + onlyPositive);

        boolean containsEven = CollectionUtils.anyMatch(testList, e -> e % 2 == 0);
        System.out.println("anyMatch: Contains even: " + containsEven);

        boolean isAllEven = CollectionUtils.allMatch(testList, e -> e % 2 == 0);
        System.out.println("allMatch: Is all even: " + isAllEven);

        boolean isNoneEven = CollectionUtils.noneMatch(testList, e -> e % 2 == 0);
        System.out.println("noneMatch: Is none even: " + isNoneEven);

        List<Long> doubledList = CollectionUtils.map(testList, e -> e * (long) 2, ArrayList::new);
        System.out.println("map: Doubled: " + doubledList);

        Optional<Integer> min = CollectionUtils.min(testList, Comparator.comparingInt(a -> a));
        System.out.println("min: " + min);

        Optional<Integer> max = CollectionUtils.max(testList, Comparator.comparingInt(a -> a));
        System.out.println("max: " + max);

        List<Integer> distinctList = CollectionUtils.distinct(testList, ArrayList::new);
        System.out.println("distinct: " + distinctList);

        System.out.println("forEach start:");
        CollectionUtils.forEach(testList, System.out::println);
        System.out.println("forEach end.");

        Optional<Integer> sumOpt = CollectionUtils.reduce(testList, (a, b) -> a + b);
        System.out.println("reduce(Optional): Sum all elements: " + sumOpt);

        int sum = CollectionUtils.reduce(1000000, testList, (a, b) -> a + b);
        System.out.println("reduce: Sum all elements with add parameter: " + sum);

        Map<Boolean, List<Integer>> partitionedBySign = CollectionUtils
                .partitionBy(testList, e -> e >= 0, HashMap::new, ArrayList::new);
        System.out.println("partitionBy: By sign: " + partitionedBySign);

        Map<Integer, List<Integer>> groupedByLastDigit = CollectionUtils
                .groupBy(testList, e -> Math.abs(e % 10), HashMap::new, ArrayList::new);
        System.out.println("groupBy: By last digit: " + groupedByLastDigit);

        Map<Integer, Integer> asMap = CollectionUtils
                .toMap(testList, e -> Math.abs(e % 10), e -> e / 10, Math::max, HashMap::new);
        System.out.println("toMap: Grouped by last digit, divided by 10 and choosed max: " + asMap);

        Map<Boolean, List<Long>> partitionedBySignAndDoubled = CollectionUtils
                .partitionByAndMapElement(testList, e -> e >= 0, HashMap::new,
                        ArrayList::new, e -> e * (long) 2);
        System.out.println("partitionByAndMapElement: Partitioned by sign and doubled: " + partitionedBySignAndDoubled);

        Map<Integer, List<Long>> groupedByLastDigitAndDoubled = CollectionUtils
                .groupByAndMapElement(testList, e -> Math.abs(e % 10), HashMap::new,
                        ArrayList::new, e -> e * (long) 2);
        System.out.println("groupByAndMapElement: Grouped by last digit and doubled: " + groupedByLastDigitAndDoubled);
    }
}
