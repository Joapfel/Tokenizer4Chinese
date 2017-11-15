
/* First created by JCasGen Wed Nov 08 15:07:36 CET 2017 */
package de.ws1718.ismla.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Nov 15 15:15:25 CET 2017
 * @generated */
public class TokenCMN_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TokenCMN.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.ws1718.ismla.types.TokenCMN");
 
  /** @generated */
  final Feature casFeat_pinyin;
  /** @generated */
  final int     casFeatCode_pinyin;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPinyin(int addr) {
        if (featOkTst && casFeat_pinyin == null)
      jcas.throwFeatMissing("pinyin", "de.ws1718.ismla.types.TokenCMN");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pinyin);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPinyin(int addr, String v) {
        if (featOkTst && casFeat_pinyin == null)
      jcas.throwFeatMissing("pinyin", "de.ws1718.ismla.types.TokenCMN");
    ll_cas.ll_setStringValue(addr, casFeatCode_pinyin, v);}
    
  
 
  /** @generated */
  final Feature casFeat_cat;
  /** @generated */
  final int     casFeatCode_cat;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getCat(int addr) {
        if (featOkTst && casFeat_cat == null)
      jcas.throwFeatMissing("cat", "de.ws1718.ismla.types.TokenCMN");
    return ll_cas.ll_getStringValue(addr, casFeatCode_cat);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCat(int addr, String v) {
        if (featOkTst && casFeat_cat == null)
      jcas.throwFeatMissing("cat", "de.ws1718.ismla.types.TokenCMN");
    ll_cas.ll_setStringValue(addr, casFeatCode_cat, v);}
    
  
 
  /** @generated */
  final Feature casFeat_gloss;
  /** @generated */
  final int     casFeatCode_gloss;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGloss(int addr) {
        if (featOkTst && casFeat_gloss == null)
      jcas.throwFeatMissing("gloss", "de.ws1718.ismla.types.TokenCMN");
    return ll_cas.ll_getStringValue(addr, casFeatCode_gloss);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGloss(int addr, String v) {
        if (featOkTst && casFeat_gloss == null)
      jcas.throwFeatMissing("gloss", "de.ws1718.ismla.types.TokenCMN");
    ll_cas.ll_setStringValue(addr, casFeatCode_gloss, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public TokenCMN_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_pinyin = jcas.getRequiredFeatureDE(casType, "pinyin", "uima.cas.String", featOkTst);
    casFeatCode_pinyin  = (null == casFeat_pinyin) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pinyin).getCode();

 
    casFeat_cat = jcas.getRequiredFeatureDE(casType, "cat", "uima.cas.String", featOkTst);
    casFeatCode_cat  = (null == casFeat_cat) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_cat).getCode();

 
    casFeat_gloss = jcas.getRequiredFeatureDE(casType, "gloss", "uima.cas.String", featOkTst);
    casFeatCode_gloss  = (null == casFeat_gloss) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_gloss).getCode();

  }
}



    