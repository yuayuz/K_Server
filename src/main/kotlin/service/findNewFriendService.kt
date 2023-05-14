package service

import db.Demo

import grpc_code_gen.friend.friendMessage.newFriendMessageReply
import grpc_code_gen.friend.newFriend.NewFriend
import grpc_code_gen.friend.newFriend.friendMessageGrpcKt
import grpc_code_gen.friend.newFriend.newFriendReply
import org.ktorm.database.Database
import org.ktorm.dsl.*


class FindNewFriendService(private val database: Database) : friendMessageGrpcKt.friendMessageCoroutineImplBase() {
    override suspend fun find(request: NewFriend.newFriendRequest) = newFriendReply {
        // 从数据库中获取数据
        val id = request.id.id

        database.from(Demo).select().where { (Demo.uid eq id) }.forEach {
            message= newFriendMessageReply {
                uid = it[Demo.uid]!!
                userName = it[Demo.name].toString()
                sex = it[Demo.sex]!!
                birthdayDate = it[Demo.birthday].toString()
            }
        }

    }
}