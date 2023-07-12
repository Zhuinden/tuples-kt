package com.zhuinden.tupleskt

import java.io.Serializable

/*
 * Copyright 2020-2023 Gabor Varadi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
object Tuple0 : Serializable {
    operator fun invoke(): Tuple0 = this

    override fun toString(): String = "Tuple0[]"
}

fun <T> Tuple0.toList(): List<T> = emptyList<T>()

operator fun <A> Tuple0.plus(first: A): Tuple1<A> = Tuple1(first)

data class Tuple1<out A>(
        val first: A,
) : Serializable {
    override fun toString(): String {
        return "Tuple1[$first]"
    }

    companion object
}

fun <T> Tuple1<T>.toList(): List<T> = listOf(first)

operator fun <A, B> Tuple1<A>.plus(second: B): Tuple2<A, B> = Tuple2(first, second)

operator fun <A : Comparable<A>> Tuple1<A>.compareTo(other: Tuple1<A>): Int {
    return first.compareTo(other.first)
}

data class Tuple2<out A, out B>(
        val first: A,
        val second: B,
) : Serializable {
    override fun toString(): String {
        return "Tuple2[$first, $second]"
    }

    fun toPair(): Pair<A, B> = Pair(first, second)

    companion object
}

fun <A, B> Pair<A, B>.toTuple2(): Tuple2<A, B> = Tuple2(first, second)

fun <T> Tuple2<T, T>.toList(): List<T> = listOf(first, second)

operator fun <A, B, C> Tuple2<A, B>.plus(third: C): Tuple3<A, B, C> = Tuple3(first, second, third)

operator fun <A : Comparable<A>, B : Comparable<B>> Tuple2<A, B>.compareTo(other: Tuple2<A, B>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) second.compareTo(other.second)
    else first
}

data class Tuple3<out A, out B, out C>(
        val first: A,
        val second: B,
        val third: C,
) : Serializable {
    override fun toString(): String {
        return "Tuple3[$first, $second, $third]"
    }

    fun toTriple(): Triple<A, B, C> = Triple(first, second, third)

    companion object
}

fun <A, B, C> Triple<A, B, C>.toTuple3(): Tuple3<A, B, C> = Tuple3(first, second, third)

fun <T> Tuple3<T, T, T>.toList(): List<T> = listOf(first, second, third)

operator fun <A, B, C, D> Tuple3<A, B, C>.plus(fourth: D): Tuple4<A, B, C, D> = Tuple4(first, second, third, fourth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>> Tuple3<A, B, C>.compareTo(other: Tuple3<A, B, C>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) third.compareTo(other.third)
        else second
    } else first
}

data class Tuple4<out A, out B, out C, out D>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D
) : Serializable {
    override fun toString(): String {
        return "Tuple4[$first, $second, $third, $fourth]"
    }

    companion object
}

fun <T> Tuple4<T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth)

operator fun <A, B, C, D, E> Tuple4<A, B, C, D>.plus(fifth: E): Tuple5<A, B, C, D, E> = Tuple5(first, second, third, fourth, fifth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>> Tuple4<A, B, C, D>.compareTo(other: Tuple4<A, B, C, D>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) fourth.compareTo(other.fourth)
            else third
        } else second
    } else first
}

data class Tuple5<out A, out B, out C, out D, out E>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E
) : Serializable {
    override fun toString(): String {
        return "Tuple5[$first, $second, $third, $fourth, $fifth]"
    }

    companion object
}

fun <T> Tuple5<T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth)

operator fun <A, B, C, D, E, F> Tuple5<A, B, C, D, E>.plus(sixth: F): Tuple6<A, B, C, D, E, F> = Tuple6(first, second, third, fourth, fifth, sixth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>> Tuple5<A, B, C, D, E>.compareTo(other: Tuple5<A, B, C, D, E>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) fifth.compareTo(other.fifth)
                else fourth
            } else third
        } else second
    } else first
}

data class Tuple6<out A, out B, out C, out D, out E, out F>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F
) : Serializable {
    override fun toString(): String {
        return "Tuple6[$first, $second, $third, $fourth, $fifth, $sixth]"
    }

    companion object
}

fun <T> Tuple6<T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth)

operator fun <A, B, C, D, E, F, G> Tuple6<A, B, C, D, E, F>.plus(seventh: G): Tuple7<A, B, C, D, E, F, G> = Tuple7(first, second, third, fourth, fifth, sixth, seventh)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>> Tuple6<A, B, C, D, E, F>.compareTo(other: Tuple6<A, B, C, D, E, F>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) sixth.compareTo(other.sixth)
                    else fifth
                } else fourth
            } else third
        } else second
    } else first
}

data class Tuple7<out A, out B, out C, out D, out E, out F, out G>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G
) : Serializable {
    override fun toString(): String {
        return "Tuple7[$first, $second, $third, $fourth, $fifth, $sixth, $seventh]"
    }

    companion object
}

fun <T> Tuple7<T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh)

operator fun <A, B, C, D, E, F, G, H> Tuple7<A, B, C, D, E, F, G>.plus(eighth: H): Tuple8<A, B, C, D, E, F, G, H> = Tuple8(first, second, third, fourth, fifth, sixth, seventh, eighth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>> Tuple7<A, B, C, D, E, F, G>.compareTo(other: Tuple7<A, B, C, D, E, F, G>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) seventh.compareTo(other.seventh)
                        else sixth
                    } else fifth
                } else fourth
            } else third
        } else second
    } else first
}

data class Tuple8<out A, out B, out C, out D, out E, out F, out G, out H>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H
) : Serializable {
    override fun toString(): String {
        return "Tuple8[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth]"
    }

    companion object
}

fun <T> Tuple8<T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth)

operator fun <A, B, C, D, E, F, G, H, I> Tuple8<A, B, C, D, E, F, G, H>.plus(ninth: I): Tuple9<A, B, C, D, E, F, G, H, I> = Tuple9(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>> Tuple8<A, B, C, D, E, F, G, H>.compareTo(other: Tuple8<A, B, C, D, E, F, G, H>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) eighth.compareTo(other.eighth)
                            else seventh
                        } else sixth
                    } else fifth
                } else fourth
            } else third
        } else second
    } else first
}

data class Tuple9<out A, out B, out C, out D, out E, out F, out G, out H, out I>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I
) : Serializable {
    override fun toString(): String {
        return "Tuple9[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth]"
    }

    companion object
}

fun <T> Tuple9<T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth)

operator fun <A, B, C, D, E, F, G, H, I, J> Tuple9<A, B, C, D, E, F, G, H, I>.plus(tenth: J): Tuple10<A, B, C, D, E, F, G, H, I, J> = Tuple10(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>> Tuple9<A, B, C, D, E, F, G, H, I>.compareTo(other: Tuple9<A, B, C, D, E, F, G, H, I>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) ninth.compareTo(other.ninth)
                                else eighth
                            } else seventh
                        } else sixth
                    } else fifth
                } else fourth
            } else third
        } else second
    } else first
}

data class Tuple10<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J
) : Serializable {
    override fun toString(): String {
        return "Tuple10[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth]"
    }

    companion object
}

fun <T> Tuple10<T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth)

operator fun <A, B, C, D, E, F, G, H, I, J, K> Tuple10<A, B, C, D, E, F, G, H, I, J>.plus(eleventh: K): Tuple11<A, B, C, D, E, F, G, H, I, J, K> = Tuple11(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>> Tuple10<A, B, C, D, E, F, G, H, I, J>.compareTo(other: Tuple10<A, B, C, D, E, F, G, H, I, J>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) tenth.compareTo(other.tenth)
                                    else ninth
                                } else eighth
                            } else seventh
                        } else sixth
                    } else fifth
                } else fourth
            } else third
        } else second
    } else first
}

data class Tuple11<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K
) : Serializable {
    override fun toString(): String {
        return "Tuple11[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh]"
    }

    companion object
}

fun <T> Tuple11<T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L> Tuple11<A, B, C, D, E, F, G, H, I, J, K>.plus(twelfth: L): Tuple12<A, B, C, D, E, F, G, H, I, J, K, L> = Tuple12(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>> Tuple11<A, B, C, D, E, F, G, H, I, J, K>.compareTo(other: Tuple11<A, B, C, D, E, F, G, H, I, J, K>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            eleventh.compareTo(other.eleventh)
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple12<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L
) : Serializable {
    override fun toString(): String {
        return "Tuple12[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth]"
    }

    companion object
}

fun <T> Tuple12<T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M> Tuple12<A, B, C, D, E, F, G, H, I, J, K, L>.plus(thirteenth: M): Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M> = Tuple13(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>> Tuple12<A, B, C, D, E, F, G, H, I, J, K, L>.compareTo(other: Tuple12<A, B, C, D, E, F, G, H, I, J, K, L>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                twelfth.compareTo(other.twelfth)
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple13<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M
) : Serializable {
    override fun toString(): String {
        return "Tuple13[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth]"
    }

    companion object
}

fun <T> Tuple13<T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N> Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M>.plus(fourteenth: N): Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> = Tuple14(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>> Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M>.compareTo(other: Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    thirteenth.compareTo(other.thirteenth)
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple14<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N
) : Serializable {
    override fun toString(): String {
        return "Tuple14[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth]"
    }

    companion object
}

fun <T> Tuple14<T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>.plus(fifteenth: O): Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> = Tuple15(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>> Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>.compareTo(other: Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        fourteenth.compareTo(other.fourteenth)
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple15<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O
) : Serializable {
    override fun toString(): String {
        return "Tuple15[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth]"
    }

    companion object
}

fun <T> Tuple15<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>.plus(sixteenth: P): Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> = Tuple16(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>> Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>.compareTo(other: Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            fifteenth.compareTo(other.fifteenth)
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple16<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P
) : Serializable {
    override fun toString(): String {
        return "Tuple16[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth]"
    }

    companion object
}

fun <T> Tuple16<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>.plus(seventeenth: Q): Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> = Tuple17(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>> Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>.compareTo(other: Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                sixteenth.compareTo(other.sixteenth)
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple17<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
) : Serializable {
    override fun toString(): String {
        return "Tuple17[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth]"
    }

    companion object
}

fun <T> Tuple17<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>.plus(eighteenth: R): Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> = Tuple18(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>> Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>.compareTo(other: Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    seventeenth.compareTo(other.seventeenth)
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple18<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
) : Serializable {
    override fun toString(): String {
        return "Tuple18[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth]"
    }

    companion object
}

fun <T> Tuple18<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>.plus(nineteenth: S): Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> = Tuple19(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>> Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>.compareTo(other: Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        eighteenth.compareTo(other.eighteenth)
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple19<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
) : Serializable {
    override fun toString(): String {
        return "Tuple19[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth]"
    }

    companion object
}

fun <T> Tuple19<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>.plus(twentieth: T): Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> = Tuple20(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>> Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>.compareTo(other: Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            nineteenth.compareTo(other.nineteenth)
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple20<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
) : Serializable {
    override fun toString(): String {
        return "Tuple20[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth]"
    }

    companion object
}

fun <T> Tuple20<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>.plus(twentyFirst: U): Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> = Tuple21(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>> Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>.compareTo(other: Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                twentieth.compareTo(other.twentieth)
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple21<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
) : Serializable {
    override fun toString(): String {
        return "Tuple21[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst]"
    }

    companion object
}

fun <T> Tuple21<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>.plus(twentySecond: V): Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> = Tuple22(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>> Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>.compareTo(other: Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    twentyFirst.compareTo(other.twentyFirst)
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple22<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
) : Serializable {
    override fun toString(): String {
        return "Tuple22[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond]"
    }

    companion object
}

fun <T> Tuple22<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V>.plus(twentyThird: W): Tuple23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W> = Tuple23(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>> Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V>.compareTo(other: Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        twentySecond.compareTo(other.twentySecond)
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple23<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
) : Serializable {
    override fun toString(): String {
        return "Tuple23[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird]"
    }

    companion object
}

fun <T> Tuple23<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> Tuple23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W>.plus(twentyFourth: X): Tuple24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X> = Tuple24(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>> Tuple23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W>.compareTo(other: Tuple23<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            twentyThird.compareTo(other.twentyThird)
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple24<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
) : Serializable {
    override fun toString(): String {
        return "Tuple24[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth]"
    }

    companion object
}

fun <T> Tuple24<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> Tuple24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X>.plus(twentyFifth: Y): Tuple25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y> = Tuple25(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>> Tuple24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X>.compareTo(other: Tuple24<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                twentyFourth.compareTo(other.twentyFourth)
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple25<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
) : Serializable {
    override fun toString(): String {
        return "Tuple25[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth]"
    }

    companion object
}

fun <T> Tuple25<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> Tuple25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y>.plus(twentySixth: Z): Tuple26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z> = Tuple26(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>> Tuple25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y>.compareTo(other: Tuple25<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    twentyFifth.compareTo(other.twentyFifth)
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple26<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
) : Serializable {
    override fun toString(): String {
        return "Tuple26[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth]"
    }

    companion object
}

fun <T> Tuple26<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA> Tuple26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z>.plus(twentySeventh: AA): Tuple27<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA> = Tuple27(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>> Tuple26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z>.compareTo(other: Tuple26<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        twentySixth.compareTo(other.twentySixth)
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple27<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
) : Serializable {
    override fun toString(): String {
        return "Tuple27[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh]"
    }

    companion object
}

fun <T> Tuple27<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB> Tuple27<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA>.plus(twentyEighth: BB): Tuple28<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB> = Tuple28(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>> Tuple27<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA>.compareTo(other: Tuple27<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            twentySeventh.compareTo(other.twentySeventh)
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple28<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
) : Serializable {
    override fun toString(): String {
        return "Tuple28[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth]"
    }

    companion object
}

fun <T> Tuple28<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC> Tuple28<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB>.plus(twentyNinth: CC): Tuple29<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC> = Tuple29(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>> Tuple28<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB>.compareTo(other: Tuple28<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                twentyEighth.compareTo(other.twentyEighth)
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple29<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB, out CC>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
        val twentyNinth: CC,
) : Serializable {
    override fun toString(): String {
        return "Tuple29[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth, $twentyNinth]"
    }

    companion object
}

fun <T> Tuple29<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD> Tuple29<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC>.plus(thirtieth: DD): Tuple30<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD> = Tuple30(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>, CC : Comparable<CC>> Tuple29<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC>.compareTo(other: Tuple29<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                val twentyEighth = twentyEighth.compareTo(other.twentyEighth)
                                                                                                                if (twentyEighth == 0) {
                                                                                                                    twentyNinth.compareTo(other.twentyNinth)
                                                                                                                } else {
                                                                                                                    twentyEighth
                                                                                                                }
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}


data class Tuple30<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB, out CC, out DD>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
        val twentyNinth: CC,
        val thirtieth: DD,
) : Serializable {
    override fun toString(): String {
        return "Tuple30[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth, $twentyNinth, $thirtieth]"
    }

    companion object
}

fun <T> Tuple30<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE> Tuple30<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD>.plus(thirtyFirst: EE): Tuple31<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE> = Tuple31(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>, CC : Comparable<CC>, DD : Comparable<DD>> Tuple30<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD>.compareTo(other: Tuple30<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                val twentyEighth = twentyEighth.compareTo(other.twentyEighth)
                                                                                                                if (twentyEighth == 0) {
                                                                                                                    val twentyNinth = twentyNinth.compareTo(other.twentyNinth)
                                                                                                                    if (twentyNinth == 0) {
                                                                                                                        thirtieth.compareTo(other.thirtieth)
                                                                                                                    } else {
                                                                                                                        twentyNinth
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    twentyEighth
                                                                                                                }
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple31<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB, out CC, out DD, out EE>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
        val twentyNinth: CC,
        val thirtieth: DD,
        val thirtyFirst: EE,
) : Serializable {
    override fun toString(): String {
        return "Tuple31[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth, $twentyNinth, $thirtieth, $thirtyFirst]"
    }

    companion object
}

fun <T> Tuple31<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF> Tuple31<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE>.plus(thirtySecond: FF): Tuple32<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF> = Tuple32(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>, CC : Comparable<CC>, DD : Comparable<DD>, EE : Comparable<EE>> Tuple31<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE>.compareTo(other: Tuple31<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                val twentyEighth = twentyEighth.compareTo(other.twentyEighth)
                                                                                                                if (twentyEighth == 0) {
                                                                                                                    val twentyNinth = twentyNinth.compareTo(other.twentyNinth)
                                                                                                                    if (twentyNinth == 0) {
                                                                                                                        val thirtieth = thirtieth.compareTo(other.thirtieth)
                                                                                                                        if (thirtieth == 0) {
                                                                                                                            thirtyFirst.compareTo(other.thirtyFirst)
                                                                                                                        } else {
                                                                                                                            thirtieth
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        twentyNinth
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    twentyEighth
                                                                                                                }
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple32<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB, out CC, out DD, out EE, out FF>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
        val twentyNinth: CC,
        val thirtieth: DD,
        val thirtyFirst: EE,
        val thirtySecond: FF,
) : Serializable {
    override fun toString(): String {
        return "Tuple32[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth, $twentyNinth, $thirtieth, $thirtyFirst, $thirtySecond]"
    }

    companion object
}

fun <T> Tuple32<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG> Tuple32<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF>.plus(thirtyThird: GG): Tuple33<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG> = Tuple33(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond, thirtyThird)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>, CC : Comparable<CC>, DD : Comparable<DD>, EE : Comparable<EE>, FF : Comparable<FF>> Tuple32<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF>.compareTo(other: Tuple32<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                val twentyEighth = twentyEighth.compareTo(other.twentyEighth)
                                                                                                                if (twentyEighth == 0) {
                                                                                                                    val twentyNinth = twentyNinth.compareTo(other.twentyNinth)
                                                                                                                    if (twentyNinth == 0) {
                                                                                                                        val thirtieth = thirtieth.compareTo(other.thirtieth)
                                                                                                                        if (thirtieth == 0) {
                                                                                                                            val thirtyFirst = thirtyFirst.compareTo(other.thirtyFirst)
                                                                                                                            if (thirtyFirst == 0) {
                                                                                                                                thirtySecond.compareTo(other.thirtySecond)
                                                                                                                            } else {
                                                                                                                                thirtyFirst
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            thirtieth
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        twentyNinth
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    twentyEighth
                                                                                                                }
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple33<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB, out CC, out DD, out EE, out FF, out GG>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
        val twentyNinth: CC,
        val thirtieth: DD,
        val thirtyFirst: EE,
        val thirtySecond: FF,
        val thirtyThird: GG,
) : Serializable {
    override fun toString(): String {
        return "Tuple33[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth, $twentyNinth, $thirtieth, $thirtyFirst, $thirtySecond, $thirtyThird]"
    }

    companion object
}

fun <T> Tuple33<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond, thirtyThird)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH> Tuple33<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG>.plus(thirtyFourth: HH): Tuple34<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH> = Tuple34(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond, thirtyThird, thirtyFourth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>, CC : Comparable<CC>, DD : Comparable<DD>, EE : Comparable<EE>, FF : Comparable<FF>, GG : Comparable<GG>> Tuple33<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG>.compareTo(other: Tuple33<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                val twentyEighth = twentyEighth.compareTo(other.twentyEighth)
                                                                                                                if (twentyEighth == 0) {
                                                                                                                    val twentyNinth = twentyNinth.compareTo(other.twentyNinth)
                                                                                                                    if (twentyNinth == 0) {
                                                                                                                        val thirtieth = thirtieth.compareTo(other.thirtieth)
                                                                                                                        if (thirtieth == 0) {
                                                                                                                            val thirtyFirst = thirtyFirst.compareTo(other.thirtyFirst)
                                                                                                                            if (thirtyFirst == 0) {
                                                                                                                                val thirtySecond = thirtySecond.compareTo(other.thirtySecond)
                                                                                                                                if (thirtySecond == 0) {
                                                                                                                                    thirtyThird.compareTo(other.thirtyThird)
                                                                                                                                } else {
                                                                                                                                    thirtySecond
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                thirtyFirst
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            thirtieth
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        twentyNinth
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    twentyEighth
                                                                                                                }
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple34<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB, out CC, out DD, out EE, out FF, out GG, out HH>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
        val twentyNinth: CC,
        val thirtieth: DD,
        val thirtyFirst: EE,
        val thirtySecond: FF,
        val thirtyThird: GG,
        val thirtyFourth: HH,
) : Serializable {
    override fun toString(): String {
        return "Tuple34[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth, $twentyNinth, $thirtieth, $thirtyFirst, $thirtySecond, $thirtyThird, $thirtyFourth]"
    }

    companion object
}

fun <T> Tuple34<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond, thirtyThird, thirtyFourth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II> Tuple34<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH>.plus(thirtyFifth: II): Tuple35<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II> = Tuple35(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond, thirtyThird, thirtyFourth, thirtyFifth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>, CC : Comparable<CC>, DD : Comparable<DD>, EE : Comparable<EE>, FF : Comparable<FF>, GG : Comparable<GG>, HH : Comparable<HH>> Tuple34<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH>.compareTo(other: Tuple34<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                val twentyEighth = twentyEighth.compareTo(other.twentyEighth)
                                                                                                                if (twentyEighth == 0) {
                                                                                                                    val twentyNinth = twentyNinth.compareTo(other.twentyNinth)
                                                                                                                    if (twentyNinth == 0) {
                                                                                                                        val thirtieth = thirtieth.compareTo(other.thirtieth)
                                                                                                                        if (thirtieth == 0) {
                                                                                                                            val thirtyFirst = thirtyFirst.compareTo(other.thirtyFirst)
                                                                                                                            if (thirtyFirst == 0) {
                                                                                                                                val thirtySecond = thirtySecond.compareTo(other.thirtySecond)
                                                                                                                                if (thirtySecond == 0) {
                                                                                                                                    val thirtyThird = thirtyThird.compareTo(other.thirtyThird)
                                                                                                                                    if (thirtyThird == 0) {
                                                                                                                                        thirtyFourth.compareTo(other.thirtyFourth)
                                                                                                                                    } else {
                                                                                                                                        thirtyThird
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    thirtySecond
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                thirtyFirst
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            thirtieth
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        twentyNinth
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    twentyEighth
                                                                                                                }
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple35<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB, out CC, out DD, out EE, out FF, out GG, out HH, out II>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
        val twentyNinth: CC,
        val thirtieth: DD,
        val thirtyFirst: EE,
        val thirtySecond: FF,
        val thirtyThird: GG,
        val thirtyFourth: HH,
        val thirtyFifth: II,
) : Serializable {
    override fun toString(): String {
        return "Tuple35[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth, $twentyNinth, $thirtieth, $thirtyFirst, $thirtySecond, $thirtyThird, $thirtyFourth, $thirtyFifth]"
    }

    companion object
}

fun <T> Tuple35<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond, thirtyThird, thirtyFourth, thirtyFifth)

operator fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II, JJ> Tuple35<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II>.plus(thirtySixth: JJ): Tuple36<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II, JJ> = Tuple36(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond, thirtyThird, thirtyFourth, thirtyFifth, thirtySixth)

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>, CC : Comparable<CC>, DD : Comparable<DD>, EE : Comparable<EE>, FF : Comparable<FF>, GG : Comparable<GG>, HH : Comparable<HH>, II : Comparable<II>> Tuple35<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II>.compareTo(other: Tuple35<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                val twentyEighth = twentyEighth.compareTo(other.twentyEighth)
                                                                                                                if (twentyEighth == 0) {
                                                                                                                    val twentyNinth = twentyNinth.compareTo(other.twentyNinth)
                                                                                                                    if (twentyNinth == 0) {
                                                                                                                        val thirtieth = thirtieth.compareTo(other.thirtieth)
                                                                                                                        if (thirtieth == 0) {
                                                                                                                            val thirtyFirst = thirtyFirst.compareTo(other.thirtyFirst)
                                                                                                                            if (thirtyFirst == 0) {
                                                                                                                                val thirtySecond = thirtySecond.compareTo(other.thirtySecond)
                                                                                                                                if (thirtySecond == 0) {
                                                                                                                                    val thirtyThird = thirtyThird.compareTo(other.thirtyThird)
                                                                                                                                    if (thirtyThird == 0) {
                                                                                                                                        val thirtyFourth = thirtyFourth.compareTo(other.thirtyFourth)
                                                                                                                                        if (thirtyFourth == 0) {
                                                                                                                                            thirtyFifth.compareTo(other.thirtyFifth)
                                                                                                                                        } else {
                                                                                                                                            thirtyFourth
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        thirtyThird
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    thirtySecond
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                thirtyFirst
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            thirtieth
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        twentyNinth
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    twentyEighth
                                                                                                                }
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

data class Tuple36<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V, out W, out X, out Y, out Z, out AA, out BB, out CC, out DD, out EE, out FF, out GG, out HH, out II, out JJ>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D,
        val fifth: E,
        val sixth: F,
        val seventh: G,
        val eighth: H,
        val ninth: I,
        val tenth: J,
        val eleventh: K,
        val twelfth: L,
        val thirteenth: M,
        val fourteenth: N,
        val fifteenth: O,
        val sixteenth: P,
        val seventeenth: Q,
        val eighteenth: R,
        val nineteenth: S,
        val twentieth: T,
        val twentyFirst: U,
        val twentySecond: V,
        val twentyThird: W,
        val twentyFourth: X,
        val twentyFifth: Y,
        val twentySixth: Z,
        val twentySeventh: AA,
        val twentyEighth: BB,
        val twentyNinth: CC,
        val thirtieth: DD,
        val thirtyFirst: EE,
        val thirtySecond: FF,
        val thirtyThird: GG,
        val thirtyFourth: HH,
        val thirtyFifth: II,
        val thirtySixth: JJ,
) : Serializable {
    override fun toString(): String {
        return "Tuple36[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth, $tenth, $eleventh, $twelfth, $thirteenth, $fourteenth, $fifteenth, $sixteenth, $seventeenth, $eighteenth, $nineteenth, $twentieth, $twentyFirst, $twentySecond, $twentyThird, $twentyFourth, $twentyFifth, $twentySixth, $twentySeventh, $twentyEighth, $twentyNinth, $thirtieth, $thirtyFirst, $thirtySecond, $thirtyThird, $thirtyFourth, $thirtyFifth, $thirtySixth]"
    }

    companion object
}

fun <T> Tuple36<T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T>.toList(): List<T> = listOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth, thirteenth, fourteenth, fifteenth, sixteenth, seventeenth, eighteenth, nineteenth, twentieth, twentyFirst, twentySecond, twentyThird, twentyFourth, twentyFifth, twentySixth, twentySeventh, twentyEighth, twentyNinth, thirtieth, thirtyFirst, thirtySecond, thirtyThird, thirtyFourth, thirtyFifth, thirtySixth)

// there is no Tuple37 therefore this is not implemented.

operator fun <A : Comparable<A>, B : Comparable<B>, C : Comparable<C>, D : Comparable<D>, E : Comparable<E>, F : Comparable<F>, G : Comparable<G>, H : Comparable<H>, I : Comparable<I>, J : Comparable<J>, K : Comparable<K>, L : Comparable<L>, M : Comparable<M>, N : Comparable<N>, O : Comparable<O>, P : Comparable<P>, Q : Comparable<Q>, R : Comparable<R>, S : Comparable<S>, T : Comparable<T>, U : Comparable<U>, V : Comparable<V>, W : Comparable<W>, X : Comparable<X>, Y : Comparable<Y>, Z : Comparable<Z>, AA : Comparable<AA>, BB : Comparable<BB>, CC : Comparable<CC>, DD : Comparable<DD>, EE : Comparable<EE>, FF : Comparable<FF>, GG : Comparable<GG>, HH : Comparable<HH>, II : Comparable<II>, JJ : Comparable<JJ>> Tuple36<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II, JJ>.compareTo(other: Tuple36<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, BB, CC, DD, EE, FF, GG, HH, II, JJ>): Int {
    val first = first.compareTo(other.first)
    return if (first == 0) {
        val second = second.compareTo(other.second)
        if (second == 0) {
            val third = third.compareTo(other.third)
            if (third == 0) {
                val fourth = fourth.compareTo(other.fourth)
                if (fourth == 0) {
                    val fifth = fifth.compareTo(other.fifth)
                    if (fifth == 0) {
                        val sixth = sixth.compareTo(other.sixth)
                        if (sixth == 0) {
                            val seventh = seventh.compareTo(other.seventh)
                            if (seventh == 0) {
                                val eighth = eighth.compareTo(other.eighth)
                                if (eighth == 0) {
                                    val ninth = ninth.compareTo(other.ninth)
                                    if (ninth == 0) {
                                        val tenth = tenth.compareTo(other.tenth)
                                        if (tenth == 0) {
                                            val eleventh = eleventh.compareTo(other.eleventh)
                                            if (eleventh == 0) {
                                                val twelfth = twelfth.compareTo(other.twelfth)
                                                if (twelfth == 0) {
                                                    val thirteenth = thirteenth.compareTo(other.thirteenth)
                                                    if (thirteenth == 0) {
                                                        val fourteenth = fourteenth.compareTo(other.fourteenth)
                                                        if (fourteenth == 0) {
                                                            val fifteenth = fifteenth.compareTo(other.fifteenth)
                                                            if (fifteenth == 0) {
                                                                val sixteenth = sixteenth.compareTo(other.sixteenth)
                                                                if (sixteenth == 0) {
                                                                    val seventeenth = seventeenth.compareTo(other.seventeenth)
                                                                    if (seventeenth == 0) {
                                                                        val eighteenth = eighteenth.compareTo(other.eighteenth)
                                                                        if (eighteenth == 0) {
                                                                            val nineteenth = nineteenth.compareTo(other.nineteenth)
                                                                            if (nineteenth == 0) {
                                                                                val twentieth = twentieth.compareTo(other.twentieth)
                                                                                if (twentieth == 0) {
                                                                                    val twentyFirst = twentyFirst.compareTo(other.twentyFirst)
                                                                                    if (twentyFirst == 0) {
                                                                                        val twentySecond = twentySecond.compareTo(other.twentySecond)
                                                                                        if (twentySecond == 0) {
                                                                                            val twentyThird = twentyThird.compareTo(other.twentyThird)
                                                                                            if (twentyThird == 0) {
                                                                                                val twentyFourth = twentyFourth.compareTo(other.twentyFourth)
                                                                                                if (twentyFourth == 0) {
                                                                                                    val twentyFifth = twentyFifth.compareTo(other.twentyFifth)
                                                                                                    if (twentyFifth == 0) {
                                                                                                        val twentySixth = twentySixth.compareTo(other.twentySixth)
                                                                                                        if (twentySixth == 0) {
                                                                                                            val twentySeventh = twentySeventh.compareTo(other.twentySeventh)
                                                                                                            if (twentySeventh == 0) {
                                                                                                                val twentyEighth = twentyEighth.compareTo(other.twentyEighth)
                                                                                                                if (twentyEighth == 0) {
                                                                                                                    val twentyNinth = twentyNinth.compareTo(other.twentyNinth)
                                                                                                                    if (twentyNinth == 0) {
                                                                                                                        val thirtieth = thirtieth.compareTo(other.thirtieth)
                                                                                                                        if (thirtieth == 0) {
                                                                                                                            val thirtyFirst = thirtyFirst.compareTo(other.thirtyFirst)
                                                                                                                            if (thirtyFirst == 0) {
                                                                                                                                val thirtySecond = thirtySecond.compareTo(other.thirtySecond)
                                                                                                                                if (thirtySecond == 0) {
                                                                                                                                    val thirtyThird = thirtyThird.compareTo(other.thirtyThird)
                                                                                                                                    if (thirtyThird == 0) {
                                                                                                                                        val thirtyFourth = thirtyFourth.compareTo(other.thirtyFourth)
                                                                                                                                        if (thirtyFourth == 0) {
                                                                                                                                            val thirtyFifth = thirtyFifth.compareTo(other.thirtyFifth)
                                                                                                                                            if (thirtyFifth == 0) {
                                                                                                                                                thirtySixth.compareTo(other.thirtySixth)
                                                                                                                                            } else {
                                                                                                                                                thirtyFifth
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            thirtyFourth
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        thirtyThird
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    thirtySecond
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                thirtyFirst
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            thirtieth
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        twentyNinth
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    twentyEighth
                                                                                                                }
                                                                                                            } else {
                                                                                                                twentySeventh
                                                                                                            }
                                                                                                        } else {
                                                                                                            twentySixth
                                                                                                        }
                                                                                                    } else {
                                                                                                        twentyFifth
                                                                                                    }
                                                                                                } else {
                                                                                                    twentyFourth
                                                                                                }
                                                                                            } else {
                                                                                                twentyThird
                                                                                            }
                                                                                        } else {
                                                                                            twentySecond
                                                                                        }
                                                                                    } else {
                                                                                        twentyFirst
                                                                                    }
                                                                                } else {
                                                                                    twentieth
                                                                                }
                                                                            } else {
                                                                                nineteenth
                                                                            }
                                                                        } else {
                                                                            eighteenth
                                                                        }
                                                                    } else {
                                                                        seventeenth
                                                                    }
                                                                } else {
                                                                    sixteenth
                                                                }
                                                            } else {
                                                                fifteenth
                                                            }
                                                        } else {
                                                            fourteenth
                                                        }
                                                    } else {
                                                        thirteenth
                                                    }
                                                } else {
                                                    twelfth
                                                }
                                            } else {
                                                eleventh
                                            }
                                        } else {
                                            tenth
                                        }
                                    } else {
                                        ninth
                                    }
                                } else {
                                    eighth
                                }
                            } else {
                                seventh
                            }
                        } else {
                            sixth
                        }
                    } else {
                        fifth
                    }
                } else {
                    fourth
                }
            } else {
                third
            }
        } else {
            second
        }
    } else {
        first
    }
}

// if Tuple37 is added, make sure to add the Tuple36 => Tuple37 operator plus.