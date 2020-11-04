read count
read num_line

numbers=("$num_line")

declare -A map=()

for i in ${numbers[@]}; do
    if [[ -z ${map[$i]} ]]; then
        map[$i]='y'
    else
        map[$i]='n'
    fi
done

for i in ${numbers[@]}; do
    if [[ ${map[$i]} == 'y' ]]; then
        echo $i
    fi
done
