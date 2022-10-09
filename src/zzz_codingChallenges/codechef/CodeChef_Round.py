'''
for _ in range(int(input())):
    n,jump,crnt,myct=map(int,input().split())
    i=crnt
    while i<=(n*2):
        crnt+=jump
        temp=crnt-n
        if temp==myct:print('YES');break
        i+=jump
    else:print('NO')'''
'''
for _ in range(int(input())):
        n, k, x, y = map(int,input().split())
        i = 0
        while i <= n*2:         
            if x == y:
                print("YES")
                break
            x = (x+k) % n
            i = i + 1
        else: print("NO")
'''
'''
for _ in range(int(input())):
    n,k=map(int,input().split())
    l=[int(ele) for ele in input().split()]
    for i in range(len(l)):
        if l[i]<k:print(i+1);break
        try:
            l[i+1]+=l[i]-k
        except:continue
    else:print((l[len(l)-1]//k)+len(l))'''

'''for _ in range(int(input())):
    n,x,p,k=map(int,input().split())
    l=[int(ele) for ele in input().split()]
    l.sort()
    count=0
    if x in l:
        i=1
        while i<=n:
            if x==l[p-1]:print(count);break
            l[k-1]=min(l)
            l.sort()
            count+=1
            i+=1
    else:print(-1)'''


'''def IsPowerOfTwo(n):
    if n <= 0:
        return False
    else:
        return n & (n - 1) == 0
for _ in range(int(input())):
    n=int(input())
    if n==1:print(1);continue
    if IsPowerOfTwo(n):
        print(-1)
        continue
    l=[2,3,1]
    if n==3:print(*l);continue
    for i in range(4,n+1):
        if IsPowerOfTwo(i):
            l.append(i+1)
        elif IsPowerOfTwo(i-1):l.append(i-1)
        else:l.append(i)
    print(*l)'''



'''for _ in range(int(input())):
    n,x,p,k=map(int,input().split())
    l=[int(ele) for ele in input().split()]
    l.sort()
    count=0
    if x in l:
        i=1
        while i<=n:
            if x==l[p-1]:print(count);break
            if k>=p and l[p-1]>x:
                l[k-1]=min(l)-1
                l.sort()
                count+=1
            elif k<=p and l[p-1]<x:
                l[k-1]=max(l)+1
                l.sort()
                count+=1
            else:print(-1);break
            i+=1
    else:print(-1)'''


'''for _ in range(int(input())):
    c,d,l=map(int,input().split())
    if l%4!=0:print('no');continue
    if c<=2*d:
        legs=d*4
    elif c>2*d:
        legs=d*4+(c-2*d)*4
    maxlegs=(c+d)*4
    if l>=legs and l<=maxlegs:print('yes')
    else:print('no')'''
    

''' if l<d*4:print('no');continue
    if c<d:
        if l>(c+d)*4:print('no');continue'''


'''for _ in range(int(input())):
    l=[int(ele) for ele in input().split()]
    money,age=[l[0],l[1],l[2]],[l[3],l[4],l[5]]
    count=0
    for i in range(2):
        m=money[i]-money[i+1]
        a=age[i]-age[i+1]
        if (a<0 and m>0) or (a>0 and m<0) or (a==0 and m!=0) or (a!=0 and m==0):print("NOT FAIR");count+=1;break
    m=money[0]-money[2]
    a=age[0]-age[2]
    if (a<0 and m>0) or (a>0 and m<0) or (a==0 and m!=0) or (a!=0 and m==0):print("NOT FAIR");continue
    if count==0:print("FAIR")'''

'''n=int(input())
s=input().split()
hitcount=s.count('H')
losscount=s.count('M')
score=hitcount-losscount
if hitcount>=n/2:score+=n/2
print(int(score))'''

'''for _ in range(int(input())):
    x,y,z,n=map(int,input().split())
    F,A,M=n-y,n-z,n-x
    cost=(F*20)+(A*30)+(M*40)
    print(F,A,M,cost)'''

