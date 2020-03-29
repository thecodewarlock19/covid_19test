/*
 *@Author : Prince Kabutey aka @thecodewarlock
 *Record patient blood and fluid test status
 */
package covid_19;

public class TestLaboritory {
    
    public TestLaboritory(){
    }
    
    public boolean NewBloodOrFluidTest(String PatientName,int Age,String Country,String Status){
        
        Database ClinicDatabase=new Database();
        //ClinicDatabase.AddPatientLabTestStatus(PatientName, Age, Country, Status);
        
        return true;
    }
    
    
    public String getBloodOrFluidTestResult(Object PatientCredential){
        
            return "";
    } 
    
}
