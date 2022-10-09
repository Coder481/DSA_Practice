# 1. DIVTHREE
'''for _ in range(int(input())):
    n,k,d = map(int,input().split())
    l=[int(ele) for ele in input().split()]
    totalProb = sum(l)
    totalConts = totalProb // k
    if totalConts > d:print(d)
    else:print(totalConts)'''



# 2. DECODEIT
'''def binToDec(binary):     --> Binary to Decimal using int()
    return int(binary,2)
    
alStr,optStr = "abcdefghijklmnop" , ''    
for _ in range(int(input())):
    n=int(input())
    s=input()
    for i in range(0,len(s),4):
        st = s[i:i+4]
        optStr += alStr[binToDec(st)]
    print(optStr)  
    optStr=''  '''

'''def binaryToDecimal(binary):  --> Binary to decimal through long method (using loop) 
    binary1 = binary
    decimal,i,n = 0,0,0
    while(binary != 0 ):
        dec = binary % 10
        decimal = decimal + dec * pow(2,i)
        binary = binary//10
        i += 1'''

# 3. FAIRELCT
'''for _ in range(int(input())):
    count = 0
    n,m=map(int,input().split())
    nl = [int(ele) for ele in input().split()]
    ml = [int(ele) for ele in input().split()]
    nl.sort()
    ml.sort()
    ml.reverse()
    for i in range(min(len(nl),len(ml))):
        if sum(nl)<=sum(ml):
            temp = nl[i]
            nl[i] = ml[i]
            ml[i] = temp
            count+=1
        if sum(nl)>sum(ml):
            print(count)
            break
    else:print(-1)'''        

# 4. BILLRD
'''for _ in range(int(input())):
    n,k,x,y=map(int,input().split())
    if x < y:
        if k > 4:
            rem = k % 4
            if rem==1:print(x+n-y,n)
            elif rem==2:print(n,x+n-y)
            elif rem==3:print(y-x,0)
            elif rem==0:print(0,y-x)
        elif k<=4:
            if k==1:print(x+n-y,n)
            elif k==2:print(n,x+n-y)
            elif k==3:print(y-x,0)
            elif k==4:print(0,y-x)
    elif x > y:
        if k > 4:
            rem = k % 4
            if rem==1:print(n,y+n-x)
            elif rem==2:print(y+n-x,n)
            elif rem==3:print(0,x-y)
            elif rem==0:print(x-y,0)
        elif k<=4:
            if k==1:print(n,y+n-x)
            elif k==2:print(y+n-x,n)
            elif k==3:print(0,x-y)
            elif k==4:print(x-y,0)
    elif x==y:
        print(n,n)'''

#5
'''for _ in range(int(input())):
    n,k=map(int , input().split())
    l=[int(ele) for ele in input().split()]
    l.sort()
    l.reverse()
    l1,l2=[],[]
    y=0
    for i in range(len(l)):
        if sum(l1)<k and sum(l2)<k:
            if i%2==0:l1.append(l[i])
            elif i%2!=0:l2.append(l[i])
        elif sum(l1)>=k:
            l2.append(l[i])
            if sum(l2)>=k:
                y=len(l1)+len(l2)
                print(len(l1)+len(l2))
                break
            
        if y==(len(l1)+len(l2)):
            break
        
    else:print(-1)'''

class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        sum1,count=0,0
        for i in range(lowLimit,highLimit+1):
            l1=list(str(i))
            l =[int(e) for e in l1]
            s=sum(l)
            if s>=sum1:
                count+=1
        print(count)        


ob = Solution()
ob.countBalls(1,10)
