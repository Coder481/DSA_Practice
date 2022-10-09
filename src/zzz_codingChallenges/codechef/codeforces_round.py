'''def factor(n):
    if n==1:return 1
    for i in range(n-1,0,-1):
        if n%i==0:
            return i
for _ in range(int(input())):
    count=0
    e=int(input())
    i=1
    last=e
    temp=e
    while i<=temp:

        if factor(e)==1:
            last-=1
            count+=1
        else:
            last = last/factor(int(last))
            count+=1
        if last<=1:
            if last==0:
                count-=1
            break

        e=int(last)
        i+=1
    print(count)'''

'''lw=[15,40,50,20,25]
cw=[30,20,60,25,15]

def percent(a,b):
    return int((a-b)*100)/b

for i in range(0,5):
    res=percent(cw[i],lw[i])
    print(res)
'''
'''s=0
for i in range(1,101):
    s+=i
print(s)'''

'''f=2.3455
print("%.2f"%f)'''

'''def compute_hcf(x, y):
   while(y):
       x, y = y, x % y
   return x

for _ in range(int(input())):
    n = int(input())
    maximum = 0
    for i in range(2,n+1):
        for j in range(i+1,n+1):
            hcf = compute_hcf(i,j)
            if hcf > maximum:maximum = hcf
    print(maximum)'''

'''s,k = input().split()
k=int(k)
os = ''
for i in range(k):
    os += '9'
for j in range(k,len(s)):
    os += s[j]
print(os)'''

# Python3 program to find n-th number 
# in a series made of digits 4 and 7 

# Return n-th number in series made 
# of 4 and 7 
'''def printNthElement(n) : 
    

	# create an array of size (n + 1) 
	arr =[0] * (n + 1); 
	arr[1] = 4
	arr[2] = 7

	for i in range(3, n + 1) : 
		# If i is odd 
		if (i % 2 != 0) : 
			arr[i] = arr[i // 2] * 10 + 4
		else : 
			arr[i] = arr[(i // 2) - 1] * 10 + 7
	
	return arr[n] '''

'''def getValue(n):
    arr = [0]*(n+1)
    arr[1]=4
    if n!=1:
        arr[2]=7
    for i in range(3,n+1):
        if (i%2!=0):
            arr[i]=arr[i//2]*10+4
        else:
            arr[i]=arr[(i//2)-1]*10+7
    return arr[n]

vals = input()
val = int(vals)
con = (2**(len(vals)))-1
for i in range(con,2*con+1):
    ans = getValue(i)
    if ans == val:
        print(i)
        exit()'''


# This code is contributed by Nikita Tiwari. 


n=int(input())
count=0
for x in range(1,n+1):
    for y in range(1,n+1):
        for z in range(1,n+1):
            if (x*y+z)==n:
                count+=1
print(count)








