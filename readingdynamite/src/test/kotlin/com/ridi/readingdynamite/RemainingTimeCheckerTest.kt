package com.ridi.readingdynamite

import org.junit.Assert.assertEquals
import org.junit.Test

class RemainingTimeCheckerTest {

    private val remainingTimeChecker = RemainingTimeChecker()

    companion object {
        private const val REMAINING_WORDS = 3000
        private const val REMAINING_TIME = 3146
        // 11~30까지 합 = 410 , 12~31까지 합 = 430, 3000 * 43/41 = 3146.xxx
    }

    @Test
    fun getRemainingTimeTest() {
        remainingTimeChecker.remainingWords = REMAINING_WORDS
        for(i in 1..30){
            remainingTimeChecker.addLastPageReadingInfo(i,(i+1)*1.0)
        }
        assertEquals(remainingTimeChecker.getRemainingTime(),REMAINING_TIME)
    }

    // Queue에 Item이 20개 이상 채워져있지 않을 때에는 null을 리턴.
    @Test
    fun getRemainingTimeNullTest() {
        remainingTimeChecker.remainingWords = REMAINING_WORDS
        for(i in 1..10){
            remainingTimeChecker.addLastPageReadingInfo(i,(i+1)*1.0)
        }
        assertEquals(remainingTimeChecker.getRemainingTime(),null)
    }
}
