package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {

    @ParameterizedTest
    @CsvSource(
        value = ["1, 2"],
        delimiter = ','
    )
    fun `ADDITION Operator 테스트`(first: Double, second: Double) {
        val operation = Operator.ADDITION
        Assertions.assertThat(operation.operate(first, second)).isEqualTo(3.0)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["15, 5"],
        delimiter = ','
    )
    fun `SUBTRACTION Operator 테스트`(first: Double, second: Double) {
        val operation = Operator.SUBTRACTION
        Assertions.assertThat(operation.operate(first, second)).isEqualTo(10.0)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["3, 5"],
        delimiter = ','
    )
    fun `MULTIPLICATION Operator 테스트`(first: Double, second: Double) {
        val operation = Operator.MULTIPLICATION
        Assertions.assertThat(operation.operate(first, second)).isEqualTo(15.0)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["50, 5"],
        delimiter = ','
    )
    fun `DIVISION Operator 테스트`(first: Double, second: Double) {
        val operation = Operator.DIVISION
        Assertions.assertThat(operation.operate(first, second)).isEqualTo(10.0)
    }
}