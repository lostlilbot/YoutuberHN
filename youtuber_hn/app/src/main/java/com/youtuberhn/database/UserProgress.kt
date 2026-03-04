package com.youtuberhn.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgress(
    @PrimaryKey
    val chapterId: String,
    val isRead: Boolean = false,
    val lastReadTimestamp: Long = 0
)

@Entity(tableName = "user_actions")
data class UserAction(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val actionType: String, // e.g., "video_titles", "equipment_checklist", "content_planner"
    val actionData: String, // JSON string to store action-specific data
    val timestamp: Long = System.currentTimeMillis()
)
