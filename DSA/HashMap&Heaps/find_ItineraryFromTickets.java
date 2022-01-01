import java.util.* ;

//Ques Link - https://classroom.pepcoding.com/myClassroom/the-placement-program-pitampura-apr-19-2021/hashmap-and-heap-level-2/find-itinerary-from-tickets-official/ojquestion

public class find_ItineraryFromTickets {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		HashMap<String, Boolean> psrc = new HashMap<>() ;
		
		for(String src : map.keySet()){
		    String dest = map.get(src) ;
		    
		    psrc.put(dest, false) ;
		    if(psrc.containsKey(src) == false){
		        psrc.put(src, true) ;
		    }
		}
		
		String src = "" ;
		for(String pot : psrc.keySet()){
		   Boolean val = psrc.get(pot) ;
		   
		   if(val == true){
		       src = pot ;
		       break ;
		   }
		}
		while(true){
		    if(map.containsKey(src) == true){
		        System.out.print(src + " -> ") ;
		        src = map.get(src) ;
		        
		    }else{
		        System.out.print(src + ".") ;
		        break ;
		    }
		}
	}
}
