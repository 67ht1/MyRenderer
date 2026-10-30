package dev.myrenderer.plugin

import android.app.Activity
import android.os.Bundle
import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import java.io.File

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nativeLib = File(applicationInfo.nativeLibraryDir, "libmobileglues.so")
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 28, 24, 24)
            setBackgroundColor(0xFF10151D.toInt())
        }

        fun addText(value: String, size: Float, color: Int, bold: Boolean = false) {
            root.addView(TextView(this).apply {
                text = value
                textSize = size
                setTextColor(color)
                if (bold) typeface = Typeface.DEFAULT_BOLD
                setPadding(0, 8, 0, 8)
            })
        }

        addText("MyRenderer", 30f, 0xFFFFFFFF.toInt(), true)
        addText("Minecraft Java · Android · Mali", 14f, 0xFF9EADBF.toInt())
        addText("Первичная сборка 0.1.0", 18f, 0xFFFFFFFF.toInt(), true)
        addText(
            if (nativeLib.exists()) "Native core: найден" else "Native core: не найден",
            16f,
            if (nativeLib.exists()) 0xFF71D69A.toInt() else 0xFFFFB86B.toInt(),
            true
        )
        addText("Устройство: ${android.os.Build.MODEL}", 14f, 0xFFD8E0EA.toInt())
        addText("Android: ${android.os.Build.VERSION.RELEASE}", 14f, 0xFFD8E0EA.toInt())
        addText("ABI: ${android.os.Build.SUPPORTED_ABIS.firstOrNull() ?: "unknown"}", 14f, 0xFFD8E0EA.toInt())
        addText(
            "Выбор MyRenderer выполняется в настройках рендерера ZalithLauncher. " +
            "На этой сборке включён DirectGLES; экспериментальные Mali-оптимизации пока выключены.",
            14f,
            0xFF9EADBF.toInt()
        )
        addText("Профиль запуска: Compatible", 16f, 0xFFFFFFFF.toInt(), true)
        addText("Это ранняя интеграционная сборка. Производительность и совместимость ещё не подтверждены на устройстве.", 13f, 0xFFFFD18A.toInt())

        val scroll = ScrollView(this).apply { addView(root) }
        setContentView(scroll)
    }
}
