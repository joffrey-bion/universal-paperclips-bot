package bots

import kotlinx.coroutines.*
import kotlin.time.Duration

abstract class MicroBot(
    val name: String,
    val description: String,
) {
    abstract var period: Duration

    private var job: Job? = null

    fun startIn(scope: CoroutineScope) {
        job = scope.launch(CoroutineName(name.replace(' ', '-').lowercase())) {
            while(true) {
                onTick()
                delay(period)
            }
        }
    }

    fun stop() {
        job?.cancel()
    }

    abstract fun onTick()
}
