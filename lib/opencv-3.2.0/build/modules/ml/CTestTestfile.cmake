# CMake generated Testfile for 
# Source directory: /Users/lucabonfante/Desktop/opencv-3.2.0/modules/ml
# Build directory: /Users/lucabonfante/Desktop/opencv-3.2.0/build/modules/ml
# 
# This file includes the relevant testing commands required for 
# testing this directory and lists subdirectories to be tested as well.
add_test(opencv_test_ml "/Users/lucabonfante/Desktop/opencv-3.2.0/build/bin/opencv_test_ml" "--gtest_output=xml:opencv_test_ml.xml")
set_tests_properties(opencv_test_ml PROPERTIES  LABELS "Main;opencv_ml;Accuracy" WORKING_DIRECTORY "/Users/lucabonfante/Desktop/opencv-3.2.0/build/test-reports/accuracy")
