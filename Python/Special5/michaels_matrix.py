#!/bin/python3

import math
import os
import random
import re
import sys




first_multiple_input = input().rstrip().split()

n = int(first_multiple_input[0])

m = int(first_multiple_input[1])

matrix = []

for _ in range(n):
    matrix_item = input()
    matrix.append(matrix_item)

join_list = []
for column in range(m):
    for row in range(n):
        join_list.append(matrix[row][column])

real_ordered_message = ''.join(join_list)
decoded_message = re.sub('(?<=[a-zA-Z0-9])[^a-zA-Z0-9]+(?=[a-zA-Z0-9])', ' ', real_ordered_message)
print(decoded_message)

