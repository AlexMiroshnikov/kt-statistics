#!/bin/bash

echo "Clean, lint and format.."
CMD="clean formatKotlin ktlintFormat"
./gradlew $CMD
RES=$?

if [ $RES != 0 ]
then
  echo -e "\033[0;31m\"gradlew $CMD\" was not successful, aborting\033[0m"
  exit 1
fi

echo "Check.."
./gradlew check
RES=$?

if [ $RES != 0 ]
then
  echo -e "\033[0;31m\"gradlew check\" was not successful, aborting\033[0m"
  exit 1
fi

MSG=$*
git commit -a -m "$MSG"
RES=$?

if [ $RES != 0 ]
then
  echo -e "\033[0;31m\"git commit\" was not successful, aborting\033[0m"
  exit 1
fi

echo -e "\033[0;32mDone\033[0m"
