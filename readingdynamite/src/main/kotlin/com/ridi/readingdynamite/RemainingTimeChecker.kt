package com.ridi.readingdynamite

import com.ridi.readingdynamite.RecentReadingInfoQueue.Companion.QUEUE_SIZE

class RemainingTimeChecker {
    private val readingInfoQueue = RecentReadingInfoQueue()

    var remainingWords = 0

    fun addLastPageReadingInfo(wordCount: Int, time: Double) {
        val readingSpeedItem = ReadingInfoItem(wordCount, time)
        readingInfoQueue.addItem(readingSpeedItem)
    }

    fun getRemainingTime() = if (readingInfoQueue.size < QUEUE_SIZE) null
        else (remainingWords * readingInfoQueue.recentReadingTime / readingInfoQueue.recentReadingWordCount).toInt()
}
