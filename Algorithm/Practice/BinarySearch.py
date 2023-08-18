# Input: Sorted Array, Key
# Output: Index of Key in Array
# Time Complexity: O(logn)
# Space Complexity: O(1)

def binarySearch(arr, key):
    start = 0
    end = len(arr) - 1
    while start <= end:
        mid = (start+end)//2
        if arr[mid] == key:
            return mid
        elif arr[mid] < key:
            start = mid + 1
        else:
            end = mid - 1
    return -1


arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
key = 11
print(binarySearch(arr, key))
