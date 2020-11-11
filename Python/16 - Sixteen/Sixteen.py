# https://www.hackerrank.com/challenges/validating-postalcode/problem

import re

P = input()

regex_integer_in_range = r"^[1-9][\d]{5}$"    # Do not delete 'r'.
regex_alternating_repetitive_digit_pair = r"(\d)(?=\d\1)"    # Do not delete 'r'.

print (bool(re.match(regex_integer_in_range, P))
       and len(re.findall(regex_alternating_repetitive_digit_pair, P)) < 2)


import re
P = input()

print (bool(re.match(regex_integer_in_range, P))
       and len(re.findall(regex_alternating_repetitive_digit_pair, P)) < 2)