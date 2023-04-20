//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.ladoos(root, home, k) );
            t--;
        }
    }
}


// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class Solution{
   // Initialize a static variable to store the sum of ladoos
    static int totalLadoos;
    
     // Returns: the maximum number of ladoos that can be collected
    static int ladoos(Node root, int home, int k){
        // Initialize totalLadoos to 0
        totalLadoos = 0;
        // Call the traverse function to traverse the binary tree and add the ladoos
        traverse(root, home, k);
        // Return the total number of ladoos collected
        return totalLadoos;
    }     
    
    static int traverse(Node node, int target, int k){
    // if the current node is null, return -1
    if (node == null) return -1;
    
    // if the current node's data matches the target value, add the Ladoos for its subtree
    if (node.data == target) {
        // add Ladoos for the current node's subtree with distance 'k'
        addLadoos(node, k);
        // return k-1, which is the remaining distance from the target node
        return k - 1;
    }
    
    /* if the target node is not found in the current node's subtree, recursively search in its
    left subtree*/
    int dist = traverse(node.left, target, k);
    if (dist > -1) {
        /* if the target node is found in the left subtree, add the Ladoos for the right 
        subtree with distance 'dist-1'*/
        totalLadoos += node.data;
        addLadoos(node.right, dist - 1);
        // return dist-1, which is the remaining distance from the target node
        return dist - 1;
    }
    
    /* if the target node is not found in the current node's left subtree, recursively 
    search in its right subtree*/
    dist = traverse(node.right, target, k);
    if (dist > -1) {
        /* if the target node is found in the right subtree, add the Ladoos for the left subtree 
        with distance 'dist-1'*/
        totalLadoos += node.data;
        addLadoos(node.left, dist - 1);
        // return dist-1, which is the remaining distance from the target node
        return dist - 1;
    }
    
    // if the target node is not found in the current node's subtree or its subtrees, return -1
    return -1;
    }
    
    // Function to add the ladoos in the subtree rooted at a node
    // Parameters: node - the root of the subtree
    //             distance - the distance up to which ladoos will be distributed
    static void addLadoos(Node node, int distance){
        // If the node is null or distance is negative, return
        if( (node==null) || (distance<0) ) return;
        // Add the value of the current node to totalLadoos
        totalLadoos += node.data;
        // Recursively call the addLadoos function for the left and right subtrees with distance-1
        addLadoos(node.left, distance-1);
        addLadoos(node.right, distance-1);
    }

}

