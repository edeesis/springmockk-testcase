package com.edeesis.springmockktestcase

import com.ninjasquad.springmockk.MockkBean
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
class SomeBeanTest {

    @MockkBean
    private lateinit var someDependency: SomeDependency

    companion object {
        const val text = "Worked!"
    }

    @Test
    fun test() {
        val bean = SomeBean(someDependency)
        every { someDependency.someMethod() } returns text
        bean.someMethod()
        verify { someDependency.someMethod() }
        confirmVerified(someDependency)
    }
}