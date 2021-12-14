package com.mecedric.androidcomparizon.util

import androidx.annotation.Nullable
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class SerializeNulls {
    companion object {
        var JSON_ADAPTER_FACTORY: JsonAdapter.Factory = object : JsonAdapter.Factory {
            @Nullable
            override fun create(
                type: Type,
                annotations: Set<Annotation?>,
                moshi: Moshi,
            ): JsonAdapter<*>? {
                val nextAnnotations: Set<Annotation?> = Types.nextAnnotations(
                    annotations,
                    SerializeNulls::class.java
                ) ?: return null
                return moshi.nextAdapter<Type>(this, type, nextAnnotations).serializeNulls()
            }
        }
    }
}