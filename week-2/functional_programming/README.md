# Functional Programming

| Functional Interface | Parameters | Return Type | Abstract Method |
| --- | :---: | :---: | :---: |
| Supplier<T> | 0 | T | get() |
| Consumer<T> | 1(T) | void | accept(T) |
| BiConsumer<T> | 2(T, U) | void | accept(T, U) |
| Predicate<T> | 1(T) | boolean | test(T) |
| BiPredicate<T, U> | 2(T, U) | boolean | test(T, U) |
| Function<T, R> | 1(T) | R | apply(T) |
| BiFunction<T, U, R> | 2(T, U) | R | apply(T, U) |
| UnaryOperator<T> | 1(T) | T | apply(T) |
| BinaryOperator<T> | 2(T, T) | T | apply(T) |