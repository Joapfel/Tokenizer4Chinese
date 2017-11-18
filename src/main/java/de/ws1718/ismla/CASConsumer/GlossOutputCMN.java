package de.ws1718.ismla.CASConsumer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import de.ws1718.ismla.types.TokenCMN;

public class GlossOutputCMN extends CasConsumer_ImplBase {
	
	final private String OUTPUT_DIR = "outputDir";
	private File out;
	private int c;
	
	@Override
	public void initialize() throws ResourceInitializationException {
		// TODO Auto-generated method stub
		super.initialize();
		
		String outputDir = new File((String) getConfigParameterValue(OUTPUT_DIR)).getAbsolutePath();
		out = new File(outputDir);
		
		if(!out.exists() || !out.isDirectory()){
			throw new ResourceInitializationException();
		}
		
		c = 0;
	}

	public void processCas(CAS arg0) throws ResourceProcessException {
		// TODO Auto-generated method stub
		try {
			
			JCas jcas = arg0.getJCas();
			File file = new File(out + "/" + "doc" + c + ".tsv");
			c++;
			
			PrintWriter pw = new PrintWriter(file);
			
			Iterator<TokenCMN> iter = jcas.getAnnotationIndex(TokenCMN.class).iterator();
			
			while(iter.hasNext()){
				TokenCMN token = iter.next();
				
				pw.println("orthography:" + "\t" + token.getCoveredText());
				pw.println("pinyin:" + "\t" + token.getPinyin());
				pw.println("category:" + "\t" + token.getCat());
				pw.println("gloss:" + "\t" + token.getGloss());
			}
			
			
		} catch (CASException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
