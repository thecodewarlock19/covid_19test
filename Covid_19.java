package covid_19;

import java.util.ArrayList;

/*
*@Author :Prince Kabutey aka @thecodewarlock
*Project : Corona Virus Patient Test
*covid-19 virus and patient test software and data structure with java
*/
class CoronaPatient {

	public String name;
	public String age;
	public String country;
	public String marriage_status;
	public String status;
	public String action;
        public String test_date;
        public String lab_id;
	
	public ArrayList<String> Symptoms_Array;

	public CoronaPatient(){
		this.name="";
		this.age="";
		this.country="";
		this.status="";
		this.action="";
		this.marriage_status="";
                this.test_date="";
                this.lab_id="";
		
		this.Symptoms_Array=new ArrayList<>();
	}
        
        public void addPatientSymptoms(String Symptoms){
            
            this.Symptoms_Array.add(Symptoms);
        }
        
        public ArrayList<String> getPatientSymtoms(){
            
            return this.Symptoms_Array;
        }
        
        /*
         get patient blood or fluid test result from 
        (patient blood or fluid test) database using the patient id
         note you can use any other unique info or credential
        */
        public boolean getBloodOrFluidTestResult(int patientId){
            
            TestLaboritory lab=new TestLaboritory();
            String p_status=lab.getBloodOrFluidTestResult(patientId);
            
            if(p_status=="positive"){
                
                return true;
            }else{
                
                return false;
            }

        }
	
	public String getPatientInfo(String attr_name){
		
                String result ="";
                
		switch(attr_name){
			
			case "name":
			
			result= this.name;
                        
			break;
			
			case "age":
			
			result= this.age;
			break;
			
			case "country":
			
			result= this.country;
			break;
			
			case "marriage_status":
			
			result= this.marriage_status;
			break;
			
			case "status":
			
			result= this.status;
			break;
			
			case "action":
			
			result= this.action;
			break;
                        
			case "test_date":
			
			result= this.test_date;
			break;
                        
			case "lab_id":
			
			result= this.lab_id;
			break;
			
		}
		
            return result;
	}
	
	public void Quaratine(){
		
	}
	
	public void Discharge(){
	
	}
	
	public void Isolate(){
	
	}
}

class CoronaVirus {
	
	public CoronaPatient patient;
	
	
	public CoronaVirus(CoronaPatient patient){
		this.patient=patient;
	}
	
	public boolean TestNow(){
            
            
                //symptomsConstants[0]=> cough 
                //symptomsConstants[1]=> fever  
                //symptomsConstants[2]=> tiredness 
                //symptomsConstants[3]=> difficulty breathing
                //String[] symptomsConstants={"cough","fever","tiredness","difficulty breathing"};
                
                //get patient symtoms 
                 ArrayList symtoms=this.patient.getPatientSymtoms();
                //System.out.println(this.patient.getPatintSymtoms());
                
                //id use for patient in (patient blood or fluid test) database
                //get patient lab_id
                String patientLabId=this.patient.getPatientInfo("lab_id");
                int patientId=25;
                                
                for (Object symtom : symtoms) {
                    //System.out.println(symtom);

                    if(symtom =="cough" || symtom =="fever" || symtom =="tiredness" || symtom =="difficulty breathing"  
                            || this.patient.getBloodOrFluidTestResult(patientId)){

                        return true;
                    }
                } 
		
		return false;
	}
	
	public boolean isSevere(){
            
                //symptomsConstants[0]=> cough 
                //symptomsConstants[1]=> fever  
                //symptomsConstants[2]=> tiredness 
                //symptomsConstants[3]=> difficulty breathing
                //String[] symptomsConstants={"cough","fever","tiredness","difficulty breathing"};
                
                //get patient symtoms 
                 ArrayList symtoms=this.patient.getPatientSymtoms();
                //System.out.println(this.patient.getPatintSymtoms());
                
                //id use for patient in (patient blood or fluid test) database
                //int patientId=25;
                //|| this.patient.getBloodOrFluidTestResult(patientId)
                
                for (Object symtom : symtoms) {
                    //System.out.println(symtom);

                    if(symtom =="difficulty breathing"){

                        return true;
                    }
                } 
		
		return false;
	}
	
}

class MysqlDatabase {
	
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
                String Password=db_credentials.Password;
                int Port=db_credentials.Port;
		
		return true;
	}
	
}

public class Covid_19 {
	
	public static void main(String[] args){
            
               TestLaboritory LabTest=new TestLaboritory();
               
               final String[] StatusConstants={"positive","negative"};
               
               String PatientName="James Smith";
               int PatientAge=30;
               String Country="CANADA";
               final String Status=StatusConstants[0];
               //LabTest.NewBloodOrFluidTest(PatientName, PatientAge, Country, Status);
		
		//patient
		CoronaPatient patient=new CoronaPatient();
		//set patient attrs or credentials
		patient.name="James Smith";
		patient.age="37";
		patient.country="CANADA";
		patient.marriage_status="married";
                patient.test_date="";
                patient.lab_id="25";
                
                //add symtoms 
                //symptomsConstants[0]=> cough 
                //symptomsConstants[1]=> fever  
                //symptomsConstants[2]=> tiredness 
                //symptomsConstants[3]=> difficulty breathing
                String[] symptomsConstants={"cough","fever","tiredness","difficulty breathing"};
                        
                patient.addPatientSymptoms(symptomsConstants[0]);
                patient.addPatientSymptoms(symptomsConstants[1]);
                patient.addPatientSymptoms(symptomsConstants[2]);
                patient.addPatientSymptoms(symptomsConstants[3]);
		
		//corona virus object and instance
		CoronaVirus covid_19=new CoronaVirus(patient);
		
		//database to store test record 
		MysqlDatabase database=new MysqlDatabase();
		
		//virus test expression
		boolean positive=covid_19.TestNow();
		
		if(positive){
			
			patient.Quaratine();
			System.out.println("Quaratine Patient");
			
			if(covid_19.isSevere()){
				
				patient.Isolate();
				System.out.println("Isolate Patient");
			}
			
			patient.status="positive";
			patient.action="isolate";
			//store test record in database
                        Database db=new Database();
                        db.addPatientRecord(patient);
			//database.addPatientRecord(patient);
		}else{
			
			patient.Discharge();
			System.out.println("Discharge Patient");
		}
	}
	
}
