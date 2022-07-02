import bots.ClipMakerBot
import bots.MicroBot
import bots.QComputerBot
import bots.WireBuyerBot
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.onClickFunction
import org.w3c.dom.COMPLETE
import org.w3c.dom.DocumentReadyState

fun main() {
    // already COMPLETE when copying the JS into the real game, but has to wait for "load" event when in the test page
    if (document.readyState == DocumentReadyState.COMPLETE) {
        createBotPanel()
    } else {
        window.onload = { createBotPanel() }
    }
}

fun createBotPanel() {
    document.body?.append {
        botPanel()
    }
}

private fun TagConsumer<*>.botPanel() {
    div {
        attributes["style"] = "background-color: #bbe8f499;" +
            "width: 13rem;" +
            "float: right;" +
            "border-radius: 5px;" +
            "padding: 0.5rem;"

        h3 {
            +"Paperclip Bot"
        }
        microBotControl("Clip maker", Bots.clipMakerBot)
        microBotControl("Wire buyer", Bots.wireBuyerBot)
        microBotControl("Q-Computer", Bots.qComputerBot)
    }
}

private fun TagConsumer<*>.microBotControl(name: String, bot: MicroBot) {
    div {
        +name
        button {
            +"Start"
            onClickFunction = {
                bot.startIn(GlobalScope)
            }
        }
        button {
            +"Stop"
            onClickFunction = {
                bot.stop()
            }
        }
    }
}

object Bots {
    val clipMakerBot: ClipMakerBot = ClipMakerBot()
    val wireBuyerBot: WireBuyerBot = WireBuyerBot()
    val qComputerBot: QComputerBot = QComputerBot()
}
