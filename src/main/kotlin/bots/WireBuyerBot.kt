package bots

import buyWire
import funds
import wireCost
import wireSupply
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

const val MIN_SELL_PRICE = 0.01

class WireBuyerBot(
    override var period: Duration = 80.milliseconds,
    var minMoneyToKeep: Int = 0,
    var loggingEnabled: Boolean = true,
) : MicroBot("wire-buyer") {

    override fun onTick() {
        val currentWirePrice = wireCost.toLong()
        val currentWireSupply = wireSupply.toLong()
        if (currentWirePrice > currentWireSupply * MIN_SELL_PRICE) {
            return
        }
        val money = funds.toLong()
        if (money < minMoneyToKeep + currentWirePrice) {
            return
        }
        if (loggingEnabled) {
            println("Buying wire spool")
        }
        buyWire()
    }
}

