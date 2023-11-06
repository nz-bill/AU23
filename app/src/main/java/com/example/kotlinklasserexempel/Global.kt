package com.example.kotlinklasserexempel

import android.content.Intent
import android.os.Build
import java.io.Serializable

fun <T : Serializable?> getSerializable(intent: Intent, key: String, m_class: Class<T>): T {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        intent.getSerializableExtra(key, m_class)!!
    else
        intent.getSerializableExtra(key) as T
}