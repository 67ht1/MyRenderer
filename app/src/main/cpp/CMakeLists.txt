cmake_minimum_required(VERSION 3.22.1)
project(MyRendererAndroid LANGUAGES C CXX)

set(MOBILEGLUES_DIR
    "${CMAKE_CURRENT_LIST_DIR}/../../../../third_party/MobileGlues/MobileGlues-cpp")

if(NOT EXISTS "${MOBILEGLUES_DIR}/CMakeLists.txt")
    message(FATAL_ERROR
        "MobileGlues source missing. Run scripts/prepare-mobileglues.sh first.")
endif()

add_subdirectory("${MOBILEGLUES_DIR}" "${CMAKE_BINARY_DIR}/mobileglues")

# MobileGlues upstream uses CMAKE_SOURCE_DIR for public headers. When embedded
# with add_subdirectory(), that resolves to the Android app, not MobileGlues.
# Add the actual MobileGlues public and internal include directories explicitly.
if(TARGET MyRendererAndroid)
    target_include_directories(MyRendererAndroid PRIVATE
        "${MOBILEGLUES_DIR}/include"
        "${MOBILEGLUES_DIR}/includes"
    )

    if(ANDROID)
        # Android 15+ 16 KB page-size compatibility.
        target_link_options(MyRendererAndroid PRIVATE "-Wl,-z,max-page-size=16384")
    endif()
endif()
