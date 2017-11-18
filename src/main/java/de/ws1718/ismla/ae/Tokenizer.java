package de.ws1718.ismla.ae;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tuebingen.sfs.tcl.ismla.exercises.ex02.CmnEngDictionaryWithPhon;
import de.tuebingen.sfs.tcl.ismla.exercises.ex02.SimpleDictionaryEntry;
import de.ws1718.ismla.types.MeaningfulTokenCMN;
import de.ws1718.ismla.types.TokenCMN;

public class Tokenizer extends JCasAnnotator_ImplBase {
	
	final private String PHON = "PHON";

//	private CmnEngDictionary dict;
	private CmnEngDictionaryWithPhon dict;
	private int lookahead;

	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		// TODO Auto-generated method stub
		super.initialize(aContext);
		lookahead = (Integer) aContext.getConfigParameterValue("lookahead");
		dict = new CmnEngDictionaryWithPhon();
	}

	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub

		String text = arg0.getDocumentText();

		for (int i = 0; i < text.length(); i++) {

			for (int k = lookahead; k > 0; k--) {
				int end = i + k;

				// if the proposed index is within the document
				if (end < text.length()) {

					String checkToken = text.substring(i, end);
					
					//old tokenizer version
//					List<SimpleDictionaryEntry> result = dict.lookup(checkToken);
					List<SimpleDictionaryEntry> result = dict.lookup(checkToken);

					// if the resulting list is not empty, the token exists
					if (!result.isEmpty()) {
						
						//there should be only one entry anyway
						for (SimpleDictionaryEntry e : result) {
							
							if(!e.category.equalsIgnoreCase(PHON)){
								MeaningfulTokenCMN t = new MeaningfulTokenCMN(arg0);
								t.setBegin(i);
								t.setEnd(end);
								t.setPinyin(e.prnc);
								t.setCat(e.category);
								t.setGloss(e.glosses.toString());
								t.addToIndexes(arg0);
								
//								System.out.println(e.glosses.toString() + " " + e.category + " " + e.prnc + " " + checkToken + " " + i+"-"+(end));
							}
					
//							break;
						}
							
						//index jump
						i += k-1;
						
						//stop iterating
						break;
					}
				}
			}
		}
	}
}
