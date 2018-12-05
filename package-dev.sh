#!/bin/bash
echo -----------------------------------------------------------------------------
echo start package for dev
echo -----------------------------------------------------------------------------
mvn  package -Dmaven.test.skip=true -Pdev
read -n 1