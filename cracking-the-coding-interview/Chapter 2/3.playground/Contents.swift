class Node<T> {
    var value: T
    var next: Node<T>?
    
    init(value: T) {
        self.value = value
    }
    
    public func append(value: T) {
        let node = Node(value)
        var current = self
        while current.next != nil {
            current = current.next!
        }
        current.next = node
    }
    
    public func deleteMiddleNode(node: Node) {
        if (node.next == nil) { return }
        node.value = node.next!.value
        node.next = node.next!.next
    }
    
    public init(_ value: T) {
        self.value = value    }
}

let node = Node<Int>(5)
node.append(value: 1)
node.append(value: 4)
node.append(value: 5)

node.deleteMiddleNode(node: node.next!)








