package server

import io.grpc.netty.NettyServerBuilder
import service.messageService

class messageserver(private val port: Int) {
    private val server: io.grpc.Server = NettyServerBuilder
        .forPort(port)
        .addService(messageService())
        .build()

    fun start() {
        server.start()
        println("MessageService开启, 端口号： $port")
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }
}