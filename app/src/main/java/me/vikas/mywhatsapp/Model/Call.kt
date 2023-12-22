package me.vikas.mywhatsapp.Model

data class Call(
    var name:String,
    var time:String,
    var dp:Int?,
    var isVideo:Boolean,
    var call: CallType
)

enum class CallType(int:Int){
    SEND(0),
    RECEIVE(1),
    MISSED(2)
}