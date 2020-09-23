from itertools import combinations

N = int(input())
letters = input().split()
K = int(input())

a_count = 0;
total_occurences = 0;

for i in combinations(letters,K):
    a_count += 'a' in i
    total_occurences += 1

print(a_count/total_occurences)