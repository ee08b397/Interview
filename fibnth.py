def getithElementofNFib(n, k):
    code = []
    for i in range(n - k - 1):
		code.append(0)

    if k != 0:
        code.append(1)
    return code

for i in range(8):
    print i, " ", getithElementofNFib(8, i)
