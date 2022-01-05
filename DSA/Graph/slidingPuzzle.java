import java.util.* ;
//Leetode 773 - https://leetcode.com/problems/sliding-puzzle/
class slidingPuzzle {
    
    public static int slidingPuzzle(int[][] board) {
    String target = "123450";
    StringBuilder sb = new StringBuilder() ;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        sb.append(board[i][j]) ;
      }
    }
    String initial = sb.toString() ;
    HashSet<String> visited = new HashSet<>();

    int[][] swapIdx = { 
        { 1, 3 } ,  // idx == 0
        { 0, 2, 4 } , //idx == 1
        { 1, 5 } ,  // idx == 2
        { 0, 4 } , //idx ==3
        { 1, 3, 5 } , //idx == 4
        { 2, 4 } //idx == 5
    } ;

    LinkedList<String> queue = new LinkedList<>();

    queue.addLast(initial);
    visited.add(initial);
        
    int level = 0;
    while (queue.size() > 0) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String rem = queue.removeFirst();

        if (rem.equals(target)) {
          return level ;
        }

        int idx = -1 ;
        for(int k = 0; k < rem.length(); k++){
            if(rem.charAt(k) == '0'){
                idx = k;
                break ;
            }
        }
        int swapArr[] = swapIdx[idx] ;
          
        for (int j = 0; j < swapArr.length; j++) {
          String swappedString = swapChar(rem, idx, swapArr[j]);
            
          if (visited.contains(swappedString)) {
            continue;
          }
            
          visited.add(swappedString);
          queue.addLast(swappedString);

        }
      }
      level ++;
    }
    return -1;
  }

  private static String swapChar(String str, int idx, int j) {
    StringBuilder sb = new StringBuilder(str);
    sb.setCharAt(idx, str.charAt(j));
    sb.setCharAt(j, str.charAt(idx));
      
    return sb.toString();
  }
}