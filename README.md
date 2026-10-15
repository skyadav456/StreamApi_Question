## Question 1: Find Duplicate Elements in a List

**Description:** Extract duplicate elements from a list using Stream API and HashSet.

**Solution:**
```java
List<String> names = Arrays.asList(
        "Rahul", "Amit", "Priya", "Rahul",
        "Amit", "Neha", "Vikas", "Priya"
);

Set<String> nameset = new HashSet<>();
Set<String> duplicateElement = names.stream()
        .filter(e -> !nameset.add(e))
        .collect(Collectors.toSet());

System.out.println("Duplicate elements: " + duplicateElement);
```

**Output:** `[Rahul, Amit, Priya]`

**Approach:** Use `HashSet.add()` which returns `false` for duplicates. Filter elements where `add()` returns `false` and collect them into a Set.

---

## Question 2: Find Elements That Occur Only Once

**Description:** Extract elements from a list that appear exactly once using `groupingBy()` and `counting()`.

**Solution:**
```java
List<String> names = Arrays.asList(
        "Rahul", "Amit", "Priya", "Rahul",
        "Amit", "Neha", "Vikas", "Priya"
);

Set<String> singleOccurrence = names.stream()
        .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
        .entrySet().stream()
        .filter(entry -> entry.getValue() == 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());

System.out.println("Single occurrence: " + singleOccurrence);
```

**Output:** `[Neha, Vikas]`

**Approach:** Group elements by their frequency using `groupingBy()`. Filter entries where count equals 1, extract the keys, and collect into a Set.

---

## Question 3: Count the Frequency of Every Element Using groupingBy()

**Description:** Count how many times each element appears in a list and return as a Map.

**Solution:**
```java
List<String> names = Arrays.asList(
        "Rahul", "Amit", "Priya", "Rahul",
        "Amit", "Neha", "Vikas", "Priya"
);

Map<String, Long> frequency = names.stream()
        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

System.out.println("Frequency: " + frequency);
```

**Output:** `{Rahul=2, Amit=2, Priya=2, Neha=1, Vikas=1}`

**Approach:** Use `groupingBy()` with `counting()` to group elements and count their occurrences. Returns a Map with elements as keys and their frequencies as values.

---

## Question 4: Find the First Non-Repeating Character in a String

**Description:** Find the first character that appears only once in a string using Stream API.

**Solution:**
```java
String s = "sharad";
Character character = s.chars()
        .mapToObj(c -> (char)c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()
        ))
        .entrySet().stream()
        .filter(entry -> entry.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse(null);

System.out.println("First non-repeating character: " + character);
```

**Output:** `h`

**Approach:** Convert string to character stream, group with `LinkedHashMap` to maintain insertion order, filter characters with count 1, use `findFirst()` to get the first non-repeating character.

---

## Question 5: Find the First Repeating Character in a String

**Description:** Find the first character that appears more than once in a string using Stream API.

**Solution:**
```java
String s = "sharad";
Character character = s.chars()
        .mapToObj(c -> (char)c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()
        ))
        .entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse(null);

System.out.println("First repeating character: " + character);
```

**Output:** `a`

**Approach:** Convert string to character stream, group with `LinkedHashMap` to maintain insertion order, filter characters with count > 1, use `findFirst()` to get the first repeating character.

---

## Question 6: Count the Frequency of Each Character in a String

**Description:** Count how many times each character appears in a string and return as a Map.

**Solution:**
```java
String str = "allahabad";
Map<Character, Long> charCounting = str.chars()
        .mapToObj(c -> (char)c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()
        ));

System.out.println("Character frequency: " + charCounting);
```

**Output:** `{a=4, l=2, h=1, b=1, d=1}`

**Approach:** Convert string to character stream, group using `LinkedHashMap` to preserve insertion order, count occurrences with `Collectors.counting()`. Returns a Map with characters as keys and their frequencies as values.

---

## Question 7: Find Duplicate Characters in a String

**Description:** Extract characters that appear more than once in a string.

**Solution:**
```java
String str = "allahabad";
Set<Character> duplicateChar = str.chars()
        .mapToObj(c -> (char)c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ))
        .entrySet().stream()
        .filter(entry -> entry.getValue() > 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());

System.out.println("Duplicate characters: " + duplicateChar);
```

**Output:** `[a, l]`

**Approach:** Convert string to character stream, group characters and count occurrences, filter entries where count > 1, extract character keys, and collect into a Set.

---
