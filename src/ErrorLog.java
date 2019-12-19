public class ErrorLog {

	private String machineId;
	private String description;

	//** Precondition: message is a valid Error log entry *//*
	public ErrorLog(String message) {
		machineId = message.substring(0, message.indexOf(":"));
		description = message.substring(machineId.length()+1);
	}

	//** Returns true if the description in this error log entry
	 //contains keyword; false otherwise.
	 //*
	public boolean containsKey(String keyword) {
		//part b
		String s = getDescription();
		if (!s.contains(keyword)){
			return false;
		}
		int before = s.indexOf(keyword);
		int after = s.indexOf(keyword) + keyword.length();
		if (before == 0) {
			String z = s.substring(after, after + 1);
			if (z.equals("") || z.equals(" ")) {
				return true;
			}else{
				return false;
			}
		}
		if (s.length() == after){
			String t = s.substring(before - 1, before);
			if (t.equals(" ")){
				return true;
			}else{
				return false;
			}
		}
		String a = s.substring(after, after + 1);
		String b = s.substring(before - 1, before);
		if (b.equals(" ") && a.equals("") || a.equals(" ")){
			return true;
		}
	return false;
	}
	
	public String getMachineId() { return machineId;}
	public String getDescription() { return description; }

	public static void main(String[] args) {
		ErrorLog er1 = new ErrorLog("CLIENT2:security alert");
		ErrorLog er2 = new ErrorLog("Webserver:disk offline");
		ErrorLog er3 = new ErrorLog("SERVER22:file not found on disk3");
		ErrorLog er4 = new ErrorLog("SERVER15:read error on disk DSK7");
		ErrorLog er5 = new ErrorLog("SERVER22:write error on disk");
		ErrorLog er6 = new ErrorLog("Webserver:error on /dev/disk");
		
		System.out.println("message 1 " + er1.containsKey("disk"));
		System.out.println("message 2 " + er2.containsKey("disk"));
		System.out.println("message 3 " + er3.containsKey("disk"));
		System.out.println("message 4 " + er4.containsKey("disk"));
		System.out.println("message 5 " + er5.containsKey("disk"));
		System.out.println("message 6 " + er6.containsKey("disk"));


	}

}
/* Output
message 1 false
message 2 true
message 3 false
message 4 true
message 5 true
message 6 false
 */
