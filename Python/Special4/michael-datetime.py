#!/bin/python3

import math
import os
import random
import re
import sys
from dateutil.parser import parse

# Complete the time_delta function below.
def time_delta(t1, t2):
    delta = parse(t1) - parse(t2)
    return "{:.0f}".format(abs(delta.total_seconds()))

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        t1 = input()

        t2 = input()

        delta = time_delta(t1, t2)

        fptr.write(delta + '\n')

    fptr.close()
