//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors with no argument must implement this interface.
 */

public interface GJNoArguVisitor<R> {

   //
   // GJ Auto class visitors with no argument
   //

   public R visit(NodeList n);
   public R visit(NodeListOptional n);
   public R visit(NodeOptional n);
   public R visit(NodeSequence n);
   public R visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( ExternalDeclaration() )+
    */
   public R visit(TranslationUnit n);

   /**
    * f0 -> ( FunctionDefinition() | Declaration() )
    */
   public R visit(ExternalDeclaration n);

   /**
    * f0 -> [ DeclarationSpecifiers() ]
    * f1 -> Declarator()
    * f2 -> [ DeclarationList() ]
    * f3 -> CompoundStatement()
    */
   public R visit(FunctionDefinition n);

   /**
    * f0 -> DeclarationSpecifiers()
    * f1 -> [ InitDeclaratorList() ]
    * f2 -> ";"
    */
   public R visit(Declaration n);

   /**
    * f0 -> ( Declaration() )+
    */
   public R visit(DeclarationList n);

   /**
    * f0 -> StorageClassSpecifier() [ DeclarationSpecifiers() ]
    *       | TypeSpecifier() [ DeclarationSpecifiers() ]
    *       | TypeQualifier() [ DeclarationSpecifiers() ]
    */
   public R visit(DeclarationSpecifiers n);

   /**
    * f0 -> ( <AUTO> | <REGISTER> | <STATIC> | <EXTERN> | <TYPEDEF> )
    */
   public R visit(StorageClassSpecifier n);

   /**
    * f0 -> ( <VOID> | <CHAR> | <SHORT> | <INT> | <LONG> | <FLOAT> | <DOUBLE> | <SIGNED> | <UNSIGNED> | StructOrUnionSpecifier() | EnumSpecifier() | TypedefName() )
    */
   public R visit(TypeSpecifier n);

   /**
    * f0 -> ( <CONST> | <VOLATILE> )
    */
   public R visit(TypeQualifier n);

   /**

    * f0 -> StructOrUnion()
    * f1 -> ( [ <IDENTIFIER> ] "{" StructDeclarationList() "}" | <IDENTIFIER> )
    */
   public R visit(StructOrUnionSpecifier n);

   /**
    * f0 -> ( <STRUCT> | <UNION> )
    */
   public R visit(StructOrUnion n);

   /**
    * f0 -> ( StructDeclaration() )+
    */
   public R visit(StructDeclarationList n);

   /**
    * f0 -> InitDeclarator()
    * f1 -> ( "," InitDeclarator() )*
    */
   public R visit(InitDeclaratorList n);

   /**
    * f0 -> Declarator()
    * f1 -> [ "=" Initializer() ]
    */
   public R visit(InitDeclarator n);

   /**
    * f0 -> SpecifierQualifierList()
    * f1 -> StructDeclaratorList()
    * f2 -> ";"
    */
   public R visit(StructDeclaration n);

   /**
    * f0 -> TypeSpecifier() [ SpecifierQualifierList() ]
    *       | TypeQualifier() [ SpecifierQualifierList() ]
    */
   public R visit(SpecifierQualifierList n);

   /**
    * f0 -> StructDeclarator()
    * f1 -> ( "," StructDeclarator() )*
    */
   public R visit(StructDeclaratorList n);

   /**
    * f0 -> ( Declarator() | [ Declarator() ] ":" ConstantExpression() )
    */
   public R visit(StructDeclarator n);

   /**
    * f0 -> <ENUM>
    * f1 -> ( [ <IDENTIFIER> ] "{" EnumeratorList() "}" | <IDENTIFIER> )
    */
   public R visit(EnumSpecifier n);

   /**
    * f0 -> Enumerator()
    * f1 -> ( "," Enumerator() )*
    */
   public R visit(EnumeratorList n);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> [ "=" ConstantExpression() ]
    */
   public R visit(Enumerator n);

