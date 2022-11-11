package step1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "최정", age = 35, nickname = "namonak")
        person.name shouldBe "최정"
        person.age shouldBe 35
        person.nickname shouldBe "namonak"
    }

    "널 타입" {
        val person = Person(name = "최정", age = 35, nickname = null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person(name = "최정", age = 35)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person(name = "최정", age = 35)
        val person2 = Person(name = "최정", age = 35)
        person1 shouldBe person2
    }
})