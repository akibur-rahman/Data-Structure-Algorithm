"""Binary Search Divides the list in half in each iteration. It relults in much faster search, time complexity: O(log n)"""

if __name__ == '__main__':
    list1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    element = int(input("Enter the element you want to search:"))
    start = 0
    end = len(list1)
    while (start <= end):
        mid=(start+end)//2
        if (element == list1[mid]):
            print("Item found at index:",mid)
            break
        elif (element > list1[mid]):
            start = mid+1
        else:
            end = mid-1
