package service

import grpc_code_gen.chat.message.Message
import grpc_code_gen.chat.message.messageGrpcKt
import grpc_code_gen.chat.message.messageReply
import grpc_code_gen.friend.newFriend.friendMessageGrpcKt
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class messageService : messageGrpcKt.messageCoroutineImplBase(){
    override suspend fun find(request: Message.MessageRequest)= messageReply {
            msgId = request.msgId
            uid = request.uid
            isMe = false
            from = request.to
            fromName = request.fromName
            to = request.from
            toName = request.toName
            chatType = request.chatType
            msgType = request.msgType
            msg = request.msg
            sendTime = request.sendTime
            sendStatus = request.sendStatus
    }
}