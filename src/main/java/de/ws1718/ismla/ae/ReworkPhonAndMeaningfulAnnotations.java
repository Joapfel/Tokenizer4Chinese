package de.ws1718.ismla.ae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.ws1718.ismla.types.MeaningfulTokenCMN;
import de.ws1718.ismla.types.PhonChunkCMN;

public class ReworkPhonAndMeaningfulAnnotations extends JCasAnnotator_ImplBase {
	
	private HashMap<HashMap<List<MeaningfulTokenCMN>, PhonChunkCMN>, Boolean> toDelete;
	
	@Override
	public void process(JCas arg0) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		
		//init for every jcas
		toDelete = new HashMap<HashMap<List<MeaningfulTokenCMN>,PhonChunkCMN>, Boolean>();
		
		//iterator over phon chunks
		Iterator<PhonChunkCMN> iterPhon = arg0.getAnnotationIndex(PhonChunkCMN.class).iterator();
		
		//iter over phon chunks
		while(iterPhon.hasNext()){
			PhonChunkCMN chunk = iterPhon.next();
			
			//subiterator over meaningful tokens within phon chunks
			Iterator<MeaningfulTokenCMN> iterMeaningful = arg0.getAnnotationIndex(MeaningfulTokenCMN.class).subiterator(chunk);
			
			//trigger for (not)deleting the meaningful annotations 
			boolean hasLongMeaningfulToken = false;
			//all meaningful annotations within a phon chunk
			List<MeaningfulTokenCMN> meaningfulTokens = new ArrayList<MeaningfulTokenCMN>();
			
			//iter over meaningful tokens within a phon chunk
			while(iterMeaningful.hasNext()){
				MeaningfulTokenCMN mt = iterMeaningful.next();
				//define what is a long meaningful token
				if(mt.getCoveredText().length() > 1){
					hasLongMeaningfulToken = true;	
				}
				meaningfulTokens.add(mt);
			}
			
			//store results of subiterations
			HashMap<List<MeaningfulTokenCMN>, PhonChunkCMN> tmp = new HashMap<List<MeaningfulTokenCMN>, PhonChunkCMN>();
			tmp.put(meaningfulTokens, chunk);
			toDelete.put(tmp, Boolean.valueOf(hasLongMeaningfulToken));
			
		}
		
		//after (sub)iteration trigger deletion
		for(HashMap<List<MeaningfulTokenCMN>, PhonChunkCMN> h : toDelete.keySet()){
			for(List<MeaningfulTokenCMN> mts : h.keySet()){
				//if includes meaningful tokens of length > 1 remove phon chunk annotation
				System.out.println();
				if(toDelete.get(h).booleanValue()){
					h.get(mts).removeFromIndexes(arg0);
					
				//otherwise remove all the meaningful tokens
				}else{
					for(MeaningfulTokenCMN mt : mts){
						mt.removeFromIndexes(arg0);
					}
				}
			}
		}
		
		
	}
}
