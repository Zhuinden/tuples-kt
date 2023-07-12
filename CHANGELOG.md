# Change log

-Tuples-kt 1.2.0 (2023-07-12)
--------------------------------

- Add more tuples from inclusive `Tuple17` to inclusive `Tuple36`. 

- Add `companion object` to every tuple in order to allow static extension functions over the `companion object` (similarly to Arrow-kt's tuples).

- Add `<out A, out B` and so on (`out`) to each generic constraint. While not reported, maybe it has some useful effect (similarly to both Arrow-kt's tuples and Kotlin's built-in tuples). 

- Add support for `operator fun <A : Comparable<A>, B : Comparable<B>> Tuple2<A, B>.compareTo(other: Tuple2<A, B>): Int {` and so on for each Tuple up to 36. (similarly to Arrow-kt's tuples, which only supports it up to 10).

- Add `TupleN<T, T, ..., T>.toList(): List<T>` support for all tuples, similarly to Kotlin built-in tuples.

- Add `Tuple0` (empty tuple), `Tuple1` (single arity tuple)

- Add `Tuple2` and `Tuple3` with `Tuple2.toPair()` and `Pair.toTuple2()`, and `Tuple3.toTriple()` and `Triple.toTuple3()` functions.

- Add `TupleN + value` operator fun to append new values to a pre-existing tuple (similarly to Arrow-kt's tuples).


-Tuples-kt 1.1.1 (2021-02-10)
--------------------------------

- Fix distribution issue renaming the kotlin META-INF/*.kotlin_module of the project to build.kotlin_module

-Tuples-kt 1.1.0 (2020-12-19)
--------------------------------

- Make library into pure JVM library (instead of just Android library).

This should have no effect beyond making tuples-kt compatible with more projects.

-Tuples-kt 1.0.0 (2020-03-23)
--------------------------------

- Initial Release.