package bots

import clipClick
import wire
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

class ClipMakerBot(
    override var period: Duration = 100.milliseconds,
    var minBatchSize: Long = 0,
    var maxBatchSize: Long = 0,
    var loggingEnabled: Boolean = true,
) : MicroBot("clip-maker") {

    override fun onTick() {
        val currentWire = wire.toLong()
        if (currentWire == 0L || currentWire < minBatchSize) {
            return
        }
        val clipsToMake = currentWire.coerceAtMost(maxBatchSize)
        if (loggingEnabled) {
            println("Buying ${clipsToMake} clips")
        }
        clipClick(clipsToMake)
    }
}
