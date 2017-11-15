

/* First created by JCasGen Wed Nov 08 15:07:36 CET 2017 */
package de.ws1718.ismla.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Nov 15 15:15:25 CET 2017
 * XML source: /home/johannes/workspace_industrial_strength/ChineseTokenizer/src/main/resources/de/ws1718/ismla/typeSystems/typeSystemDescriptorCHN.xml
 * @generated */
public class TokenCMN extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TokenCMN.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected TokenCMN() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TokenCMN(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TokenCMN(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TokenCMN(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: pinyin

  /** getter for pinyin - gets latin transcription
   * @generated
   * @return value of the feature 
   */
  public String getPinyin() {
    if (TokenCMN_Type.featOkTst && ((TokenCMN_Type)jcasType).casFeat_pinyin == null)
      jcasType.jcas.throwFeatMissing("pinyin", "de.ws1718.ismla.types.TokenCMN");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TokenCMN_Type)jcasType).casFeatCode_pinyin);}
    
  /** setter for pinyin - sets latin transcription 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPinyin(String v) {
    if (TokenCMN_Type.featOkTst && ((TokenCMN_Type)jcasType).casFeat_pinyin == null)
      jcasType.jcas.throwFeatMissing("pinyin", "de.ws1718.ismla.types.TokenCMN");
    jcasType.ll_cas.ll_setStringValue(addr, ((TokenCMN_Type)jcasType).casFeatCode_pinyin, v);}    
   
    
  //*--------------*
  //* Feature: cat

  /** getter for cat - gets 
   * @generated
   * @return value of the feature 
   */
  public String getCat() {
    if (TokenCMN_Type.featOkTst && ((TokenCMN_Type)jcasType).casFeat_cat == null)
      jcasType.jcas.throwFeatMissing("cat", "de.ws1718.ismla.types.TokenCMN");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TokenCMN_Type)jcasType).casFeatCode_cat);}
    
  /** setter for cat - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCat(String v) {
    if (TokenCMN_Type.featOkTst && ((TokenCMN_Type)jcasType).casFeat_cat == null)
      jcasType.jcas.throwFeatMissing("cat", "de.ws1718.ismla.types.TokenCMN");
    jcasType.ll_cas.ll_setStringValue(addr, ((TokenCMN_Type)jcasType).casFeatCode_cat, v);}    
   
    
  //*--------------*
  //* Feature: gloss

  /** getter for gloss - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGloss() {
    if (TokenCMN_Type.featOkTst && ((TokenCMN_Type)jcasType).casFeat_gloss == null)
      jcasType.jcas.throwFeatMissing("gloss", "de.ws1718.ismla.types.TokenCMN");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TokenCMN_Type)jcasType).casFeatCode_gloss);}
    
  /** setter for gloss - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGloss(String v) {
    if (TokenCMN_Type.featOkTst && ((TokenCMN_Type)jcasType).casFeat_gloss == null)
      jcasType.jcas.throwFeatMissing("gloss", "de.ws1718.ismla.types.TokenCMN");
    jcasType.ll_cas.ll_setStringValue(addr, ((TokenCMN_Type)jcasType).casFeatCode_gloss, v);}    
  }

    