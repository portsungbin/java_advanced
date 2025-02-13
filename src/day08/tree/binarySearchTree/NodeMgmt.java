package day08.tree.binarySearchTree;

//1. Node 생성 => Root
//2. BST에 데이터 넣은 기능 구현
public class NodeMgmt {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;

        }
    }

    public boolean insertNode(int data) {


        //CSSE1 : Node가 하나도 없을때
        if (this.head == null) {
            this.head = new Node(data);
        } else { //CASE2 : Node가 하나 이상 들어가 있을때
            Node findNode = this.head;
            while (true) {
                //CASE2-1 : 현재 Node의 왼쪽에 노드가 들어가야할때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;

                    } else {
                        findNode.left = new Node(data);
                        break;
                    }

                    //CASE2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할때

                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }

            }
        }

        return true;
    }

    public Node search(int data) {
        //CASE 1 : Node가 하나도 없을때
        if (this.head == null) {
            return null;

            //CASE 2 : Node가 하나 이상일때
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
        }
        return null;
    }

    //Node 삭제
    public boolean deleteNode(int data) {
        // 트리가 비어있으면 삭제할 수 없으므로 false 반환
        if (this.head == null) {
            return false;
        }

        // 삭제할 노드(current)와 그 부모 노드(parent)를 찾기 위한 변수
        Node parent = null;
        Node current = this.head;

        // 삭제할 노드를 찾는 과정
        while (current != null && current.value != data) {
            parent = current;
            if (data < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // 삭제할 노드를 찾지 못한 경우
        if (current == null) {
            return false;
        }

        // -----------------------------
        // Case 1: 삭제할 노드가 리프 노드(자식이 없는 경우)
        // -----------------------------
        if (current.left == null && current.right == null) {
            // 삭제할 노드가 루트 노드라면 head를 null로 설정
            if (current == head) {
                head = null;
            } else {
                // 부모 노드의 해당 링크를 null로 변경하여 current를 제거
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        // -----------------------------
        // Case 2: 삭제할 노드가 하나의 자식만 가진 경우
        // -----------------------------
        else if (current.left == null || current.right == null) {
            // 자식이 있는 쪽을 child에 저장
            Node child = (current.left != null) ? current.left : current.right;
            // 삭제할 노드가 루트인 경우, 자식을 새로운 루트로 설정
            if (current == head) {
                head = child;
            } else {
                // 부모 노드의 링크를 child로 연결하여 current를 대체
                if (parent.left == current) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }
        // -----------------------------
        // Case 3: 삭제할 노드가 두 개의 자식을 가진 경우
        // -----------------------------
        else {
            // **중위 후속자(In-order Successor) 찾기**
            // 중위 후속자는 삭제할 노드(current)의 오른쪽 서브트리에서
            // 가장 작은 값을 가진 노드입니다.
            Node successorParent = current;   // 후속자의 부모 노드
            Node successor = current.right;     // 오른쪽 자식에서 시작

            // 후속자 노드를 찾기 위해, 가능한 한 왼쪽으로 계속 이동
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            // 후속자의 값(successor.value)을 삭제할 노드(current)에 복사
            current.value = successor.value;

            // 후속자 노드 삭제 (후속자는 자식이 없거나 오른쪽 자식만 있을 수 있음)
            if (successorParent.left == successor) {
                // 후속자가 왼쪽 자식인 경우, 부모의 left 링크를 후속자의 오른쪽 자식으로 연결
                successorParent.left = successor.right;
            } else {
                // 후속자가 바로 current의 오른쪽 자식인 경우
                successorParent.right = successor.right;
            }
        }

        // 삭제가 성공적으로 완료되었음을 반환
        return true;
    }


}




