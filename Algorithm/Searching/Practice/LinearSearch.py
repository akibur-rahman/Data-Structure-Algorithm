# Liner Search searches elements one by one

if __name__ == '__main__':
    list1 = [6, 2, 3, 5, 9, 12, 1]
    number = int(input("Enter the number:"))
    for i in range(len(list1)):
        if (list1[i] == number):
            print("Number found at index", i)
            break
    else:
        print("Number Not Found")
