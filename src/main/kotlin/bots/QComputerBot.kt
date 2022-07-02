package bots

import qChips
import qComp
import kotlin.math.ceil
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

class QComputerBot(
    override var period: Duration = 200.milliseconds,
    var hitsPerTick: Int = 10000,
) : MicroBot(
    name = "Q-Computer",
    description = "Hits the quantum computer when the chips give positive ops",
) {

    override fun onTick() {
        if (!isQComputerDiscovered()) {
            return // nothing to do
        }
        if (currentQuantumOps() > 0) {
            repeat(hitsPerTick) {
                qComp()
            }
        }
    }

    private fun isQComputerDiscovered(): Boolean = qChips[0].active != 0

    private fun currentQuantumOps(): Long {
        check(isQComputerDiscovered()) { "Cannot access current ops when quantum computer was not discovered" }

        val totalQ = qChips.sumOf { it.value.toDouble() }
        return ceil(totalQ * 360).toLong()
    }
}
