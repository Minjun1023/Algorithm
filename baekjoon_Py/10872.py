def factorial(N):
    result = 1
    if N > 0:
        result = N * factorial(N-1)
    return result

N = int(input())
print(factorial(N))
    