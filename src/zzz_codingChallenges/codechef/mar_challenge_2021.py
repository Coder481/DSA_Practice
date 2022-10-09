# 1. Interesting XOR!
'''def decimalToBinary(n): 
    return bin(n).replace("0b", "")
def binaryToDecimal(n): 
    return int(n,2)
for _ in range(int(input())):
    C = int(input())
    cStr = decimalToBinary(C)
    A,B='',''
    cStr = cStr[::-1] # reverse the string
    for i in range(len(cStr)):
        if i == (len(cStr)-1):
            A+='1'
            B+='0'
        else:
            if cStr[i]=='0':
                A+='1'
                B+='1'
            elif cStr[i] == '1':
                A+='0'
                B+='1'
    A=A[::-1]
    B=B[::-1]
    a = binaryToDecimal(A)
    b = binaryToDecimal(B)
    print(a*b)'''
