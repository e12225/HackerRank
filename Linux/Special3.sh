#!/usr/bin/env bash

# https://www.hackerrank.com/challenges/sed-command-5/problem

sed -E "s/([0-9]{4}) ([0-9]{4}) ([0-9]{4}) ([0-9]{4})/\4 \3 \2 \1/"

# try:
# echo 1234 5678 9101 1234 | sed -E "s/([0-9]{4}) ([0-9]{4}) ([0-9]{4}) ([0-9]{4})/\4 \3 \2 \1/"
# in command line

