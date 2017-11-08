package de.ws1718.ismla.ae;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tuebingen.sfs.tcl.ismla.exercises.ex01.CmnEngDictionary;

public class Tokenizer extends JCasAnnotator_ImplBase {
	
	private CmnEngDictionary dict;
	private int lookahead;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		// TODO Auto-generated method stub
		super.initialize(aContext);
		lookahead = 4;
		dict = new CmnEngDictionary();
	}

	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
	
		String text = arg0.getDocumentText();
		
		for(int i = 0; i < text.length(); i++){
			
			int look;
			
			int prev = 0;
			for(int j = 0; j < lookahead; j++){	
				if(!(i+j <= text.length())){
					look = prev;
				}else{
					prev = j;
				}
			}
			
			if(i+lookahead < text.length()){
				String initToken = text.substring(i, i+4);
				System.out.println(initToken);
			}else{
				//handle last chars
			}
			
			
		}
		

	}

}
