/*
 */
package covid_19; 

public class Database {
    
     
        public boolean AddPatientLabTestStatus(String PatientName,int Age,String Country,String Status){
            
            
            DatabaseCredentials db_credentials=new DatabaseCredentials();

            String HostName=db_credentials.HostName;
            String DatabaseName=db_credentials.DatabaseName;
            String UserName=db_credentials.UserName;
            String Password=db_credentials.Password;
            int Port=db_credentials.Port;
            
            return true;
        }
    
    
	public boolean addPatientRecord(CoronaPatient patient){
		
		//get patient credentials
                String lab_id=patient.getPatientInfo("lab_id");
		String name=patient.getPatientInfo("name");
		String age=patient.getPatientInfo("age");
		String country=patient.getPatientInfo("country");
		String marriage_status=patient.getPatientInfo("marriage_status");
		
		String status=patient.getPatientInfo("status");
		String action=patient.getPatientInfo("action");
                String test_date=patient.getPatientInfo("test_date");
		
		//perform database insert action
                DatabaseCredentials db_credentials=new DatabaseCredentials();
                 
                
                String HostName=db_credentials.HostName;
                String DatabaseName=db_credentials.DatabaseName;
                String UserName=db_credentials.UserName;
                String  Password=db_credentials.Password;
                int Port=db_credentials.Port;
		
		return true;
	}
    
}
