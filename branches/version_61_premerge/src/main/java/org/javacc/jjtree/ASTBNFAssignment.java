/* Generated By:JJTree: Do not edit this line. ASTBNFAssignment.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
package org.javacc.jjtree;

public class ASTBNFAssignment extends JJTreeNode{
  public ASTBNFAssignment(int id) {
    super(id);
  }

  public ASTBNFAssignment(JJTreeParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(JJTreeParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f664136e47093b8ef318cf81a1b7fce7 (do not edit this line) */