package com.example.demo

import io.github.wechaty.MessageListener
import io.github.wechaty.ScanListener
import io.github.wechaty.Wechaty
import io.github.wechaty.WechatyPlugin
import io.github.wechaty.schemas.MessageType
import io.github.wechaty.schemas.ScanStatus
import io.github.wechaty.user.Message
import io.github.wechaty.utils.QrcodeUtils

typealias DingDongOptions = DingDongOptionsObject

class DingDongOptionsObject {
    var at = true
    var dm = true
    var room = true
}

fun isMatchOptions(options: DingDongOptionsObject? = null, message: Message): Boolean {
    val localOptions: DingDongOptionsObject = options ?: DingDongOptionsObject()

    if (localOptions.room && message.room() != null) {
        return true
    }

    if (localOptions.at && message.room() != null && message.mentionSelf()) {
        return true
    }

    if (localOptions.dm && message.room() == null) {
        return true
    }

    return false
}

class WechatyPlugins {

    companion object {
        @JvmStatic
        fun DingDongPlugin(options: DingDongOptions?): WechatyPlugin {
            return fun(wechaty: Wechaty) {
                wechaty.onMessage(object : MessageListener {
                    override fun handler(message: Message) {
                        if (message.type() != MessageType.Text) {
                            return
                        }


                        val room = message.room()

                        val text = if (room == null) {
                            message.mentionText()
                        } else {
                            message.text()
                        }

                        if (!isMatchOptions(options, message)) {
                            return
                        }

                        if (!"#ding".equals(text)) {
                            return
                        }

                        if (room == null) {
                            message.say("dong", message.from()!!)
                        } else {
                            room.say("dong")
                        }
                        return

                    }
                })
            }
        }

        @JvmStatic
        fun ScanPlugin(): WechatyPlugin {
            return fun(wechaty) {
                wechaty.onScan(object : ScanListener {
                    override fun handler(qrcode: String?, statusScanStatus: ScanStatus, data: String?) {
                        println(QrcodeUtils.getQr(qrcode!!))
                    }
                })

            }
        }
    }

}