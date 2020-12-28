package com.example.demo

import io.github.wechaty.Wechaty
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class MySchedule(private val wechaty: Wechaty) {

    @Scheduled(fixedDelay = 600000)
    fun autoSuggest() {
        val newsResponse = NewsUtil().getNews()
        val newsList = newsResponse.result?.data?:return

        for (i in 0..2) {
            wechaty.say("Latest news: ${newsList[i].title}" +
                    "\n${newsList[i].url}")
        }
    }
}