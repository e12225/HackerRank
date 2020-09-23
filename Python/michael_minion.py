def minion_game(string):
    # your code goes here
    stuart = 0
    kevin = 0
    length = len(string)
    for index in range(length):
        score = length - index
        char = string[index]
        if char in 'AEIOU':
            kevin += score
        else:
            stuart += score

    if stuart == kevin:
        print('Draw')
    elif stuart > kevin:
        print('Stuart ' + str(stuart))
    else:
        print('Kevin ' + str(kevin))

if __name__ == '__main__':
    s = input()
    minion_game(s)
