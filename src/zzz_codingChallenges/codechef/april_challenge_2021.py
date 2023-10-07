# 1) Valid globalClasses.Pair
'''a,b,c = map(int,input().split())
s = set()
s.add(a)
s.add(b)
s.add(c)
if len(s) == 3:
    print("NO")
else:print("Yes")'''

# 2) World Record
'''for _ in range(int(input())):
    k1,k2,k3,v = map(float,input().split())
    finalSpeed = k1 * k2 * k3 * v
    finalTime = round(100 / finalSpeed , 2)
    if finalTime < 9.58:print("Yes")
    else : print("No")'''

'''l=[1,2,5,7,4,3]
for e in l:
    if e == 9:
        print("Yes")
        break
else:print("No")'''

# 3) Special Language
'''for _ in range(int(input())):
    n,k=map(int,input().split())
    s = input()
    count = 0
    countList = []
    for e in s:
        if e == '*':
            count += 1
        else : 
            count = 0
        if count >= k:
                print("Yes")
                break
    else : print("No")'''

#l=[["1","7","2","5","7"],["1","7","2","5","7"],["1","7","2","5","7"]]
#print(sum(list(map(int,l))))
l=[1,4,2,5]
print(sum(x for x in l))