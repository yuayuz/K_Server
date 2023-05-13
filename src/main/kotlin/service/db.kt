package service

import grpc_code_gen.friend.friendMessage.NewFriendMessage
import grpc_code_gen.friend.friendMessage.newFriendMessageReply
import java.sql.Connection
import java.sql.DriverManager

    fun data(id: Long): NewFriendMessage.newFriendMessageReply {
        lateinit var message: NewFriendMessage.newFriendMessageReply
        Class.forName("org.postgresql.Driver")
        val url = "jdbc:postgresql://localhost:5432/ktorm"
        val user = "postgres"
        val password = "123456"
        val conn: Connection = DriverManager.getConnection(url, user, password)
        val stat = conn.createStatement()

        val sql = String.format("SELECT * from demo WHERE id=%d", id)
        val data = stat.executeQuery(sql)
        stat.close()
        conn.close()
        if (data.next()) {
            message = newFriendMessageReply {
                uid = data.getLong(1)
                userName = data.getString(2)
                sex = data.getInt(3)
                birthdayDate = data.getString(4)
            }
        }
        return message
    }
