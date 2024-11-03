package me.kpavlov.project

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class SampleTest {
    private val subject = Sample()

    @Mock
    lateinit var supplier: () -> String

    @Test
    fun `Should assert Hi`() {
        assertThat(subject.sayHi()).isEqualTo("Hi")
    }

    @Test
    fun `Should getResponseAsync`() =
        runTest {
            `when`(supplier.invoke()).thenReturn("Hello, World")
            assertThat(subject.getResponseAsync(supplier)).isEqualTo(
                "Hello, World",
            )
        }
}
