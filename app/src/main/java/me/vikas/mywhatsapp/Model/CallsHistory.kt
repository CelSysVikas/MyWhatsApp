package me.vikas.mywhatsapp.Model

data class CallsHistory(
    var call:CallType,
    var isVideo:Boolean,
    var time:String,
    var duration:String?,
    var dataTransfer:String?
)
