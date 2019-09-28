package com.edeesis.springmockktestcase

class SomeBean(
    private val someDependency: SomeDependency
) {
    fun someMethod(): String {
        return someDependency.someMethod()
    }
}