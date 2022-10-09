# Chef And Meetings
'''
def convertToSecond(time,mode):
    if mode=="AM":
        ts = time.split(":")
        hr = int(ts[0])
        mn = int(ts[1])
        if hr==12:
            hr = 0
        return (hr*3600)+(mn*60)
    elif mode=="PM":
        ts = time.split(":")
        hr = int(ts[0])
        mn = int(ts[1])
        if hr!=12:
            hr+=12
        return (hr*3600)+(mn*60)

for _ in range(int(input())):
    il=input().split()
    pSeconds = int(convertToSecond(il[0],il[1]))
    os = ""
    for i in range(int(input())):
        s = input().split()
        startTimeSec = int(convertToSecond(s[0],s[1]))
        endTimeSec = int(convertToSecond(s[2],s[3]))
        if startTimeSec<=pSeconds<=endTimeSec:
            os+="1"
        else : os+="0"
    print(os)'''

'''import time
start_time = time.time()
for i in range(2950000):
    s=i
print("--- %s seconds ---" % (time.time() - start_time))'''
'''import time
start_time = time.time()
for _ in range(int(input())):
    n,k = map(int,input().split())
    d = {'a':n,'b':1}
    if k==1:print(d['b'])
    else:
        if n%2==0:
            if n==k:print(n)
            else:print(k%n)
        else:
            for i in range(1,k):
                d['a'] -= 1
                if d['a'] < 1: d['a'] += n
                d['b']+=1
                if d['b']==d['a']:d['b']+=1
                if d['b']>n:d['b'] -= n
                if d['b']==d['a']:d['b']+=1
            print(d['b'])

print("--- %s seconds ---" % (time.time() - start_time))'''


'''
# CODECHEF LUNCHTIME
def gcd(p,q):
# Create the gcd of two positive integers.
    while q != 0:
        p, q = q, p%q
    return p
def is_coprime(x, y):
    return gcd(x, y) == 1

for _ in range(int(input())):
    L,R = map(int,input().split())
    i = 2
    while i<=(2*(10**9)):
        for j in range(L,R+1):
            if not(is_coprime(i,j)):
                break
        else:print(i)'''
s=input()
count = 1
noOfSeg = 0
for i in range(len(s)):
    if s[i]=='1':
        if i==len(s)-1:
            if count > 1:
                 noOfSeg += 1
            break
        if s[i+1] == '1':
            count+=1
        elif s[i+1] == '0': 
            if count > 1:
                 noOfSeg += 1
            count = 1
if noOfSeg>=1:print("true")
else:print("false")