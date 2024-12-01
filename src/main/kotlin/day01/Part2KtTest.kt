import junit.framework.TestCase.assertEquals
import org.junit.Test

class Part2KtTest {

    @Test
    fun countOccurrencesTest() {
        val instance = 1
        val list = listOf(1, 1, 1, 1)
        val result = countOccurrences(instance, list)
        assertEquals(4, result)
    }

}