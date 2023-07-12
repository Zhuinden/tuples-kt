# Tuples-KT

Tuples-KT contains tuples from 4 (`Tuple4`) to 16 (`Tuple16`) arity, to make up for that Kotlin only has `Pair` and `Triple`.

## Why?

Tuples are useful if you don't want to create a local type or class, as the name is "unnecessary" and we just want to combine a few values together without having to name the class. Works well in combination with decomposition.

``` kotlin
val (someValue, otherValue) = pair
val (someValue, otherValue, anotherValue) = triple
val (someValue, otherValue, anotherValue, thatValue) = tuple4
...
val (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z) = tuple26
...
```


## Using Tuples-KT

In order to use Tuples-KT, you need to add `jitpack` to your project root `build.gradle.kts`
(or `build.gradle`):

``` kotlin
// build.gradle.kts
allprojects {
    repositories {
        // ...
        maven { setUrl("https://jitpack.io") }
    }
    // ...
}
```

or

``` groovy
// build.gradle
allprojects {
    repositories {
        // ...
        maven { url "https://jitpack.io" }
    }
    // ...
}
```

In newer projects, you need to also update the `settings.gradle` file's `dependencyResolutionManagement` block:

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }  // <--
        jcenter() // Warning: this repository is going to shut down soon
    }
}
```


and then, add the dependency to your module's `build.gradle.kts` (or `build.gradle`):

``` kotlin
// build.gradle.kts
implementation("com.github.Zhuinden:tuples-kt:1.2.0")
```

or

``` groovy
// build.gradle
implementation 'com.github.Zhuinden:tuples-kt:1.2.0'
```

## License

    Copyright 2020-2023 Gabor Varadi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
