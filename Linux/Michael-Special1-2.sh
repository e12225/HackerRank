while read -r line; do
  Names=(${Names[@]} $line)
done

echo ${Names[@]/*[aA]*/}
