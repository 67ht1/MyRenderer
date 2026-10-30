# MyRenderer 0.1.0 — ранняя интеграционная сборка

Android-проект APK-плагина для ZalithLauncher V2. Проект предназначен для сборки нативной библиотеки MobileGlues под arm64-v8a и упаковки её в APK.

## Сборка

GitHub Actions запускает workflow **Build MyRenderer APK** при push в main или вручную из вкладки Actions. Готовый APK публикуется как артефакт workflow.

## Статус

- Android APK-проект и базовая регистрация RendererPlugin V2 подготовлены.
- Целевая ABI: arm64-v8a.
- Native core: MobileGlues, закреплённый на commit 97558a69157b033b890958b1e49258c5b51a80c6.
- Backend: DirectGLES.
- Специальные Mali-оптимизации пока не реализованы.
- Сборка и совместимость на POCO X6 Pro / Minecraft 1.20.1 ещё не подтверждены.

Это ранний интеграционный прототип, а не подтверждённый прирост FPS. После сборки требуется установка в ZalithLauncher и тестирование.