'''for _ in range(int(input())):
    l=[int(ele) for ele in input().split()]
    count=0
    for e in l:
        if e>7:count=1;break
    for i in range(len(l)):
        if i%2==0:
            l[i]=l[i]+1
        else:l[i]=l[i]+2
    if count==1:print('error')
    else:print(*l)'''


'''for _ in range(int(input())):
    n,k=map(int,input().split())
    l=[int(ele) for ele in input().split()]
    l.sort()
    for i in range(k):
        l[len(l)-1]+=l[len(l)-2]
        l[len(l)-2]=0
        l.sort()
    print(max(l)-min(l))'''
    

'''for _  in range(int(input())):
    x= input()
    leng = len(x)
    sum=0
    for i in range(1,leng+1):
        sum+=i
    sum = sum + 10*(int(x[0])-1)
    print(sum) '''
'''
for _  in range(int(input())):
    n=int(input())
    l=input().split()
    for i in range(n-1):
        temp,count=i,0
        while True:
            if len(l)==1:count+=1;break
               
            if i==0 and l[i]>l[i+1]:
                l[i] = int(l[i])
                l[i]+=1
                l[i]=str(l[i])
                l.pop(i+1)
                
            elif i==len(l) and l[i]>l[i-1]:
                l[i] = int(l[i])
                l[i]+=1
                l[i]=str(l[i])
                i-=1
                l.pop(i-1)
            if i!=0 and i!=len(l):
                print(i,l)
                try:
                    if l[i]>l[i+1] or l[i]>l[i-1]:
                        l[i] = int(l[i])
                        l[i]+=1
                        l[i]=str(l[i])
                        if l[i]>l[i+1]:l.pop(i+1)
                        else:i-=1;l.pop(i-1)
                except:break
            else:break
        
        if count!=0:print(temp+1);break
    else:print(-1)'''



'''for _ in range(int(input())):
    n=int(input())
    l=[int(ele) for ele in input().split()]
    mid = (n/2)-1
    nl=[]
    for i in range(n-1,-1,-1):
        if i > mid:
            nl.append(-1*l[i])
        else: nl.append(l[i])    
    print(*nl)'''

'''for _ in range(int(input())):
    n,m = map(int,input().split())
    l1,l2=[],[]
    for k in range(n):
        l1.append([int(ele) for ele in input().split()])
    for j in range(m):
        l2.append([int(ele) for ele in input().split()])
    for i in range(n):
        for j in range'''    
'''def countPlus(chr,l1):
    count=0
    for i in range(l1.index(chr)):
        if e =="+":count+=1
    return count
n=int(input())
for i in range(2*n):
    s=input()
    l1.append(s)
    if '-' in s:l2.append(s)
tempCount=0
for e in l2:
    count = countPlus(e,l1)
    for j in range(n,count-tempCount):
        nl.append(j)'''

'''l=" ABCDEFGHIJKLMNOPQRSTUVWXYZ"
n=int(input())

s=''
if n<=0:print('Invalid column!!');exit()
if 1<=n<=26:print(l[n]);exit()
elif n in range(27,((26**2)+(26*1))+1):
    que=n//26
    rem=n%26
    if rem==0:
        s += l[que-1]+"Z"
    else:
        s += l[que]+ l[rem]
elif n in range((26**2)+(26*1),((26**3)+(26*2))+1):
    que=n//((26**2)+(26*1))
    rem=n%((26**2)+(26*1))
    s+=l[que]
    newN=rem+26
    que1=newN//((26**que)+(26*(que-1)))
    rem1=newN%((26**que)+(26*(que-1)))
    if rem1==0:
        s += l[que1-1]+"Z"
    else:s += l[que1]+ l[rem1]
print(s)'''

