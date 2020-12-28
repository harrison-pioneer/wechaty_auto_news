package com.example.demo

import io.github.wechaty.Wechaty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class DemoApplication{

	@Bean
	fun wechaty():Wechaty{
		val wechatyToken = "your wechaty token"
		val bot = Wechaty.instance(wechatyToken)
		bot.use(WechatyPlugins.ScanPlugin())
		bot.start(false)
		return bot
	}

}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

