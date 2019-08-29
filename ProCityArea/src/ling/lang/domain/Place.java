package ling.lang.domain;

public class Place {
		String code;
	    String name;
	    
	    public Place(){}
	    public Place(String code,String name){
	        this.code=code;
	        this.name=name;
	    }
	    
	    
	    public String getCode() {
	        return code;
	    }
	    public void setCode(String code) {
	        this.code = code;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
		@Override
		public String toString() {
			return "code=" + code + ", name=" + name;
		}
	    
}
