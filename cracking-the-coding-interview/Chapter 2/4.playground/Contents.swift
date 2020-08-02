/*
 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need to be after the elements less than x (see below).Inthe partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
 
 EXAMPLE
 Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

class Node {
    var value: Int
    var next: Node?
    
    init(_ value: Int) {
        self.value = value
    }
    
    public func append(value: Int) {
        let node = Node(value)
        var current = self
        while current.next != nil {
            current = current.next!
        }
        current.next = node
    }
    
    public func iterate() {
        var current: Node? = self
        while current != nil {
            print(current!.value)
            current = current?.next
        }
    }

    // solution using 2 arrays: space - O(n), time - O(n)
    public func partition(by value: Int) {
        var leftPartition = [Int](), rightPartition = [Int]()
        
        var current: Node? = self
        while current != nil {
            if current!.value < value {
                leftPartition.append(current!.value)
            } else {
                rightPartition.append(current!.value)
            }
            current = current!.next
        }
        
        self.value = leftPartition[0]
        current = self
        for index in 1..<leftPartition.count {
            current!.next = Node(leftPartition[index])
            current = current!.next
        }
        for item in rightPartition {
            current!.next = Node(item)
            current = current!.next
        }
    }
}

let node  = Node(3)
node.append(value: 5)
node.append(value: 8)
node.append(value: 5)
node.append(value: 10)
node.append(value: 2)
node.append(value: 1)
node.partition(by: 5)
node.iterate()

