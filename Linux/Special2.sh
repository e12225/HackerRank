#!/usr/bin/env bash

read

int_array=($(cat))

echo "${int_array[@]}" | tr ' ' '\n' | sort | uniq -u | tr '\n' ' '

# Explanation of the above pattern :
# "${int_array[@]}" | tr ' ' '\n' -> relpaces the spaces with new lines of the integer array
# "${int_array[@]}" | tr ' ' '\n' | sort -> sorts out the integer array (separated by new lines by now)
# "${int_array[@]}" | tr ' ' '\n' | sort | uniq -u -> prints out only the unique (-u) lines of the integer list
# "${int_array[@]}" | tr ' ' '\n' | sort | uniq -u | tr '\n' ' ' -> replaces the new lines with space characters again
# so it will print the output in a single line