   /**
    * f0 -> [ Pointer() ]
    * f1 -> DirectDeclarator()
    */
   public R visit(Declarator n);

   /**
    * f0 -> ( <IDENTIFIER> | "(" Declarator() ")" )
    * f1 -> ( "[" [ ConstantExpression() ] "]" | "(" ParameterTypeList() ")" | "(" [ IdentifierList() ] ")" )*
    */
   public R visit(DirectDeclarator n);

   /**
    * f0 -> "*"
    * f1 -> [ TypeQualifierList() ]
    * f2 -> [ Pointer() ]
    */
   public R visit(Pointer n);

   /**
    * f0 -> ( TypeQualifier() )+
    */
   public R visit(TypeQualifierList n);

   /**
    * f0 -> ParameterList()
    * f1 -> [ "," "..." ]
    */
   public R visit(ParameterTypeList n);

   /**
    * f0 -> ParameterDeclaration()
    * f1 -> ( "," ParameterDeclaration() )*
    */
   public R visit(ParameterList n);

   /**
    * f0 -> DeclarationSpecifiers()
    * f1 -> ( Declarator() | [ AbstractDeclarator() ] )
    */
   public R visit(ParameterDeclaration n);

   /**
    * f0 -> <IDENTIFIER>
    * f1 -> ( "," <IDENTIFIER> )*
    */
   public R visit(IdentifierList n);

   /**
    * f0 -> ( AssignmentExpression() | "{" InitializerList() [ "," ] "}" )
    */
   public R visit(Initializer n);

   /**
    * f0 -> Initializer()
    * f1 -> ( "," Initializer() )*
    */
   public R visit(InitializerList n);

   /**
    * f0 -> SpecifierQualifierList()
    * f1 -> [ AbstractDeclarator() ]
    */
   public R visit(TypeName n);

   /**
    * f0 -> ( Pointer() | [ Pointer() ] DirectAbstractDeclarator() )
    */
   public R visit(AbstractDeclarator n);

   /**
    * f0 -> ( "(" AbstractDeclarator() ")" | "[" [ ConstantExpression() ] "]" | "(" [ ParameterTypeList() ] ")" )
    * f1 -> ( "[" [ ConstantExpression() ] "]" | "(" [ ParameterTypeList() ] ")" )*
    */
   public R visit(DirectAbstractDeclarator n);

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(TypedefName n);

   /**
    * f0 -> ( LabeledStatement() | Declaration() | ExpressionStatement() | CompoundStatement() | SelectionStatement() | IterationStatement() | JumpStatement() )
    */
   public R visit(Statement n);

   /**
    * f0 -> ( <IDENTIFIER> ":" Statement() | <CASE> ConstantExpression() ":" Statement() | <DFLT> ":" Statement() )
    */
   public R visit(LabeledStatement n);

   /**
    * f0 -> [ Expression() ]
    * f1 -> ";"
    */
   public R visit(ExpressionStatement n);

   /**
    * f0 -> "{"
    * f1 -> [ DeclarationList() ]
    * f2 -> [ StatementList() ]
    * f3 -> "}"
    */
   public R visit(CompoundStatement n);

   /**
    * f0 -> ( Statement() )+
    */
   public R visit(StatementList n);

   /**
    * f0 -> ( <IF> "(" Expression() ")" Statement() [ <ELSE> Statement() ] | <SWITCH> "(" Expression() ")" Statement() )
    */
   public R visit(SelectionStatement n);

   /**
    * f0 -> ( <WHILE> "(" Expression() ")" Statement() | <DO> Statement() <WHILE> "(" Expression() ")" ";" | <FOR> "(" [ Expression() ] ";" [ Expression() ] ";" [ Expression() ] ")" Statement() )
    */
   public R visit(IterationStatement n);

   /**
    * f0 -> ( <GOTO> <IDENTIFIER> ";" | <CONTINUE> ";" | <BREAK> ";" | <RETURN> [ Expression() ] ";" )
    */
   public R visit(JumpStatement n);

