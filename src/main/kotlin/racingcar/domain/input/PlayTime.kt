package racingcar.domain.input

data class PlayTime(val value: Int) {
    init {
        require(value > MINIMUM_PLAY_TIME) { "시도 횟수는 0보다 커야 합니다." }
    }

    companion object {
        private const val MINIMUM_PLAY_TIME = 0
    }
}
