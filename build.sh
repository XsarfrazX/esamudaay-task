#!/bin/bash

function usage(){
  echo "$(basename $0) [-p | --package] [-r | --run]  [-h | --help]"
}

package=0
run=0

project_name="task:0.0.1"
while [[ "$1" != "" ]]; do
  case $1 in
    -p | --package )
    package=1
    ;;
    -r | --run )
    run=1
    ;;
    -h | --help )
    usage;
    exit
    ;;
  esac
  shift
done


function exit_script(){
    echo "**** Error in file $0 while processing task $1 *****"
}

if [ $package == 1 ]; then
  echo "Packaging jar"
  mvn clean package || exit_script Packaging
  echo "Jar packaging done"
fi

if [ $run == 1 ]; then
  echo "Starting Springboot project"
  mvn spring-boot:run || exit_script Run
fi