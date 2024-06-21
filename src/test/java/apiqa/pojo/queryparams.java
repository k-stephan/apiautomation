package apiqa.pojo;

import java.util.HashMap;
import java.util.Map;

public class queryparams 
{
	public static Map<String, String> qryparamspost ()

	{
		
			/* POST QUERY PARAM */ 
			String listid="6666c6883914de79c5d75831";
			String keyid="2bd7522b743d8b866f32fd6e11c3e075";
			String tokenid="ATTAd20850be2948d1f7fda563f7ef8571931eeb2877ebbcb4d8daa1aa00db28c83f6B1D7D5A";
			String name="TRELLO-CREATE-FROM_SELENIUM-QA1";
		
			Map<String, String> queryparams  = new HashMap<String, String>(); 
			queryparams.put("idList", listid);
			queryparams.put("key", keyid);
			queryparams.put("token", tokenid);
			queryparams.put("name", name);
			
			return queryparams;
	
	}
	
			public static Map<String, String> qryparamsget ()
		
			{
				
					/* GET QUERY PARAM */ 
					String keyid="2bd7522b743d8b866f32fd6e11c3e075";
					String tokenid="ATTAd20850be2948d1f7fda563f7ef8571931eeb2877ebbcb4d8daa1aa00db28c83f6B1D7D5A";
				
					Map<String, String> queryparams  = new HashMap<String, String>(); 
					queryparams.put("key", keyid);
					queryparams.put("token", tokenid);
					
					return queryparams;
			
			}
			
			
					public static Map<String, String> qryparamsput ()
		
					{
						
							/* PUT QUERY PARAM */ 
							String keyid="2bd7522b743d8b866f32fd6e11c3e075";
							String tokenid="ATTAd20850be2948d1f7fda563f7ef8571931eeb2877ebbcb4d8daa1aa00db28c83f6B1D7D5A";
							String name="TRELLO-UPDATE-FROM_SELENIUM-QA123";
							String desc="TRELLO-DESC-FROM_SELENIUM-QA123";

						
							Map<String, String> queryparams  = new HashMap<String, String>(); 
							queryparams.put("key", keyid);
							queryparams.put("token", tokenid);
							queryparams.put("name", name);
							queryparams.put("desc", desc);
							
							return queryparams;
					
					}
}
