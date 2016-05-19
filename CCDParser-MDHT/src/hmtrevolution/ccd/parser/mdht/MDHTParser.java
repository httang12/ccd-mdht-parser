package hmtrevolution.ccd.parser.mdht;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.emf.common.util.EList;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.consol.AllergiesSection;
import org.openhealthtools.mdht.uml.cda.consol.AllergyObservation;
import org.openhealthtools.mdht.uml.cda.consol.AllergyProblemAct;
import org.openhealthtools.mdht.uml.cda.consol.ContinuityOfCareDocument;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;


public class MDHTParser {

	public static void main(String args[])
	{
		//CCDPackage.eINSTANCE.eClass();
		CDAUtil.loadPackages();
		//Mu2consolPackage.eINSTANCE.eClass();
		try {
		
			ClinicalDocument ccdDocument = (ClinicalDocument) CDAUtil.load(new FileInputStream("sample_patient_data/sample_patient1.xml"));
			System.out.println(ccdDocument.getClass().toGenericString());
			
			EList<Section> listS = ccdDocument.getAllSections();
			for(int i=0;i<listS.size();i++)
			{
				System.out.println(listS.get(i).getTitle().getText());
			}
			
			
			ContinuityOfCareDocument ccd = (ContinuityOfCareDocument)ccdDocument;
			
			AllergiesSection as = ccd.getAllergiesSection();
			for(AllergyProblemAct apa: as.getAllergyProblemActs())
			{
				for(AllergyObservation ao:apa.getAllergyObservations())
				{
					System.out.println(ao.getValues());
				}
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
