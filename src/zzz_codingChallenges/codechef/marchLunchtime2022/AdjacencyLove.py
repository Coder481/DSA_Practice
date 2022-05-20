# Not accepted

def getSum(arr1):
    total = 0
    for j in range(0, len(arr1) - 1):
        total += (int(arr1[j]) * int(arr1[j + 1]))
    return total


def printArr(arrP):
    for e in arrP:
        print(e, end=" ")


t = int(input())
for _ in range(t):
    n = int(input())
    arr = input().split()
    i = 0
    flag = 0
    if getSum(arr) % 2 != 0:
        printArr(arr)
        continue
    tempArr = arr.copy()
    while True:
        # swap numbers
        a = tempArr[i]
        tempArr[i] = tempArr[i + 1]
        tempArr[i + 1] = a

        # check sum is odd
        if getSum(tempArr) % 2 != 0:
            printArr(tempArr)
            break

        # check is original arr appears or not
        if tempArr == arr:
            flag = -1
            break
    if flag == -1:
        print(-1)
