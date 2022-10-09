t = int(input())
for _ in range(t):
    x = int(input())
    if x % 5 == 0:
        tens = int(x/10)
        x = x % 10
        fives = int(x/5)
        print(tens + fives)
    else:
        print(-1)
