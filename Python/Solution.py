def minion_game(string):

    vowels = 'AEIOU'
    stringLenght = len(string)

    kevinSscore = 0
    stuartSscore = 0

    for i in range(stringLenght):
        if s[i] in vowels:
            kevinSscore += (stringLenght - i)
        else:
            stuartSscore += (stringLenght - i)

    if kevinSscore > stuartSscore:
        print('Kevin', kevinSscore)
    elif kevinSscore < stuartSscore:
        print('Stuart', stuartSscore)
    else:
        print('Draw')

if __name__ == '__main__':
    s = raw_input()
    minion_game(s)