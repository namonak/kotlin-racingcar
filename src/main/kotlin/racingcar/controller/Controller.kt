package racingcar.controller

import racingcar.domain.car.Cars
import racingcar.domain.car.action.RandomMovingStrategy
import racingcar.domain.input.PlayTime
import racingcar.domain.input.Racers
import racingcar.view.InputView
import racingcar.view.ResultView

object Controller {
    fun start() {
        val cars = inputRacers()
        val playTime = inputPlayTime()
        ResultView.printResultTitle()
        repeat(playTime) {
            startRace(cars)
        }
        ResultView.printWinners(cars.findTheWinner())
    }

    private fun inputRacers(): Cars {
        return try {
            val racers = Racers(InputView.inputRacers())
            Cars(racers.value.toTypedArray())
        } catch (e: Exception) {
            e.message?.let(InputView::printError)
            inputRacers()
        }
    }

    private fun inputPlayTime(): Int {
        return try {
            PlayTime(InputView.inputPlayTime()).value
        } catch (e: Exception) {
            e.message?.let(InputView::printError)
            inputPlayTime()
        }
    }

    private fun startRace(cars: Cars) {
        cars.play(RandomMovingStrategy())
        cars.cars.forEach {
            ResultView.printResult(it.name.value, it.position.value)
        }
        println()
    }
}
