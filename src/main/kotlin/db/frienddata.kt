package db

import grpc_code_gen.friend.friendMessage.NewFriendMessage
import grpc_code_gen.friend.friendMessage.newFriendMessageReply

object frienddata {
    var data = newFriendMessageReply{
        uid = 0
        userName = "张添羽"
        sex = 0
        birthdayDate = "2002-01-01 00:00:00"
    }
}