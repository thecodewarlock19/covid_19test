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
	
	public ArrayList<String> Symptoms_Array;

	public CoronaPatient(){
		this.name="";
		this.age="";
		this.country="";
		this.status="";
		this.action="";
		this.marriage_status="";
		
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
            
            return true;
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
		String name=patient.getPatientInfo("name");
		String age=patient.getPatientInfo("age");
		String country=patient.getPatientInfo("country");
		String marriage_status=patient.getPatientInfo("marriage_status");
		
		String status=patient.getPatientInfo("status");
		String action=patient.getPatientInfo("action");
		
		//perform database insert action
		
		return true;
	}
	
}

public class Covid_19 {
	
	public static void main(String[] args){
		
		//patient
		CoronaPatient patient=new CoronaPatient();
		//set patient attrs or credentials
		patient.name="James Smith";
		patient.age="37";
		patient.country="CANADA";
		patient.marriage_status="married";
                
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
			//store test record
			database.addPatientRecord(patient);
		}else{
			
			patient.Discharge();
			System.out.println("Discharge Patient");
		}
	}
	
}
