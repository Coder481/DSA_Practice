t = int(input())
for _ in range(t):
    n = input()
    j = len(n) - 1
    for i in range(0, len(n) - 1):
        submission = int(n[i]) + int(n[j])
        if submission % 2 == 0:
            print("YES")
            break
    else:
        print("NO")
