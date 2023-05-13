import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import server.NewFriendServer
import server.messageserver

fun main(args: Array<String>) {
    val port = 8980
    /*val newFriendServer = NewFriendServer(port)
    newFriendServer.start()
    newFriendServer.blockUntilShutdown()*/

    val messageServer = messageserver(port)
    messageServer.start()
    messageServer.blockUntilShutdown()
}