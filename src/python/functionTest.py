a = 4
def funRun(n):
	b = 3
	if b < a and a < 10:
		b *= n
	elif a > 10:
		b = a / b - 1
	else:
		b = a * n + b * n
	return b
a = funRun(4)
print(a)
a = funRun(8)
print(a)
a = funRun(5)
print(a)