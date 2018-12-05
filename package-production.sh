#!/bin/bash
echo -----------------------------------------------------------------------------
echo start package for pro
echo -----------------------------------------------------------------------------
mvn  package -Dmaven.test.skip=true -Ppro
read -n 1
