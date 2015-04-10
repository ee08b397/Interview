# @Question
# input = [(1,2), (5, 11), (2,3)]
# target = (0,0)
# int k << size(input)

# @Example
# get_k_closest(input, target, 2)
# [(1,2), (2,3)]

# @TODO: 
# double distance(Point a, Point b)
# Array<Point> get_k_closest(Array<Point> input, Point target, int k)

# @Method
# O(kn)        n    get all distances; k-th partial selection sort, k max(input)
# O(n+klogn)   n    get all distances; min-heap of size n, k heap_extract_root (but build heap O(nlogn)!)
# O(nlogk)     k    fill first k in max-heap; if next distance larger than the root distance, discard, 
#                   o/w, replace root and max_heapify; return heap

def get_k_closest(input, target, k):
    if k == 0 or input == None:
        return []
    if k >= len(input):
        return input
    maxheap = []
    for i in range(k):
        maxheap.append(Distance(input[i], target))
        
    build_max_heap(maxheap) # build a max-heap of size k by distance
    
    for i in range(k, len(input)):         
        if maxheap[0].pdistance > distance(input[i], target):
            maxheap[0] = (Distance(input[i], target))
            max_heapify(maxheap, 0)

    return toPointList(maxheap)

def distance(a, b):
    return (((a[0]) - b[0])**2 + ((a[1]) - b[1])**2 )**0.5

class Distance:
    def __init__(self, point, target):
        self.pdistance = distance(point, target)
        self.point = point
        
def build_max_heap(maxheap):
    for i in range(len(maxheap) // 2, -1, -1):
        max_heapify(maxheap, i)
            
def toPointList(maxheap, list = []):
    for i in range(len(maxheap)):
        list.append(maxheap[i].point)
    return list
    
def max_heapify(A, i):
    left = 2 * i + 1
    right = 2 * i + 2
    largest = i
    if left < len(A) and A[left].pdistance > A[largest].pdistance:
        largest = left
    if right < len(A) and A[right].pdistance > A[largest].pdistance:
        largest = right
    if largest != i:
        A[i], A[largest] = A[largest], A[i]
        max_heapify(A, largest)


print get_k_closest([(1,2), (5, 11), (2,3)], (0, 0), 2)
# print get_k_closest([(1,2), (5, 11), (2,3), (1,4)], (0, 0), 2)
# print get_k_closest([(1,2), (1, 3), (1,4)], (0, 0), 2) 




'''
def get_k_closest(input, target, k):
    rst = {}     #size k
    distances = {}    #size n for all distances
#     maxheap = build_max_heap(input[0:k+1])     
        
    for i in xrange(len(input)):
        distances[i] = distance(input[i])
        if maxheap.root.distance > distances[i]:
            maxheap.root = distances[i]
            maxheap.max_heapify()
'''

'''
class Point:
    int distance
    Point point
'''
