package racingcar.domain

import racingcar.domain.movestrategy.MoveStrategy

data class Car(
    val name: Name,
    val distance: Distance = Distance()
) : Comparable<Car> {

    constructor(name: String, distance: Distance) : this(Name(name), distance)

    constructor(name: String) : this(Name(name))

    constructor(name: String, distance: Int) : this(Name(name), Distance(distance))

    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.movable()) {
            return Car(name = name, distance = distance + MOVE_DISTANCE)
        }
        return this
    }

    fun isSameDistance(distance: Distance) = this.distance == distance

    override fun compareTo(other: Car) = this.distance.compareTo(other.distance)

    companion object {
        private val MOVE_DISTANCE = Distance(1)
    }
}