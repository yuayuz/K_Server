package server

import io.grpc.netty.NettyServerBuilder
import org.ktorm.database.Database
import service.FindNewFriendService



class NewFriendServer(private val port: Int) {

    private val database = Database.connect(
        url = "jdbc:postgresql://localhost:5432/ktorm",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "123456"
    )
    private val server: io.grpc.Server = NettyServerBuilder
        .forPort(port)
        .addService(FindNewFriendService(database))
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