'''for _ in range(int(input())):
    n=int(input())
    l=[int(ele) for ele in input().split()]
    l.sort()
    l.reverse()
    if(n==1):print(l[0]);continue
    i,count=0,0
    while(i==0):
        dif=abs(l[i]-l[i+1])
        count+=min(l[i],l[i+1])
        l.pop(0)
        l.pop(0)
        l.insert(0,dif)
        if(len(l)==1):
            i,count=1,count+l[0]
    print(count)'''

# L[] = list of prime numbers
'''def firstNPrimeNumbers(a):
    count=0
    l=[]
    x=1
    while True:
        x+=1
        for i in range(2,x):
            if x%i==0:
               break
        else:
          count+=1
          l.append(x)    
           
        if count==n:
           return l


for _ in range(int(input())):
    n=int(input())
    b=[int(ele) for ele in input().split()]
    firstN=firstNPrimeNumbers(n)
    print(firstN)
    for i in range(1,n+1):
        firstN[i-1]=firstN[b[i-1]-1]
    print(firstN)'''


'''def SieveOfAtkin(limit): 
  
    # 2 and 3 are known 
    # to be prime 
    list =[]
    if (limit > 2): 
        list.append(2) 
    if (limit > 3): 
        list.append(3)
  
    # Initialise the sieve  
    # array with False values 
    sieve = [False] * limit 
    for i in range( 0 , limit ): 
        sieve[i] = False
    x = 1
    while(x * x < limit ) : 
        y = 1
        while(y * y < limit ) : 
              
            # Main part of  
            # Sieve of Atkin 
            n = (4 * x * x) + (y * y) 
            if (n <= limit and (n % 12 == 1 or 
                                n % 12 == 5)): 
                sieve[n] ^= True
  
            n = (3 * x * x) + (y * y) 
            if (n <= limit and n % 12 == 7): 
                sieve[n] ^= True
  
            n = (3 * x * x) - (y * y) 
            if (x > y and n <= limit and 
                          n % 12 == 11): 
                sieve[n] ^= True
            y += 1
        x += 1
      
    # Mark all multiples of  
    # squares as non-prime 
    r = 5
    while(r * r < limit) : 
        if (sieve[r]) : 
            for i in range(r * r, limit, r * r): 
                sieve[i] = False
          
    # Print primes 
    # using sieve[] 
    for a in range(5 , limit ): 
        if (sieve[a]): 
            list.append(a)

    return list

print(SieveOfAtkin(5))'''



'''def extractCount(s,k):
    temp=s
    count=0
    m,i='M','I'
    for e in s:
        if e==m:
            indx=temp.index(e)
            for j in range(indx+1,len(temp)):
                if temp[j]==i:
                    S = (temp[indx+1:j]).count(":")
                    P = k+1-abs(j-indx)-S
                    if P>0:count+=1
            temp=temp[indx+1:len(temp)]

        elif e==i:
            indx=temp.index(e)
            for j in range(indx+1,len(temp)):
                if temp[j]==m:
                    S = (temp[indx+1:j]).count(":")
                    P = k+1-abs(j-indx)-S
                    if P>0:count+=1
            temp=temp[indx+1:len(temp)]
    return count'''



def extractCount(s,k):
    l=list(s)
    count=0
    m,i="M",'I'
    for e in l:
        if e==m:
            colon=0
            for j in range(l.index(e)+1,len(l)):
                if l[j]==":":colon+=1
                if l[j]==i:
                    P = k+1-abs(j-l.index(e))-colon
                    if P>0:count+=1
                    l[j]='0'
                    l[l.index(e)]='0'

            colon=0
            for d in range(l.index(e)-1,-1,-1):
                if l[d]==":":colon+=1
                if l[d]==i:
                    P = k+1-abs(d-l.index(e))-colon
                    if P>0:count+=1
                    l[d]='0'
                    l[l.index(e)]='0'
    return count

total=0        
for _ in range(int(input())):
    n,k=map(int,input().split())
    s=input()
    l=s.split('X')
    for e in l:
        print(extractCount(e,k))
        total+=extractCount(e,k)
    print(total)






