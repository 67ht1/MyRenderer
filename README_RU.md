# MyRenderer 0.1.0 — ранняя интеграционная сборка

Это исходный Android-проект APK-плагина для ZalithLauncher V2. Он собирает нативную библиотеку MobileGlues для arm64-v8a и упаковывает её в APK.

## Сборка APK

1. Открыть вкладку Actions.
2. Запустить workflow Build MyRenderer APK.
3. После завершения сборки скачать артефакт MyRenderer-debug-apk.

## Текущий статус

- Android APK-проект: подготовлен.
- Регистрация RendererPlugin V2: добавлена.
- ABI: arm64-v8a.
- Native core: MobileGlues, закреплённый на commit 97558a69157b033b890958b1e49258c5b51a80c6.
- Backend: DirectGLES.
- Mali-оптимизации MyRenderer: пока не включены и не заявляются как готовые.
- Подтверждённая сборка на POCO X6 Pro: ещё не выполнена.

Это не готовое доказательство повышения FPS. Сначала нужно получить APK, установить его в ZalithLauncher и проверить запуск Minecraft 1.20.1 на устройстве.
