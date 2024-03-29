package org.beanstalk4j.json;

/* JSON.java */
/* Generated By:JavaCC: Do not edit this line. JSON.java */
import java.io.StringReader;
import java.io.Reader;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class JSON implements JSONConstants {

  final public Object parse() throws ParseException {Object o;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LBRACE:{
      o = object();
      break;
      }
    case LBRACKET:{
      o = array();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(0);
{if ("" != null) return o;}
    throw new Error("Missing return statement in function");
  }

  final public Map<String,Object> object() throws ParseException {Map<String,Object> obj = new HashMap<String,Object>();
    jj_consume_token(LBRACE);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case STRING:{
      member(obj);
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMMA:{
          ;
          break;
          }
        default:
          jj_la1[1] = jj_gen;
          break label_1;
        }
        jj_consume_token(COMMA);
        member(obj);
      }
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(RBRACE);
{if ("" != null) return obj;}
    throw new Error("Missing return statement in function");
  }

  final public List<Object> array() throws ParseException {List<Object> arr = new ArrayList<Object>();
    Object v;
    jj_consume_token(LBRACKET);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LBRACE:
    case LBRACKET:
    case TRUE:
    case FALSE:
    case NULL:
    case NUMBER:
    case STRING:{
      v = value();
arr.add(v);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMMA:{
          ;
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          break label_2;
        }
        jj_consume_token(COMMA);
        v = value();
arr.add(v);
      }
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(RBRACKET);
{if ("" != null) return arr;}
    throw new Error("Missing return statement in function");
  }

  final public void member(Map<String,Object> obj) throws ParseException {Token key;
    Object value;
    key = jj_consume_token(STRING);
    jj_consume_token(COLON);
    value = value();
obj.put(key.image.substring(1, key.image.length() - 1), value);
  }

  final public Object value() throws ParseException {Object value;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NULL:{
      value = nil();
      break;
      }
    case TRUE:
    case FALSE:{
      value = bool();
      break;
      }
    case NUMBER:{
      value = number();
      break;
      }
    case STRING:{
      value = string();
      break;
      }
    case LBRACE:{
      value = object();
      break;
      }
    case LBRACKET:{
      value = array();
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return value;}
    throw new Error("Missing return statement in function");
  }

  final public String string() throws ParseException {Token t;
    t = jj_consume_token(STRING);
{if ("" != null) return t.image.substring(1, t.image.length() - 1);}
    throw new Error("Missing return statement in function");
  }

  final public Boolean bool() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case TRUE:{
      jj_consume_token(TRUE);
{if ("" != null) return Boolean.TRUE;}
      break;
      }
    case FALSE:{
      jj_consume_token(FALSE);
{if ("" != null) return Boolean.FALSE;}
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Object nil() throws ParseException {
    jj_consume_token(NULL);
{if ("" != null) return null;}
    throw new Error("Missing return statement in function");
  }

  final public Number number() throws ParseException {Token t;
    t = jj_consume_token(NUMBER);
{if ("" != null) return Integer.valueOf(t.image);}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public JSONTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x140,0x800,0x10000,0x800,0x1f140,0x1f140,0x3000,};
   }

  /** Constructor with InputStream. */
  public JSON(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JSON(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JSONTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public JSON(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JSONTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
   } else {
      jj_input_stream.ReInit(stream, 1, 1);
   }
   if (token_source == null) {
      token_source = new JSONTokenManager(jj_input_stream);
   }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public JSON(JSONTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(JSONTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
