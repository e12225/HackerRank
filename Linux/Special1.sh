#!/usr/bin/env bash

index=1;

while read country
do
    # reading each line of the country list
    country_list[index]=$country;
    index=$((index+1));
done

# declaring a new variable (-a option) to assign the filtered country list
declare -a filtered_countries=(${country_list[@]/*[aA]*/});

echo "${filtered_countries[@]}";