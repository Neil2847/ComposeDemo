package com.mirrorfiction.note.config.util

/**
 * Create by Neil
 * on 2021/12/15.
 */
sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
