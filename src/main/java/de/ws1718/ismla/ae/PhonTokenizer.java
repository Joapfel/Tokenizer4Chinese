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
import de.ws1718.ismla.types.PhonChunkCMN;

public class PhonTokenizer extends JCasAnnotator_ImplBase {
	
	final private String PHON = "PHON";
	
	private CmnEngDictionaryWithPhon dict;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
		// TODO Auto-generated method stub
		super.initialize(aContext);
		dict = new CmnEngDictionaryWithPhon();
	}

	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		String text = arg0.getDocumentText();
		
		//store the PHON signs which will form a chunk
		ArrayList<PhonChunkCMN> chunkItems = new ArrayList<PhonChunkCMN>();
		
		//iter over doc
		for (int i = 0; i < text.length(); i++) {
			int end = i+1;
			
			//each symbol 
			String sign = text.substring(i, end);

			//lookup of the symbol
			List<SimpleDictionaryEntry> result = dict.lookup(sign);
			
			boolean containsPhon = false;
			
			if(!result.isEmpty()){
				
				for(SimpleDictionaryEntry e : result){
					
					if(e.category.equalsIgnoreCase(PHON)){
						containsPhon = true;
						
						PhonChunkCMN tmp = new PhonChunkCMN(arg0);
						tmp.setBegin(i);
						tmp.setEnd(end);
						tmp.setPinyin(e.prnc);
						tmp.setCat(e.category);
						//radical cutoff
						tmp.setGloss(e.glosses.get(0));
						//store temporary
						chunkItems.add(tmp);
					
						//if its not a PHON
					}
				}
				
				//after all possible entries where checked
				if(!containsPhon){
					
					//only >1 chunks
					if(chunkItems.size() > 1){
						
						//handle glosses and pinyin
						StringBuilder sbGlosses = new StringBuilder();
						StringBuilder sbPinyin = new StringBuilder();
						sbGlosses.append("[");
						for(PhonChunkCMN chunkItem : chunkItems){
							//was already trimmed to the first gloss
							
							sbGlosses.append(chunkItem.getGloss());
							//concat pinyins
							sbPinyin.append(chunkItem.getPinyin());
							
							
						}
						sbGlosses.append("]");
						
						//set chunk span
						PhonChunkCMN chunk = new PhonChunkCMN(arg0);
						chunk.setBegin(chunkItems.get(0).getBegin());//begin of the first item
						chunk.setEnd(chunkItems.get(chunkItems.size()-1).getEnd());//end of the last item
						chunk.setCat(PHON);
						chunk.setGloss(sbGlosses.toString());
						chunk.setPinyin(sbPinyin.toString());
						chunk.addToIndexes(arg0);
					}
					
					//reset either way (since its not a PHON)
					chunkItems.clear();
					
				}
				
			}	
		}
	}
}
