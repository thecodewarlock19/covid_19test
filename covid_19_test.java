/*
*@Author :Prince Kabutey aka @thecodewarlock
*Project : Corona Virus Patient Test
*
*/
class CoronaPatient {

	public String name;
	public String age;
	public String country;
	public String marriage_status;
	public String status;
	public String action;

	public CoronaPatient(){
		this.name="";
		this.age="";
		this.country="";
		this.status="";
		this.action="";
		this.marriage_status="";
	}
	
	public String getPatientInfo(String attr_name){
		
		switch(attr_name){
			
			case "name":
			
			return this.name;
			break;
			
			case "age":
			
			return this.age;
			break;
			
			case "country":
			
			return this.country;
			break;
			
			case "marriage_status":
			
			return this.marriage_status;
			break;
			
			case "status":
			
			return this.status;
			break;
			
			case "action":
			
			return this.action;
			break;
			
		}
		
	}
	
	public void Quaratine(){
		
		return true;
	}
	
	public void Discharge(){
		return true;
	}
	
	public void Isolate(){
		return true;
	}
}

class CoronaVirus {
	
	public CoronaPatient patient;
	
	
	public CoronaVirus(CoronaPatient patient){
		this.patient=patient;
	}
	
	public boolean TestNow(){
		
	}
	
	public boolean isSevere(){
		
	}
	
}


class MysqlDatabase {
	
	public boolean addPatientRecord(CoronaPatient patient){
		
		//perform database insert action
	}
	
}

public class CoronaVirusTest {
	
	public static void main(String[] args){
		
		//patient
		CoronaPatient patient=new CoronaPatient();
		//set patient attrs or credentials
		patient.name="James Smith";
		patient.age=37;
		patient.country="CANADA";
		patient.marriage_status="married";
		
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
				System.out.println("Quaratine Patient");
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
