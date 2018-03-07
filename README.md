# JavaRushTasks
JavaRushTasks 2.0

# examples

```java
Map<Integer, Long> map = list.stream().collect(groupingBy(Integer::new, counting()));
Optional<Long> answer = map.keySet().stream().map(key -> map.get(key)).max(Comparator.comparing(value -> value));
```

