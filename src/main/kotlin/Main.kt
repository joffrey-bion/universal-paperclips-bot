import bots.ClipMakerBot
import bots.QComputerBot
import bots.WireBuyerBot
import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    window.onload = { document.body?.sayHello() }
}

data class Bots(
    val clipMakerBot: ClipMakerBot = ClipMakerBot(),
    val wireBuyerBot: WireBuyerBot = WireBuyerBot(),
    val qComputerBot: QComputerBot = QComputerBot(),
)

fun Node.sayHello() {
    append {
        div {
            +"Hello from JS"
        }
    }
}
