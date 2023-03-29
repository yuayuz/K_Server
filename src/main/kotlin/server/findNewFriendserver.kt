package server

import io.grpc.netty.NettyServerBuilder
import service.FindNewFriendService

class HelloWorldServer(private val port: Int) {
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