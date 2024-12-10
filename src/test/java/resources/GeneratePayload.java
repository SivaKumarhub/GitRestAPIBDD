package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class GeneratePayload {
     public AddPlace addPlace(String name, String language,String address)  {
 		pojo.AddPlace p = new pojo.AddPlace();
 		p.setAccuracy(50);
 		p.setName(name);
 		p.setPhone_number("(+91) 983 893 3937");
         p.setAddress(address); 
         p.setWebsite("http://google.com");
         p.setLanguage(language);
         List<String> types = new ArrayList<String>();
         types.add("shoe park");
         types.add("shop");
         p.setTypes(types);
         Location l = new Location();
         l.setLat(-38.383494);
         l.setLng(33.427362);
         p.setLocation(l);
         return p;
     }
}
