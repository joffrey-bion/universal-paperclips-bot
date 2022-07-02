package bots

import clipClick
import wire
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

/**
 * Clicks the "Make paperclip" button when the amount is too low.
 */
class ClipMakerBot(
    override var period: Duration = 100.milliseconds,
    var minBatchSize: Long = 0,
    var maxBatchSize: Long = 100,
    var loggingEnabled: Boolean = true,
) : MicroBot(
    name = "Clip maker",
    description = "Clicks the 'Make paperclip' button when the amount is too low.",
) {
    override fun onTick() {
        val currentWire = wire.toLong()
        if (currentWire == 0L || currentWire < minBatchSize) {
            return
        }
        val clipsToMake = currentWire.coerceAtMost(maxBatchSize)
        if (loggingEnabled) {
            println("Buying $clipsToMake clips")
        }
        clipClick(clipsToMake)
    }
}
