package com.youtuberhn.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapters")
data class Chapter(
    @PrimaryKey val id: String,
    val title: String,
    val content: String,
    val isRead: Boolean = false
)