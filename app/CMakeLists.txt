
cmake_minimum_required(VERSION 3.4.1)

include_directories(${CMAKE_SOURCE_DIR}/src/main/cpp)

add_library(
        native_lib
        SHARED
        ${CMAKE_SOURCE_DIR}/src/main/cpp/andFix.cpp
)

target_link_libraries(
        native_lib
)