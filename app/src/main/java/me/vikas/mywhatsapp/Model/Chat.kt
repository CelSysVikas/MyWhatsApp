package me.vikas.mywhatsapp.Model

data class Chat(
    var name:String,
    var dp: Int?,
    var message:String,
    var time:String,
    var isPinned:Boolean
)