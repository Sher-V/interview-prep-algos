/*
 Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 
 EXAMPLE
 Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That  is, 617 + 295.
 Output: 2 -> 1 -> 9.That is, 912.
 */


class Node {
    var value: Int
    var next: Node?
    
    init(_ value: Int) {
        self.value  = value
    }
    
    func append(value: Int) {
        let node = Node(value)
        var current = self
        while current.next != nil {
            current = current.next!
        }
        current.next = node
    }
}

func sumLists(firstNumber: Node, secondNumber: Node) -> Node {
    let sum = Array(String(getNumber(node: firstNumber) + getNumber(node: secondNumber)))
    let node = Node(sum[sum.count - 1].wholeNumberValue!)
    var current = node
    for index in (0..<sum.count - 1).reversed() {
        current.next = Node(sum[index].wholeNumberValue!)
        current = current.next!
    }
    return node
}

func getNumber(node: Node) -> Int {
    var current: Node? = node
    var str = ""
    while current != nil {
        str.append(String(current!.value))
        current = current?.next
    }
    return Int(String(str.reversed()))!
}

var firstNumber = Node(7)
firstNumber.append(value: 1)
firstNumber.append(value: 6)
var secondNumber = Node(5)
secondNumber.append(value: 9)
secondNumber.append(value: 2)

var node = sumLists(firstNumber: firstNumber, secondNumber: secondNumber)


