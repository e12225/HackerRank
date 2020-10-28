while read -r line; do
  Names=(${Names[@]} $line)
done

printed=0
for i in ${Names[@]}; do
    if [[ ! $i =~ a|A ]]; then
        echo $i
        ((printed+=1))
    fi
done

if [[ $printed -eq 0 ]]; then
    echo
fi

