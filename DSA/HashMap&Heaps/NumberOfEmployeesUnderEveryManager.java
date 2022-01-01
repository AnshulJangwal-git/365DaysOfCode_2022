import java.util.* ;
import java.io.* ;
//Ques Link - https://nados.pepcoding.com/content/eb9863ac-63ac-4b94-881f-0aeb24df0985/0c54b191-7b99-4f2c-acb3-e7f2ec748b2a/7fdb0602-0ac9-4484-aff9-a898aed5cd28/d108313e-68c8-4fc6-bb02-6e9a9010ef9e/ec6515dc-6811-4c65-912f-0134b65df120/question/cdafb7ba-f3d5-46ad-9489-fc0c2490c274

public class NumberOfEmployeesUnderEveryManager{
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;

        HashMap<String, String> map = new HashMap<>() ;
        for(int i = 0; i < n; i++){
            map.put(sc.next(), sc.next()) ;
        }

        findCount(map) ;

    }

    public static void findCount(HashMap<String, String> map){
        HashMap<String, HashSet<String>> tree = new HashMap<>() ;
        String ceo = "" ;
         for(String emp : map.keySet()){
             String man = map.get(emp) ;

             if(man.equals(emp)){
                 ceo = man ;

             }else{
                if(tree.containsKey(man)){
                    HashSet<String> emps = tree.get(man) ;
                    emps.add(emp) ;

                }else{
                    HashSet<String> emps = new HashSet<>() ;
                    emps.add(emp) ;
                    tree.put(man, emps) ;

                }
             }
         }

         HashMap<String, Integer> result = new HashMap<>() ;
         getSize(tree, ceo, result) ;

         for(String emp : result.keySet()){
             System.out.println(emp + " " + result.get(emp)) ;
         }
    }

    public static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String, Integer> result){
        if(tree.containsKey(man) == false){
            result.put(man, 0) ;
            return 1 ;
        }

        int sz = 0 ;
        for(String emp : tree.get(man)){
            int cs = getSize(tree, emp, result) ;
            sz += cs ;
        }
        result.put(man, sz) ;
        return sz + 1 ;
    }
}