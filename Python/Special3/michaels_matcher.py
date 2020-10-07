# Enter your code here. Read input from STDIN. Print output to STDOUT
import re

num_lines = int(input())
for i in range(0, num_lines):
    credit_card = input()
    valid = re.match('^[456].*', credit_card)
    valid = valid and (re.match('^[0-9]{16}$', credit_card) or re.match('^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$', credit_card))
    stripped_credit_card = re.sub('-','', credit_card)
    valid = valid and not re.match(".*(?P<num>[0-9])(?P=num)(?P=num)(?P=num).*", stripped_credit_card)
    if valid:
        print('Valid')
    else:
        print('Invalid')

