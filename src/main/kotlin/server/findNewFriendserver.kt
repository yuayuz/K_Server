package server

import io.grpc.netty.NettyServerBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import service.FindNewFriendService

class NewFriendServer(private val port: Int) {
    private val server: io.grpc.Server = NettyServerBuilder
        .forPort(port)
        .addService(FindNewFriendService())
        .build()

    fun start() {
        server.start()
        println("FindNewFriendService开启, 端口号： $port")
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }


}