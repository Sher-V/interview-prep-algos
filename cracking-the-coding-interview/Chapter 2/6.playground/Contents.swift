/*
 Palindrome: Implement a function to check if a linked list is a palindrome.
 */

class Node {
    var value: Character
    var next: Node?
    
    init(_ value: Character) {
        self.value = value
    }
    
    func append(_ value: Character)  {
        let node = Node(value)
        var current = self
        while current.next != nil {
            current = current.next!
        }
        current.next = node
    }
}

func reverse(node: Node) -> Node {
    var head: Node?
    var current: Node? = node
    while current != nil {
        let n = Node(current!.value) // A B C
        n.next = head // ->
        head = n
        current = current!.next
    }
    
    return head!
}

func isPalindromeSecond(node: Node) -> Bool {
    var current: Node? = node,
        reversed: Node? = reverse(node: node)
    
    while current != nil {
        guard current!.value == reversed!.value else {
            return false
        }
        current = current!.next
        reversed = reversed!.next
    }
    
    return true
}

func isPalindrome(node: Node) -> Bool {
    var current: Node? = node, str = [Character]()
    while current != nil {
        str.append(current!.value)
        current = current!.next
    }
    
    var j = str.count - 1
    for i in 0..<str.count / 2 {
        guard str[i] == str[j] else {
            return false
        }
        j -= 1;
    }
    
    return true
}

let node = Node("r")
node.append("B")
node.append("C")
node.append("B")
node.append("r")
isPalindrome(node: node)
isPalindromeSecond(node: node)
let reversedList = reverse(node: node)