   /**
    * f0 -> AssignmentExpression()
    * f1 -> ( "," AssignmentExpression() )*
    */
   public R visit(Expression n);

   /**
    * f0 -> UnaryExpression() AssignmentOperator() AssignmentExpression()
    *       | ConditionalExpression()
    */
   public R visit(AssignmentExpression n);

   /**
    * f0 -> ( "=" | "*=" | "/=" | "%=" | "+=" | "-=" | "<<=" | ">>=" | "&=" | "^=" | "|=" )
    */
   public R visit(AssignmentOperator n);

   /**
    * f0 -> LogicalORExpression()
    * f1 -> [ "?" Expression() ":" ConditionalExpression() ]
    */
   public R visit(ConditionalExpression n);

   /**
    * f0 -> ConditionalExpression()
    */
   public R visit(ConstantExpression n);

   /**
    * f0 -> LogicalANDExpression()
    * f1 -> [ "||" LogicalORExpression() ]
    */
   public R visit(LogicalORExpression n);

   /**
    * f0 -> InclusiveORExpression()
    * f1 -> [ "&&" LogicalANDExpression() ]
    */
   public R visit(LogicalANDExpression n);

   /**
    * f0 -> ExclusiveORExpression()
    * f1 -> [ "|" InclusiveORExpression() ]
    */
   public R visit(InclusiveORExpression n);

   /**
    * f0 -> ANDExpression()
    * f1 -> [ "^" ExclusiveORExpression() ]
    */
   public R visit(ExclusiveORExpression n);

   /**
    * f0 -> EqualityExpression()
    * f1 -> [ "&" ANDExpression() ]
    */
   public R visit(ANDExpression n);

   /**
    * f0 -> RelationalExpression()
    * f1 -> [ ( "==" | "!=" ) EqualityExpression() ]
    */
   public R visit(EqualityExpression n);

   /**
    * f0 -> ShiftExpression()
    * f1 -> [ ( "<" | ">" | "<=" | ">=" ) RelationalExpression() ]
    */
   public R visit(RelationalExpression n);

   /**
    * f0 -> AdditiveExpression()
    * f1 -> [ ( "<<" | ">>" ) ShiftExpression() ]
    */
   public R visit(ShiftExpression n);

   /**
    * f0 -> MultiplicativeExpression()
    * f1 -> [ ( "+" | "-" ) AdditiveExpression() ]
    */
   public R visit(AdditiveExpression n);

   /**
    * f0 -> CastExpression()
    * f1 -> [ ( "*" | "/" | "%" ) MultiplicativeExpression() ]
    */
   public R visit(MultiplicativeExpression n);

   /**
    * f0 -> ( "(" TypeName() ")" CastExpression() | UnaryExpression() )
    */
   public R visit(CastExpression n);

   /**
    * f0 -> ( PostfixExpression() | "++" UnaryExpression() | "--" UnaryExpression() | UnaryOperator() CastExpression() | <SIZEOF> ( UnaryExpression() | "(" TypeName() ")" ) )
    */
   public R visit(UnaryExpression n);

   /**
    * f0 -> ( "&" | "*" | "+" | "-" | "~" | "!" )
    */
   public R visit(UnaryOperator n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> ( "[" Expression() "]" | "(" [ ArgumentExpressionList() ] ")" | "." <IDENTIFIER> | "->" <IDENTIFIER> | "++" | "--" )*
    */
   public R visit(PostfixExpression n);

   /**
    * f0 -> ( <IDENTIFIER> | Constant() | "(" Expression() ")" )
    */
   public R visit(PrimaryExpression n);

   /**
    * f0 -> AssignmentExpression()
    * f1 -> ( "," AssignmentExpression() )*
    */
   public R visit(ArgumentExpressionList n);

   /**
    * f0 -> <INTEGER_LITERAL>
    *       | <FLOATING_POINT_LITERAL>
    *       | <CHARACTER_LITERAL>
    *       | <STRING_LITERAL>
    */
   public R visit(Constant n);

}

