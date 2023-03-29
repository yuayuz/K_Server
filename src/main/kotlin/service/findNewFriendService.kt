package service

import grpc_code_gen.friend.friendMessage.NewFriendMessage
import grpc_code_gen.friend.friendMessage.newFriendMessageReply
import grpc_code_gen.friend.newFriend.NewFriend
import grpc_code_gen.friend.newFriend.friendMessageGrpcKt
import grpc_code_gen.friend.newFriend.newFriendReply


class FindNewFriendService: friendMessageGrpcKt.friendMessageCoroutineImplBase() {
    override suspend fun find(request: NewFriend.newFriendRequest)= newFriendReply {
        val id=request.id
        message= newFriendMessageReply {
            uid=1234
            userName="小"
            sex=0
            birthdayDate="2023-03-29"
        }
    }
}