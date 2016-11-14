//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

class simpleStmt{
	public String label;
	public String stmt;
}

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class Translator extends GJNoArguDepthFirst<String> {
   
	ArrayList<simpleStmt> stmts = new ArrayList<simpleStmt>();
	
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public String visit(NodeList n) {
      String _ret="";
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         _ret += e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public String visit(NodeListOptional n) {
      if ( n.present() ) {
         String _ret="";
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
        	 _ret += e.nextElement().accept(this);
            _count++;
         }
         return _ret;
      }
      else
         return "";
   }

   public String visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return "";
   }

   public String visit(NodeSequence n) {
      String _ret="";
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
    	  _ret += e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public String visit(NodeToken n) { return n.tokenImage; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( VariablesAndFunctions() )*
    * f1 -> PMain()
    * f2 -> ( VariablesAndFunctions() )*
    * f3 -> <EOF>
    */
   public String visit(Goal n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      System.out.println(_ret);
      return _ret;
   }

   /**
    * f0 -> DeclarationStmt()
    *       | FunctionDeclaration()
    *       | StructDeclaration()
    *       | EnumDeclaration()
    *       | FunctionDefinition()
    *       | TypeDef()
    */
   public String visit(VariablesAndFunctions n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> BaseType()
    * f1 -> ObjectList()
    * f2 -> ";"
    */
   public String visit(DeclarationStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ArgList() ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public String visit(FunctionDefinition n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> ( DeclarationStmt() )*
    * f2 -> ( StatementUnit() )*
    * f3 -> "}"
    */
   public String visit(SimpleBlock n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      
      _ret += "goto " + stmts.get(0).label + ";";

      // Sorting
      Collections.sort(stmts, new Comparator<simpleStmt>() {
              @Override
              public int compare(simpleStmt s1, simpleStmt s2){
                  return  s1.label.compareTo(s2.label);
              }
      });
      
      for(simpleStmt stmt: stmts)
        _ret += " " + stmt.stmt;
      
      _ret += " " + n.f3.accept(this);

      stmts = new ArrayList<simpleStmt>(); 

      return _ret;
   }

   /**
    * f0 -> Label()
    * f1 -> Statement()
    * f2 -> [ GotoStmt() ]
    */
   public String visit(StatementUnit n) {
      String _ret="";
      String s = n.f0.accept(this);
      _ret += " " + s;
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      
      simpleStmt stmt = new simpleStmt();
      stmt.label = s;
      stmt.stmt = _ret;
      stmts.add(stmt);
      
      return "";
   }

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ParameterList() ]
    * f4 -> ")"
    * f5 -> ";"
    */
   public String visit(FunctionDeclaration n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public String visit(ParameterList n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public String visit(ParameterDeclaration n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <STRUCT>
    * f1 -> [ Identifier() ]
    * f2 -> "{"
    * f3 -> ( DeclarationStmt() )*
    * f4 -> "}"
    * f5 -> ";"
    */
   public String visit(StructDeclaration n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> <TYPEDEF>
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public String visit(TypeDef n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> <ENUM>
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> Identifier()
    * f4 -> ( "," Identifier() )*
    * f5 -> "}"
    * f6 -> ";"
    */
   public String visit(EnumDeclaration n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      _ret += " " + n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> MainReturnType()
    * f1 -> <MAIN>
    * f2 -> "("
    * f3 -> [ <INT> Identifier() "," <CHAR> "*" [ "*" ] Identifier() [ "[" "]" ] ]
    * f4 -> ")"
    * f5 -> SimpleBlock()
    */
   public String visit(PMain n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      return _ret;
   }

   /**
    * f0 -> BaseType()
    * f1 -> ( "*" )*
    */
   public String visit(Type n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> [ StorageClass() ]
    * f1 -> TypeSpecifier()
    */
   public String visit(BaseType n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <STATIC>
    */
   public String visit(StorageClass n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INT>
    *       | <VOID>
    *       | <CHAR>
    *       | <SHORT>
    *       | <LONG>
    *       | <FLOAT>
    *       | <DOUBLE>
    *       | <SIGNED>
    *       | <UNSIGNED>
    *       | Identifier()
    *       | <STRUCT> [ Identifier() ] [ "{" ( DeclarationStmt() )* "}" ]
    *       | <ENUM> [ Identifier() ] "{" Identifier() ( "," Identifier() )* "}"
    */
   public String visit(TypeSpecifier n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Arg()
    * f1 -> ( "," Arg() )*
    */
   public String visit(ArgList n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Type()
    * f1 -> [ Identifier() ]
    */
   public String visit(Arg n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INT>
    *       | <VOID>
    */
   public String visit(MainReturnType n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ObjectType()
    * f1 -> ( "," ObjectType() )*
    */
   public String visit(ObjectList n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "*" )*
    * f1 -> Identifier()
    * f2 -> ( "[" Expression() "]" )*
    * f3 -> [ "=" Expression() ]
    */
   public String visit(ObjectType n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> "{"
    * f1 -> StatementList()
    * f2 -> "}"
    */
   public String visit(Block n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( [ Label() ] Statement() )*
    */
   public String visit(StatementList n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> ForLoop()
    *       | WhileLoop()
    *       | DoWhile()
    *       | Block()
    *       | IfStmt()
    *       | SwitchStmt()
    *       | BreakStmt()
    *       | ContinueStmt()
    *       | ReturnStmt()
    *       | DeclarationStmt()
    *       | Expression() ";"
    *       | GotoStmt()
    *       | ";"
    */
   public String visit(Statement n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <GOTO>
    * f1 -> Identifier()
    * f2 -> ";"
    */
   public String visit(GotoStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> <FOR>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ";"
    * f4 -> Expression()
    * f5 -> ";"
    * f6 -> Expression()
    * f7 -> ")"
    * f8 -> Statement()
    */
   public String visit(ForLoop n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      _ret += " " + n.f6.accept(this);
      _ret += " " + n.f7.accept(this);
      _ret += " " + n.f8.accept(this);
      return _ret;
   }

   /**
    * f0 -> <WHILE>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public String visit(WhileLoop n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> <DO>
    * f1 -> Statement()
    * f2 -> <WHILE>
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public String visit(DoWhile n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      _ret += " " + n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> <BREAK>
    * f1 -> ";"
    */
   public String visit(BreakStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <CONTINUE>
    * f1 -> ";"
    */
   public String visit(ContinueStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> <RETURN>
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public String visit(ReturnStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      return _ret;
   }

   /**
    * f0 -> IfThenElseStmt()
    *       | IfThenStmt()
    */
   public String visit(IfStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public String visit(IfThenStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IF>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> <ELSE>
    * f6 -> Statement()
    */
   public String visit(IfThenElseStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      _ret += " " + n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> <SWITCH>
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> "{"
    * f5 -> ( CaseStmt() )*
    * f6 -> "}"
    */
   public String visit(SwitchStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      _ret += " " + n.f4.accept(this);
      _ret += " " + n.f5.accept(this);
      _ret += " " + n.f6.accept(this);
      return _ret;
   }

   /**
    * f0 -> <CASE> Expression() ":" ( Statement() )*
    *       | <DFLT> ":" ( Statement() )*
    */
   public String visit(CaseStmt n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    * f1 -> ":"
    */
   public String visit(Label n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> Ops()
    * f1 -> PrimaryExpr()
    */
   public String visit(BinOp n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "||"
    *       | "&&"
    *       | "<"
    *       | "<="
    *       | ">"
    *       | ">="
    *       | "=="
    *       | "!="
    *       | "+"
    *       | "-"
    *       | "*"
    *       | "/"
    *       | "%"
    *       | "&"
    *       | "|"
    *       | "^"
    *       | "<<"
    *       | ">>"
    */
   public String visit(Ops n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "++"
    *       | "!"
    *       | "--"
    *       | "-"
    *       | "+"
    *       | "~"
    *       | "*"
    *       | "&"
    *       | "(" Type() ")"
    */
   public String visit(LeftUnary n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "++"
    *       | "--"
    */
   public String visit(RightUnary n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> PrimaryExpr() [ ExpressionContd() ]
    *       | LeftUnary() PrimaryExpr()
    */
   public String visit(Expression n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> RHSAssignExpr()
    *       | "(" [ Expression() ( "," Expression() )* ] ")"
    *       | BinOp()
    *       | RightUnary()
    *       | StructExpr()
    *       | ArrayLookup()
    *       | TernaryExpr()
    */
   public String visit(ExpressionContd n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "=" Expression()
    *       | "+=" Expression()
    *       | "-=" Expression()
    *       | "*=" Expression()
    *       | "/=" Expression()
    *       | "%=" Expression()
    *       | "<<=" Expression()
    *       | ">>=" Expression()
    *       | "&=" Expression()
    *       | "^=" Expression()
    *       | "|=" Expression()
    */
   public String visit(RHSAssignExpr n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> "?"
    * f1 -> Expression()
    * f2 -> ":"
    * f3 -> Expression()
    */
   public String visit(TernaryExpr n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      _ret += " " + n.f2.accept(this);
      _ret += " " + n.f3.accept(this);
      return _ret;
   }

   /**
    * f0 -> ( "[" PrimaryExpr() "]" )+
    */
   public String visit(ArrayLookup n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> StructOps()
    * f1 -> Identifier()
    */
   public String visit(StructExpr n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      _ret += " " + n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "->"
    *       | "."
    */
   public String visit(StructOps n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> Identifier()
    *       | "(" Expression() ")"
    *       | <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <STRING_LITERAL>
    *       | <CHARACTER_LITERAL>
    */
   public String visit(PrimaryExpr n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public String visit(Identifier n) {
      String _ret="";
      _ret += " " + n.f0.accept(this);
      return _ret;
   }

}
