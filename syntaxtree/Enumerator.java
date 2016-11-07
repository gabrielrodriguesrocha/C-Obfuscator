//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <IDENTIFIER>
 * f1 -> [ "=" ConstantExpression() ]
 */
public class Enumerator implements Node {
   public NodeToken f0;
   public NodeOptional f1;

   public Enumerator(NodeToken n0, NodeOptional n1) {
      f0 = n0;
      f1 = n1;
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

