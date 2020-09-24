import sys
import itertools

lines = sys.stdin.readlines()
letters = lines[1].split()

total = 0
count = 0
for c in itertools.combinations(letters, int(lines[2])):
    if 'a' in c:
        count+=1
    total+=1
print(count/total)
