t = int(input())
for _ in range(t):
    n, x = map(int, input().split())
    q = n // 3
    r = n % 3
    grp = int((2 * q * x))
    sgl = int(r * x)
    print(grp + sgl)
