import db.Demo
import db.frienddata
import grpc_code_gen.friend.friendMessage.NewFriendMessage
import grpc_code_gen.friend.friendMessage.newFriendMessageReply
import kotlinx.coroutines.*
import org.ktorm.database.Database
import org.ktorm.dsl.*
import server.NewFriendServer
import server.messageserver

suspend fun main(args: Array<String>) {


    val port = 8980
    /*val newFriendServer = NewFriendServer(port)
    newFriendServer.start()
    newFriendServer.blockUntilShutdown()*/

//    d()
//    println(frienddata.data.userName)


    val messageServer = messageserver(port)
    messageServer.start()
    messageServer.blockUntilShutdown()

}