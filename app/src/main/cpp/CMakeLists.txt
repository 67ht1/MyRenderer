cmake_minimum_required(VERSION 3.22.1)
project(MyRendererAndroid LANGUAGES C CXX)

set(MOBILEGLUES_DIR
    "${CMAKE_CURRENT_LIST_DIR}/../../../../third_party/MobileGlues/MobileGlues-cpp")

if(NOT EXISTS "${MOBILEGLUES_DIR}/CMakeLists.txt")
    message(FATAL_ERROR
        "MobileGlues source missing. Run scripts/prepare-mobileglues.sh first.")
endif()

add_subdirectory("${MOBILEGLUES_DIR}" "${CMAKE_BINARY_DIR}/mobileglues")

if(TARGET mobileglues AND ANDROID)
    # Android 15+ 16 KB page-size compatibility for the native renderer.
    target_link_options(mobileglues PRIVATE "-Wl,-z,max-page-size=16384")
endif()
