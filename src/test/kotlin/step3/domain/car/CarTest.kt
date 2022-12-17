package step3.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import step3.domain.car.action.MovingStrategy
import step3.domain.car.status.Position

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @DisplayName("Car 생성 테스트")
    @Test
    fun `Car 생성 테스트`() {
        assertThat(car).isEqualTo(Car())
    }

    @DisplayName("Car 이동 테스트")
    @Test
    fun `Car 이동 테스트`() {
        car.move(object : MovingStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        })
        assertThat(car).isEqualTo(Car(Position(1)))
    }

    @DisplayName("Car 이동 실패 테스트")
    @Test
    fun `Car 이동 실패 테스트`() {
        car.move(object : MovingStrategy {
            override fun isMovable(): Boolean {
                return false
            }
        })
        assertThat(car).isEqualTo(Car())
    }
}
