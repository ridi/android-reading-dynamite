package com.ridi.readingdynamite

import java.util.LinkedList
import java.util.Queue

data class ReadingInfoItem(val wordCount: Int, val time: Double)

internal class RecentReadingInfoQueue {
    companion object {
        const val QUEUE_SIZE = 20
    }

    private var recentReadingInfo: Queue<ReadingInfoItem> = LinkedList<ReadingInfoItem>()
    var size = 0
        get() = recentReadingInfo.size

    var recentReadingWordCount = 0
        get() {
            return recentReadingInfo.fold(0) { sum, element ->
                sum + element.wordCount
            }
        }

    var recentReadingTime = 0.0
        get() {
            return recentReadingInfo.fold(0.0) { sum, element ->
                sum + element.time
            }
        }

    private fun enQueue(item: ReadingInfoItem) = recentReadingInfo.add(item)

    private fun deQueue() = recentReadingInfo.remove()

    fun addItem(item: ReadingInfoItem) {
        if (size == QUEUE_SIZE) {
            deQueue()
        }
        enQueue(item)
    }
}
