package com.example.demo

import com.fasterxml.jackson.annotation.JsonProperty

data class ToutiaoResponse(
        @JsonProperty("reason")
        val reason: String? = null,
        @JsonProperty("result")
        val result: Result? = null
) {

    data class Result(
            @JsonProperty("data")
            val `data`: List<Data>? = null,
            @JsonProperty("stat")
            val stat: String? = null
    )

    data class Data(
            @JsonProperty("author_name")
            val authorName: String? = null,
            @JsonProperty("category")
            val category: String? = null,
            @JsonProperty("date")
            val date: String? = null,
            @JsonProperty("thumbnail_pic_s")
            val thumbnailPicS: String? = null,
            @JsonProperty("thumbnail_pic_s02")
            val thumbnailPicS02: String? = null,
            @JsonProperty("thumbnail_pic_s03")
            val thumbnailPicS03: String? = null,
            @JsonProperty("title")
            val title: String? = null,
            @JsonProperty("uniquekey")
            val uniquekey: String? = null,
            @JsonProperty("url")
            val url: String? = null
    )
}