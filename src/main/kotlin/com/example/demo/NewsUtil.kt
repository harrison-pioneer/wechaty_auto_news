package com.example.demo

import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject


class NewsUtil {

    fun getNews(): ToutiaoResponse {
        val type = "top"
        val appKey = ""
        val url = "http://v.juhe.cn/toutiao/index?type=$type&key=$appKey"

        val restTemplate = RestTemplate()
        return restTemplate.getForObject(url, ToutiaoResponse::javaClass)
    }
}