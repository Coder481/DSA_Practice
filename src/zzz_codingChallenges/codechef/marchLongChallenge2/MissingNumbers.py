def solve(a1, b1, inpt):
    if (a1 % 1 == 0) and (a1 != 0) and (b1 % 1 == 0) and (b1 != 0):
        if ((int((a1 / b1)) == inpt[1]) and
                (a1 * b1 == inpt[3]) and
                (a1 >= 1) and
                (b1 >= 1) and
                (a1 <= 10000) and (b1 <= 10000)):
            print(int(a1), int(b1))
            return 1
    return 0


for _ in range(int(input())):
    inpt = list(map(int, input().split()))
    inpt.sort()
    a1 = (inpt[2] + inpt[0]) / 2
    b1 = inpt[2] - a1
    a2 = (inpt[2] + inpt[1]) / 2
    b2 = inpt[2] - a2
    a3 = (inpt[3] + inpt[0]) / 2
    b3 = inpt[2] - a3
    a4 = (inpt[3] + inpt[1]) / 2
    b4 = inpt[2] - a4

    first = solve(a1, b1, inpt)
    if first == 0:
        second = solve(a2, b2, inpt)
        if second == 0:
            third = solve(a3, b3, inpt)
            if third == 0:
                fourth = solve(a4, b4, inpt)
                if fourth == 0:
                    print(-1, -1)

'''def solve():
    inpt = list(map(int,input().split()))
    inpt.sort()
    print(inpt)
    maxItem = max(inpt)
    factors = list()
    j = 0
    for i in range(1,maxItem+1):
        if(maxItem % i == 0):
            factors.append(i)
            #factors.append(int(maxItem / i))
            j += 1
            if(j == 1 or factors.__len__() == 1) : continue

            comp = list()

            jTh = factors.__getitem__(j)
            prevJ = factors.__getitem__(j-1)

            comp.append(prevJ + jTh)
            comp.append(prevJ - jTh)
            comp.append(prevJ * jTh)
            comp.append(prevJ // jTh)

            comp.sort()

            print(comp)
        
            if(inpt == comp):
                print(prevJ, jTh)
                break
    else :
        print("-1 -1")

        
    
    for j in range(0, factors.__len__()-1):
        comp = list()

        jTh = factors.__getitem__(j)
        nextJ = factors.__getitem__(j+1)

        comp.append(jTh + nextJ)
        comp.append(jTh - nextJ)
        comp.append(jTh * nextJ)
        comp.append(jTh // nextJ)

        comp.sort()

        print(comp)
        
        if(inpt == comp):
            print(jTh, nextJ)
            break
    else:
        print("-1 -1")

for _ in range(int(input())):
    solve()






if((a1%1==0) and (a1!=0) and (b1%1==0) and (b1!=0)):
          if((int((a1/b1)) == inpt[1]) and 
          (a1*b1==inpt[3]) and 
          (a1>=1) and 
          (b1>=1) and 
          (a1<=10000) and (b1<=10000)):
            print(int(a1),int(b1))
            continue

    
    if((a2%1==0) and (a2!=0) and (b2%1==0) and (b2!=0)):
          if((int((a2/b2))== inpt[1]) and 
          (a2*b2==inpt[3]) and 
          (a2>=1) and 
          (b2>=1) and 
          (a2<=10000) and (b2<=10000)):
            print(int(a2),int(b2))
            continue
    
    
    if((a3%1==0) and (a3!=0) and (b3%1==0) and (b3!=0)):
          if((int((a3/b3))== inpt[1]) and 
          (a3*b3==inpt[3]) and 
          (a3>=1) and 
          (b3>=1) and 
          (a3<=10000) and (b3<=10000)):
            print(int(a3),int(b3))
            continue
    
    
    if((a4%1==0) and (a4!=0) and (b4%1==0) and (b4!=0)):
          if((int((a4/b4))== inpt[1]) and 
          (a4*b4==inpt[3]) and 
          (a4>=1) and 
          (b4>=1) and 
          (a4<=10000) and (b4<=10000)):
            print(int(a4),int(b4))
            continue
    
    print(-1,-1)
















import math
t = int(input())
for _ in range(t):
    inpt = list(map(int,input().split()))

    inpt.sort()

    mult = inpt.__getitem__(3)
    addition = inpt.__getitem__(2)

    if(addition == 1 and mult == 2):
        temp = mult
        mult = addition
        addition = temp
    

    # Quadratic roots
    a,b,c = 1, -1*addition, mult
    rootCheck = (b*b) - (4*a*c)
    if(rootCheck < 0) : 
        print("-1 -1")
        continue
    a1 = int(((-1*b) + math.sqrt(rootCheck)) / (2*a))
    a2 = int(((-1*b) - math.sqrt(rootCheck)) / (2*a))
    b1 = int(addition - a1)
    b2 = int(addition - a2)

    # checks for a1 and b1
    temp1 = inpt.copy()
    if(temp1.__contains__(a1 + b1)):
        temp1.remove(a1 + b1)
        if(temp1.__contains__(a1 - b1)):
            temp1.remove(a1 - b1)
            if(temp1.__contains__(a1 * b1)):
                temp1.remove(a1 * b1)
                if(temp1.__contains__(a1 // b1)):
                    print(a1,b1)
                    continue


    # check for a2 and b2
    temp2 = inpt.copy()
    if(temp2.__contains__(a2 + b2)):
        temp2.remove(a2 + b2)
        if(temp2.__contains__(a2 - b2)):
            temp2.remove(a2 - b2)
            if(temp2.__contains__(a2 * b2)):
                temp2.remove(a2 * b2)
                if(temp2.__contains__(a2 // b2)):
                    print(a2,b2)
                    continue


    # nothing found
    print("-1 -1")'''
