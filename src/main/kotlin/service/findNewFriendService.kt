package service

import com.google.protobuf.Message
import db.Demo
import grpc_code_gen.friend.friendMessage.NewFriendMessage
import grpc_code_gen.friend.friendMessage.newFriendMessageReply
import grpc_code_gen.friend.newFriend.NewFriend
import grpc_code_gen.friend.newFriend.friendMessageGrpcKt
import grpc_code_gen.friend.newFriend.newFriendReply
import grpc_code_gen.friend.newFriend.newFriendReplyKt
import kotlinx.coroutines.*
import org.ktorm.database.Database
import org.ktorm.dsl.*
import java.time.LocalDateTime
import java.util.*


class FindNewFriendService : friendMessageGrpcKt.friendMessageCoroutineImplBase() {

    override suspend fun find(request: NewFriend.newFriendRequest) = newFriendReply {

        val id = request.id.id

        /*val database = Database.connect(
            url = "jdbc:postgresql://localhost:5432/ktorm",
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = "123456"
        )


        val s=withContext(Dispatchers.IO) {
            database.from(Demo).select().where { (Demo.uid eq 4) }.forEach {
                return@withContext newFriendMessageReply {
                    uid = it[Demo.uid]!!
                    userName = it[Demo.name].toString()
                    sex = it[Demo.sex]!!
                    birthdayDate = it[Demo.birthday].toString()
                }
            }
        }
        message= s as NewFriendMessage.newFriendMessageReply*/

        /*var data:NewFriendMessage.newFriendMessageReply
        runBlocking{
            data=withContext(Dispatchers.IO){
                data=data(id)
                return@withContext data
            }
        }
        message= data*/

        message=newFriendMessageReply {
            uid = id
            userName = "张添羽"
            sex = 0
            birthdayDate = "2002-01-01 00:00:00"
        }

    }

}


//        return super.find(request)


//    newFriendReply { message = data(request.id.id) }
