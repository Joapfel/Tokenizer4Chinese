
/* First created by JCasGen Wed Nov 15 15:15:25 CET 2017 */
package de.ws1718.ismla.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;

/** 
 * Updated by JCasGen Wed Nov 15 15:15:25 CET 2017
 * @generated */
public class PhonChunkCMN_Type extends TokenCMN_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = PhonChunkCMN.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.ws1718.ismla.types.PhonChunkCMN");



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public PhonChunkCMN_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

  }
}



    