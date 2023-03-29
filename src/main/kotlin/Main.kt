import server.HelloWorldServer

fun main(args: Array<String>) {
    val port = 8980
    val server = HelloWorldServer(port)
    server.start()
    server.blockUntilShutdown()
}