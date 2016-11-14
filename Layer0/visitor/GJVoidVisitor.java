//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ void visitors must implement this interface.
 */

public interface GJVoidVisitor<A> {

   //
   // GJ void Auto class visitors
   //

   public void visit(NodeList n, A argu);
   public void visit(NodeListOptional n, A argu);
   public void visit(NodeOptional n, A argu);
   public void visit(NodeSequence n, A argu);
   public void visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( ExternalDeclaration() )+
    */
   public void visit(TranslationUnit n, A argu);

   /**
    * f0 -> ( FunctionDefinition() | Declaration() )
    */
   public void visit(ExternalDeclaration n, A argu);

   /**
    * f0 -> [ DeclarationSpecifiers() ]
    * f1 -> Declarator()
    * f2 -> [ DeclarationList() ]
    * f3 -> CompoundStatement()
    */
   public void visit(FunctionDefinition n, A argu);

   /**
    * f0 -> DeclarationSpecifiers()
    * f1 -> [ InitDeclaratorList() ]
    * f2 -> ";"
    */
   public void visit(Declaration n, A argu);

   /**
    * f0 -> ( Declaration() )+
    */
   public void visit(DeclarationList n, A argu);

   /**
    * f0 -> StorageClassSpecifier() [ DeclarationSpecifiers() ]
    *       | TypeSpecifier() [ DeclarationSpecifiers() ]
    *       | TypeQualifier() [ DeclarationSpecifiers() ]
    */
   public void visit(DeclarationSpecifiers n, A argu);

   /**
    * f0 -> ( <AUTO> | <REGISTER> | <STATIC> | <EXTERN> | <TYPEDEF> )
    */
   public void visit(StorageClassSpecifier n, A argu);

   /**
    * f0 -> ( <VOID> | <CHAR> | <SHORT> | <INT> | <LONG> | <FLOAT> | <DOUBLE> | <SIGNED> | <UNSIGNED> | StructOrUnionSpecifier() | EnumSpecifier() | TypedefName() )
    */
   public void visit(TypeSpecifier n, A argu);

   /**
    * f0 -> ( <CONST> | <VOLATILE> )
    */
   public void visit(TypeQualifier n, A argu);

   /**

    * f0 -> StructOrUnion()
    * f1 -> ( [ <IDENTIFIER> ] "{" StructDeclarationList() "}" | <IDENTIFIER> )
    */
   public void visit(StructOrUnionSpecifier n, A argu);

   /**
    * f0 -> ( <STRUCT> | <UNION> )
    */
   public void visit(StructOrUnion n, A argu);

   /**
    * f0 -> ( StructDeclaration() )+
    */
   public void visit(StructDeclarationList n, A argu);

   /**
    * f0 -> InitDeclarator()
    * f1 -> ( "," InitDeclarator() )*
    */
   public void visit(InitDeclaratorList n, A argu);

   /**
    * f0 -> Declarator()
    * f1 -> [ "=" Initializer() ]
    */
   public void visit(InitDeclarator n, A argu);

   /**
    * f0 -> SpecifierQualifierList()
    * f1 -> StructDeclaratorList()
    * f2 -> ";"
    */
   public void visit(StructDeclaration n, A argu);

   /**
    * f0 -> TypeSpecifier() [ SpecifierQualifierList() ]
    *       | TypeQualifier() [ SpecifierQualifierList() ]
    */
   public void visit(SpecifierQualifierList n, A argu);

   /**
    * f0 -> StructDeclarator()
    * f1 -> ( "," StructDeclarator() )*
    */
   public void visit(StructDeclaratorList n, A argu);

   /**
    * f0 -> ( Declarator() | [ Declarator() ] ":" ConstantExpression() )
    */
   public void visit(StructDeclarator n, A argu);

   /**
    * f0 -> <ENUM>
    * f1 -> ( [ <IDENTIFIER> ] "{" EnumeratorList() "}" | <IDENTIFIER> )
    */
   public void visit(EnumSpecifier n, A argu);

