//Leetcode 811 - https://leetcode.com/problems/subdomain-visit-count/
import java.util.* ;
class subDomainVisitCounts {
    HashMap<String, Integer> map ;
    List<String> ans ;
    public List<String> subdomainVisits(String[] cpdomains) {
        map = new HashMap<>() ;
        int visitCount = 0 ;
        
        for(String domain : cpdomains){
            String st[] =  domain.split(" ") ;
            visitCount = Integer.parseInt(st[0]) ;
            
            String[] splitted = st[1].split("\\.") ;
            StringBuilder sb = new StringBuilder() ;
            
            for(int i = splitted.length - 1; i >= 0; i--){
                if(i == splitted.length - 1){
                    sb.append(splitted[i]) ;
                    
                }else{
                    sb.insert(0, ".") ;
                    sb.insert(0, splitted[i]) ;
                    
                }
                
                String subDomain = sb.toString() ;
                map.put(subDomain, map.getOrDefault(subDomain, 0) + visitCount) ;
            }
        }
        
        ans = new ArrayList<>() ;
        for(String subdomains : map.keySet()){
            StringBuilder sb = new StringBuilder() ;
            sb.append(map.get(subdomains)) ;
            sb.append(" ") ;
            sb.append(subdomains) ;
            ans.add(sb.toString()) ;
        }
        return ans ;
    }
}
