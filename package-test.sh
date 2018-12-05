#!/bin/bash
echo -----------------------------------------------------------------------------
echo start package for test
echo -----------------------------------------------------------------------------
mvn  package -Dmaven.test.skip=true -Ptest
read -n 1