   /**
    * f0 -> Enumerator()
    * f1 -> ( "," Enumerator() )*
    */
   public void visit(EnumeratorList n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> [ "=" ConstantExpression() ]
    */
   public void visit(Enumerator n, A argu);

   /**
    * f0 -> [ Pointer() ]
    * f1 -> DirectDeclarator()
    */
   public void visit(Declarator n, A argu);

   /**
    * f0 -> ( <IDENTIFIER> | "(" Declarator() ")" )
    * f1 -> ( "[" [ ConstantExpression() ] "]" | "(" ParameterTypeList() ")" | "(" [ IdentifierList() ] ")" )*
    */
   public void visit(DirectDeclarator n, A argu);

   /**
    * f0 -> "*"
    * f1 -> [ TypeQualifierList() ]
    * f2 -> [ Pointer() ]
    */
   public void visit(Pointer n, A argu);

   /**
    * f0 -> ( TypeQualifier() )+
    */
   public void visit(TypeQualifierList n, A argu);

   /**
    * f0 -> ParameterList()
    * f1 -> [ "," "..." ]
    */
   public void visit(ParameterTypeList n, A argu);

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public void visit(ParameterList n, A argu);

   /**
    * f0 -> DeclarationSpecifiers()
    * f1 -> ( Declarator() | [ AbstractDeclarator() ] )
    */
   public void visit(ParameterDeclaration n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "," <IDENTIFIER> )*
    */
   public void visit(IdentifierList n, A argu);

   /**
    * f0 -> ( AssignmentExpression() | "{" InitializerList() [ "," ] "}" )
    */
   public void visit(Initializer n, A argu);

   /**
    * f0 -> Initializer()
    * f1 -> ( "," Initializer() )*
    */
   public void visit(InitializerList n, A argu);

   /**
    * f0 -> SpecifierQualifierList()
    * f1 -> [ AbstractDeclarator() ]
    */
   public void visit(TypeName n, A argu);

   /**
    * f0 -> ( Pointer() | [ Pointer() ] DirectAbstractDeclarator() )
    */
   public void visit(AbstractDeclarator n, A argu);

   /**
    * f0 -> ( "(" AbstractDeclarator() ")" | "[" [ ConstantExpression() ] "]" | "(" [ ParameterTypeList() ] ")" )
    * f1 -> ( "[" [ ConstantExpression() ] "]" | "(" [ ParameterTypeList() ] ")" )*
    */
   public void visit(DirectAbstractDeclarator n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(TypedefName n, A argu);

   /**
    * f0 -> ( LabeledStatement() | Declaration() | ExpressionStatement() | CompoundStatement() | SelectionStatement() | IterationStatement() | JumpStatement() )
    */
   public void visit(Statement n, A argu);

   /**
    * f0 -> ( <IDENTIFIER> ":" Statement() | <CASE> ConstantExpression() ":" Statement() | <DFLT> ":" Statement() )
    */
   public void visit(LabeledStatement n, A argu);

   /**
    * f0 -> [ Expression() ]
    * f1 -> ";"
    */
   public void visit(ExpressionStatement n, A argu);

   /**
    * f0 -> "{"
    * f1 -> [ DeclarationList() ]
    * f2 -> [ StatementList() ]
    * f3 -> "}"
    */
   public void visit(CompoundStatement n, A argu);

   /**
    * f0 -> ( Statement() )+
    */
   public void visit(StatementList n, A argu);

   /**
    * f0 -> ( <IF> "(" Expression() ")" Statement() [ <ELSE> Statement() ] | <SWITCH> "(" Expression() ")" Statement() )
    */
   public void visit(SelectionStatement n, A argu);

   /**
    * f0 -> ( <WHILE> "(" Expression() ")" Statement() | <DO> Statement() <WHILE> "(" Expression() ")" ";" | <FOR> "(" [ Expression() ] ";" [ Expression() ] ";" [ Expression() ] ")" Statement() )
    */
   public void visit(IterationStatement n, A argu);

   /**
    * f0 -> ( <GOTO> <IDENTIFIER> ";" | <CONTINUE> ";" | <BREAK> ";" | <RETURN> [ Expression() ] ";" )
    */
   public void visit(JumpStatement n, A argu);

   /**
    * f0 -> AssignmentExpression()
    * f1 -> ( "," AssignmentExpression() )*
    */
   public void visit(Expression n, A argu);

   /**
    * f0 -> UnaryExpression() AssignmentOperator() AssignmentExpression()
    *       | ConditionalExpression()
    */
   public void visit(AssignmentExpression n, A argu);

   /**
    * f0 -> ( "=" | "*=" | "/=" | "%=" | "+=" | "-=" | "<<=" | ">>=" | "&=" | "^=" | "|=" )
    */
   public void visit(AssignmentOperator n, A argu);

   /**
    * f0 -> LogicalORExpression()
    * f1 -> [ "?" Expression() ":" ConditionalExpression() ]
    */
   public void visit(ConditionalExpression n, A argu);

   /**
    * f0 -> ConditionalExpression()
    */
   public void visit(ConstantExpression n, A argu);

   /**
    * f0 -> LogicalANDExpression()
    * f1 -> [ "||" LogicalORExpression() ]
    */
   public void visit(LogicalORExpression n, A argu);

   /**
    * f0 -> InclusiveORExpression()
    * f1 -> [ "&&" LogicalANDExpression() ]
    */
   public void visit(LogicalANDExpression n, A argu);

   /**
    * f0 -> ExclusiveORExpression()
    * f1 -> [ "|" InclusiveORExpression() ]
    */
   public void visit(InclusiveORExpression n, A argu);

   /**
    * f0 -> ANDExpression()
    * f1 -> [ "^" ExclusiveORExpression() ]
    */
   public void visit(ExclusiveORExpression n, A argu);

   /**
    * f0 -> EqualityExpression()
    * f1 -> [ "&" ANDExpression() ]
    */
   public void visit(ANDExpression n, A argu);

   /**
    * f0 -> RelationalExpression()
    * f1 -> [ ( "==" | "!=" ) EqualityExpression() ]
    */
   public void visit(EqualityExpression n, A argu);

   /**
    * f0 -> ShiftExpression()
    * f1 -> [ ( "<" | ">" | "<=" | ">=" ) RelationalExpression() ]
    */
   public void visit(RelationalExpression n, A argu);

   /**
    * f0 -> AdditiveExpression()
    * f1 -> [ ( "<<" | ">>" ) ShiftExpression() ]
    */
   public void visit(ShiftExpression n, A argu);

   /**
    * f0 -> MultiplicativeExpression()
    * f1 -> [ ( "+" | "-" ) AdditiveExpression() ]
    */
   public void visit(AdditiveExpression n, A argu);

   /**
    * f0 -> CastExpression()
    * f1 -> [ ( "*" | "/" | "%" ) MultiplicativeExpression() ]
    */
   public void visit(MultiplicativeExpression n, A argu);

   /**
    * f0 -> ( "(" TypeName() ")" CastExpression() | UnaryExpression() )
    */
   public void visit(CastExpression n, A argu);

   /**
    * f0 -> ( PostfixExpression() | "++" UnaryExpression() | "--" UnaryExpression() | UnaryOperator() CastExpression() | <SIZEOF> ( UnaryExpression() | "(" TypeName() ")" ) )
    */
   public void visit(UnaryExpression n, A argu);

   /**
    * f0 -> ( "&" | "*" | "+" | "-" | "~" | "!" )
    */
   public void visit(UnaryOperator n, A argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> ( "[" Expression() "]" | "(" [ ArgumentExpressionList() ] ")" | "." <IDENTIFIER> | "->" <IDENTIFIER> | "++" | "--" )*
    */
   public void visit(PostfixExpression n, A argu);

   /**
    * f0 -> ( <IDENTIFIER> | Constant() | "(" Expression() ")" )
    */
   public void visit(PrimaryExpression n, A argu);

   /**
    * f0 -> AssignmentExpression()
    * f1 -> ( "," AssignmentExpression() )*
    */
   public void visit(ArgumentExpressionList n, A argu);

   /**
    * f0 -> <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <CHARACTER_LITERAL>
    *       | <STRING_LITERAL>
    */
   public void visit(Constant n, A argu);

}

