package com.pinterest.ktlint.ruleset.standard.rules

import com.pinterest.ktlint.logger.api.initKtLintKLogger
import com.pinterest.ktlint.rule.engine.core.api.AutocorrectDecision
import com.pinterest.ktlint.rule.engine.core.api.ElementType.ANNOTATED_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.ANNOTATION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.ANNOTATION_ENTRY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.ARRAY_ACCESS_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.ARROW
import com.pinterest.ktlint.rule.engine.core.api.ElementType.BINARY_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.BINARY_WITH_TYPE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.BLOCK
import com.pinterest.ktlint.rule.engine.core.api.ElementType.BLOCK_COMMENT
import com.pinterest.ktlint.rule.engine.core.api.ElementType.BODY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.CALL_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.CATCH
import com.pinterest.ktlint.rule.engine.core.api.ElementType.CLASS
import com.pinterest.ktlint.rule.engine.core.api.ElementType.CLOSING_QUOTE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.COLON
import com.pinterest.ktlint.rule.engine.core.api.ElementType.CONDITION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.CONSTRUCTOR_DELEGATION_CALL
import com.pinterest.ktlint.rule.engine.core.api.ElementType.CONSTRUCTOR_KEYWORD
import com.pinterest.ktlint.rule.engine.core.api.ElementType.CONTEXT_RECEIVER_LIST
import com.pinterest.ktlint.rule.engine.core.api.ElementType.DELEGATED_SUPER_TYPE_ENTRY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.DESTRUCTURING_DECLARATION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.DOT
import com.pinterest.ktlint.rule.engine.core.api.ElementType.DOT_QUALIFIED_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.ELSE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.ELVIS
import com.pinterest.ktlint.rule.engine.core.api.ElementType.EQ
import com.pinterest.ktlint.rule.engine.core.api.ElementType.FINALLY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.FOR
import com.pinterest.ktlint.rule.engine.core.api.ElementType.FUN
import com.pinterest.ktlint.rule.engine.core.api.ElementType.FUNCTION_LITERAL
import com.pinterest.ktlint.rule.engine.core.api.ElementType.IDENTIFIER
import com.pinterest.ktlint.rule.engine.core.api.ElementType.IF
import com.pinterest.ktlint.rule.engine.core.api.ElementType.IS_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.KDOC
import com.pinterest.ktlint.rule.engine.core.api.ElementType.KDOC_END
import com.pinterest.ktlint.rule.engine.core.api.ElementType.KDOC_LEADING_ASTERISK
import com.pinterest.ktlint.rule.engine.core.api.ElementType.KDOC_START
import com.pinterest.ktlint.rule.engine.core.api.ElementType.LBRACE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.LBRACKET
import com.pinterest.ktlint.rule.engine.core.api.ElementType.LITERAL_STRING_TEMPLATE_ENTRY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.LONG_STRING_TEMPLATE_ENTRY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.LPAR
import com.pinterest.ktlint.rule.engine.core.api.ElementType.MODIFIER_LIST
import com.pinterest.ktlint.rule.engine.core.api.ElementType.NULLABLE_TYPE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.OBJECT_DECLARATION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.OPEN_QUOTE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.OPERATION_REFERENCE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.PARENTHESIZED
import com.pinterest.ktlint.rule.engine.core.api.ElementType.POSTFIX_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.PREFIX_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.PRIMARY_CONSTRUCTOR
import com.pinterest.ktlint.rule.engine.core.api.ElementType.PROPERTY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.PROPERTY_ACCESSOR
import com.pinterest.ktlint.rule.engine.core.api.ElementType.RBRACE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.RBRACKET
import com.pinterest.ktlint.rule.engine.core.api.ElementType.REGULAR_STRING_PART
import com.pinterest.ktlint.rule.engine.core.api.ElementType.RETURN_KEYWORD
import com.pinterest.ktlint.rule.engine.core.api.ElementType.RPAR
import com.pinterest.ktlint.rule.engine.core.api.ElementType.SAFE_ACCESS_EXPRESSION
import com.pinterest.ktlint.rule.engine.core.api.ElementType.SECONDARY_CONSTRUCTOR
import com.pinterest.ktlint.rule.engine.core.api.ElementType.STRING_TEMPLATE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.SUPER_TYPE_LIST
import com.pinterest.ktlint.rule.engine.core.api.ElementType.THEN
import com.pinterest.ktlint.rule.engine.core.api.ElementType.TRY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.TYPEALIAS
import com.pinterest.ktlint.rule.engine.core.api.ElementType.TYPE_ARGUMENT_LIST
import com.pinterest.ktlint.rule.engine.core.api.ElementType.TYPE_CONSTRAINT
import com.pinterest.ktlint.rule.engine.core.api.ElementType.TYPE_CONSTRAINT_LIST
import com.pinterest.ktlint.rule.engine.core.api.ElementType.TYPE_PARAMETER_LIST
import com.pinterest.ktlint.rule.engine.core.api.ElementType.TYPE_REFERENCE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.USER_TYPE
import com.pinterest.ktlint.rule.engine.core.api.ElementType.VALUE_ARGUMENT
import com.pinterest.ktlint.rule.engine.core.api.ElementType.VALUE_ARGUMENT_LIST
import com.pinterest.ktlint.rule.engine.core.api.ElementType.VALUE_PARAMETER
import com.pinterest.ktlint.rule.engine.core.api.ElementType.VALUE_PARAMETER_LIST
import com.pinterest.ktlint.rule.engine.core.api.ElementType.WHEN
import com.pinterest.ktlint.rule.engine.core.api.ElementType.WHEN_ENTRY
import com.pinterest.ktlint.rule.engine.core.api.ElementType.WHERE_KEYWORD
import com.pinterest.ktlint.rule.engine.core.api.ElementType.WHILE
import com.pinterest.ktlint.rule.engine.core.api.IndentConfig
import com.pinterest.ktlint.rule.engine.core.api.IndentConfig.IndentStyle.SPACE
import com.pinterest.ktlint.rule.engine.core.api.IndentConfig.IndentStyle.TAB
import com.pinterest.ktlint.rule.engine.core.api.Rule.VisitorModifier.RunAfterRule.Mode.REGARDLESS_WHETHER_RUN_AFTER_RULE_IS_LOADED_OR_DISABLED
import com.pinterest.ktlint.rule.engine.core.api.RuleAutocorrectApproveHandler
import com.pinterest.ktlint.rule.engine.core.api.RuleId
import com.pinterest.ktlint.rule.engine.core.api.SinceKtlint
import com.pinterest.ktlint.rule.engine.core.api.SinceKtlint.Status.STABLE
import com.pinterest.ktlint.rule.engine.core.api.TokenSets
import com.pinterest.ktlint.rule.engine.core.api.children20
import com.pinterest.ktlint.rule.engine.core.api.column
import com.pinterest.ktlint.rule.engine.core.api.editorconfig.CODE_STYLE_PROPERTY
import com.pinterest.ktlint.rule.engine.core.api.editorconfig.CodeStyleValue
import com.pinterest.ktlint.rule.engine.core.api.editorconfig.CodeStyleValue.ktlint_official
import com.pinterest.ktlint.rule.engine.core.api.editorconfig.EditorConfig
import com.pinterest.ktlint.rule.engine.core.api.editorconfig.EditorConfigProperty
import com.pinterest.ktlint.rule.engine.core.api.editorconfig.INDENT_SIZE_PROPERTY
import com.pinterest.ktlint.rule.engine.core.api.editorconfig.INDENT_STYLE_PROPERTY
import com.pinterest.ktlint.rule.engine.core.api.findParentByType
import com.pinterest.ktlint.rule.engine.core.api.firstChildLeafOrSelf20
import com.pinterest.ktlint.rule.engine.core.api.ifAutocorrectAllowed
import com.pinterest.ktlint.rule.engine.core.api.indentWithoutNewlinePrefix
import com.pinterest.ktlint.rule.engine.core.api.isCode
import com.pinterest.ktlint.rule.engine.core.api.isPartOf
import com.pinterest.ktlint.rule.engine.core.api.isPartOfComment20
import com.pinterest.ktlint.rule.engine.core.api.isRoot20
import com.pinterest.ktlint.rule.engine.core.api.isWhiteSpace20
import com.pinterest.ktlint.rule.engine.core.api.isWhiteSpaceWithNewline20
import com.pinterest.ktlint.rule.engine.core.api.isWhiteSpaceWithoutNewline20
import com.pinterest.ktlint.rule.engine.core.api.lastChildLeafOrSelf20
import com.pinterest.ktlint.rule.engine.core.api.nextCodeLeaf
import com.pinterest.ktlint.rule.engine.core.api.nextCodeSibling20
import com.pinterest.ktlint.rule.engine.core.api.nextLeaf
import com.pinterest.ktlint.rule.engine.core.api.nextSibling
import com.pinterest.ktlint.rule.engine.core.api.parent
import com.pinterest.ktlint.rule.engine.core.api.prevCodeLeaf
import com.pinterest.ktlint.rule.engine.core.api.prevCodeSibling20
import com.pinterest.ktlint.rule.engine.core.api.prevLeaf
import com.pinterest.ktlint.rule.engine.core.api.prevSibling
import com.pinterest.ktlint.rule.engine.core.api.remove
import com.pinterest.ktlint.rule.engine.core.api.replaceTextWith
import com.pinterest.ktlint.ruleset.standard.StandardRule
import io.github.oshai.kotlinlogging.KotlinLogging
import org.ec4j.core.model.PropertyType
import org.ec4j.core.model.PropertyType.PropertyValueParser
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.psi.psiUtil.leaves
import org.jetbrains.kotlin.psi.psiUtil.parents
import java.util.Deque
import java.util.LinkedList

private val LOGGER = KotlinLogging.logger {}.initKtLintKLogger()

@SinceKtlint("0.1", STABLE)
public class IndentationRule :
    StandardRule(
        id = "indent",
        visitorModifiers =
            setOf(
                VisitorModifier.RunAsLateAsPossible,
                VisitorModifier.RunAfterRule(
                    ruleId = CLASS_SIGNATURE_RULE_ID,
                    mode = REGARDLESS_WHETHER_RUN_AFTER_RULE_IS_LOADED_OR_DISABLED,
                ),
                VisitorModifier.RunAfterRule(
                    ruleId = FUNCTION_SIGNATURE_RULE_ID,
                    mode = REGARDLESS_WHETHER_RUN_AFTER_RULE_IS_LOADED_OR_DISABLED,
                ),
                VisitorModifier.RunAfterRule(
                    ruleId = TRAILING_COMMA_ON_CALL_SITE_RULE_ID,
                    mode = REGARDLESS_WHETHER_RUN_AFTER_RULE_IS_LOADED_OR_DISABLED,
                ),
                VisitorModifier.RunAfterRule(
                    ruleId = TRAILING_COMMA_ON_DECLARATION_SITE_RULE_ID,
                    mode = REGARDLESS_WHETHER_RUN_AFTER_RULE_IS_LOADED_OR_DISABLED,
                ),
            ),
        usesEditorConfigProperties =
            setOf(
                CODE_STYLE_PROPERTY,
                INDENT_SIZE_PROPERTY,
                INDENT_STYLE_PROPERTY,
                INDENT_WHEN_ARROW_ON_NEW_LINE,
            ),
    ),
    RuleAutocorrectApproveHandler {
    private var codeStyle = CODE_STYLE_PROPERTY.defaultValue
    private var indentConfig = IndentConfig.DEFAULT_INDENT_CONFIG
    private var indentWhenArrowOnNewLine = INDENT_WHEN_ARROW_ON_NEW_LINE.defaultValue

    private var line = 1

    private val indentContextStack: Deque<IndentContext> = LinkedList()

    private lateinit var stringTemplateIndenter: StringTemplateIndenter

    override fun beforeFirstNode(editorConfig: EditorConfig) {
        codeStyle = editorConfig[CODE_STYLE_PROPERTY]
        indentConfig =
            IndentConfig(
                indentStyle = editorConfig[INDENT_STYLE_PROPERTY],
                tabWidth = editorConfig[INDENT_SIZE_PROPERTY],
            )
        if (indentConfig.disabled) {
            stopTraversalOfAST()
        }
        indentWhenArrowOnNewLine = editorConfig[INDENT_WHEN_ARROW_ON_NEW_LINE]
    }

    override fun beforeVisitChildNodes(
        node: ASTNode,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> AutocorrectDecision,
    ) {
        if (node.isRoot20) {
            // File should not start with a whitespace
            node
                .nextLeaf
                ?.takeIf { it.isWhiteSpaceWithoutNewline20 }
                ?.let { whitespaceWithoutNewline ->
                    emit(node.startOffset, "Unexpected indentation", true)
                        .ifAutocorrectAllowed { whitespaceWithoutNewline.remove() }
                }
            indentContextStack.addLast(startNoIndentZone(node))
        }

        when {
            node.isWhiteSpaceWithNewline20 -> {
                line++
                if (indentContextStack.peekLast()?.activated == false) {
                    val lastIndentContext = indentContextStack.removeLast()
                    indentContextStack.addLast(
                        lastIndentContext.copy(activated = true),
                    )
                }
                visitNewLineIndentation(node, emit)
            }

            node.elementType == CONTEXT_RECEIVER_LIST ||
                node.elementType == LONG_STRING_TEMPLATE_ENTRY ||
                node.elementType == STRING_TEMPLATE ||
                node.elementType == VALUE_ARGUMENT_LIST -> {
                startIndentContext(
                    fromAstNode = node,
                    lastChildIndent = "",
                )
            }

            (node.elementType == SUPER_TYPE_LIST && !node.isPrecededByComment()) ||
                (node.isPartOfComment20 && node.nextCodeSibling20?.elementType == SUPER_TYPE_LIST) -> {
                if (codeStyle == ktlint_official) {
                    val superTypeList =
                        if (node.isPartOfComment20) {
                            node.nextCodeLeaf!!
                        } else {
                            node
                        }
                    if (superTypeList.isPartOfClassWithAMultilinePrimaryConstructor()) {
                        // Contrary to the default IntelliJ IDEA formatter, indent the super type call entry so that it looks better in case it
                        // is followed by another super type:
                        //      class Foo(
                        //          val bar1: Bar,
                        //          val bar2: Bar,
                        //      ) : FooBar(
                        //              bar1,
                        //              bar2
                        //          ),
                        //          BarFoo,
                        startIndentContext(
                            fromAstNode = node,
                            activated = true,
                        )
                    }
                }
            }

            node.elementType == VALUE_ARGUMENT -> {
                visitValueArgument(node)
            }

            node.elementType == SECONDARY_CONSTRUCTOR -> {
                visitSecondaryConstructor(node)
            }

            node.elementType == PARENTHESIZED -> {
                if (codeStyle == ktlint_official) {
                    // Contrary to the IntelliJ IDEA default formatter, do not indent the closing RPAR
                    startIndentContext(
                        fromAstNode = node,
                        lastChildIndent = "",
                    )
                } else if (node.parent?.parent?.elementType != IF) {
                    startIndentContext(node)
                }
            }

            node.elementType == TYPE_ARGUMENT_LIST ||
                node.elementType == TYPE_PARAMETER_LIST -> {
                if (codeStyle == ktlint_official) {
                    // Contrary to the IntelliJ IDEA default formatter, do not indent the closing angle bracket
                    startIndentContext(
                        fromAstNode = node,
                        lastChildIndent = "",
                    )
                } else {
                    startIndentContext(node)
                }
            }

            node.elementType == BINARY_WITH_TYPE ||
                node.elementType == USER_TYPE -> {
                startIndentContext(node)
            }

            node.elementType == IS_EXPRESSION ||
                node.elementType == PREFIX_EXPRESSION ||
                node.elementType == POSTFIX_EXPRESSION -> {
                startIndentContext(node)
            }

            node.elementType == DELEGATED_SUPER_TYPE_ENTRY ||
                node.elementType == ANNOTATED_EXPRESSION ||
                node.elementType == TYPE_REFERENCE -> {
                startIndentContext(
                    fromAstNode = node,
                    childIndent = "",
                )
            }

            node.elementType == IF -> {
                visitIf(node)
            }

            node.elementType == LBRACE -> {
                visitLbrace(node)
            }

            node.elementType == VALUE_PARAMETER_LIST &&
                node.parent?.elementType != FUNCTION_LITERAL -> {
                startIndentContext(
                    fromAstNode = node,
                    lastChildIndent = "",
                )
            }

            node.elementType == LPAR &&
                node.nextCodeSibling20?.elementType == CONDITION -> {
                visitLparBeforeCondition(node)
            }

            node.elementType == VALUE_PARAMETER -> {
                visitValueParameter(node)
            }

            node.elementType == FUN -> {
                visitFun(node)
            }

            node.elementType == CLASS -> {
                visitClass(node)
            }

            node.elementType == OBJECT_DECLARATION -> {
                visitObjectDeclaration(node)
            }

            node.elementType == BINARY_EXPRESSION -> {
                visitBinaryExpression(node)
            }

            node.elementType in CHAINABLE_EXPRESSION -> {
                if (codeStyle == ktlint_official &&
                    node.elementType == DOT_QUALIFIED_EXPRESSION &&
                    node.parent?.elementType == ARRAY_ACCESS_EXPRESSION &&
                    node.parent?.parent?.elementType == CALL_EXPRESSION
                ) {
                    // Issue 1540: Deviate and fix from incorrect formatting in IntelliJ IDEA formatting and produce following:
                    // val fooBar2 = foo
                    //    .bar[0] {
                    //        "foobar"
                    //    }
                    startIndentContext(
                        fromAstNode = node.parent!!,
                        toAstNode = node.parent!!.parent!!.lastChildLeafOrSelf20,
                    )
                } else if (node.prevCodeSibling20.isElvisOperator()) {
                    startIndentContext(node)
                } else if (node.parent?.elementType in CHAINABLE_EXPRESSION) {
                    // Multiple dot qualified expressions and/or safe expression on the same line should not increase the indent level
                } else {
                    startIndentContext(node)
                }
            }

            node.elementType == IDENTIFIER &&
                node.parent?.elementType == PROPERTY -> {
                visitIdentifierInProperty(node)
            }

            node.elementType == LITERAL_STRING_TEMPLATE_ENTRY &&
                node.nextCodeSibling20?.elementType == CLOSING_QUOTE -> {
                visitWhiteSpaceBeforeClosingQuote(node, emit)
            }

            node.elementType == WHEN -> {
                visitWhen(node)
            }

            node.elementType == WHEN_ENTRY -> {
                visitWhenEntry(node)
            }

            node.elementType == WHERE_KEYWORD &&
                node.nextCodeSibling20?.elementType == TYPE_CONSTRAINT_LIST -> {
                visitWhereKeywordBeforeTypeConstraintList(node)
            }

            node.elementType == KDOC -> {
                visitKdoc(node)
            }

            node.elementType == PROPERTY_ACCESSOR ||
                node.elementType == TYPEALIAS -> {
                visitPropertyAccessor(node)
            }

            node.elementType == FOR ||
                node.elementType == WHILE -> {
                visitConditionalLoop(node)
            }

            node.elementType == LBRACKET -> {
                visitLBracket(node)
            }

            node.elementType == NULLABLE_TYPE -> {
                visitNullableType(node)
            }

            node.elementType == DESTRUCTURING_DECLARATION -> {
                visitDestructuringDeclaration(node)
            }

            node.elementType == TRY -> {
                visitTryCatchFinally(node)
            }

            else -> {
                LOGGER.trace { "No processing for ${node.elementType}: ${node.textWithEscapedTabAndNewline()}" }
            }
        }
    }

    private fun ASTNode.isPartOfClassWithAMultilinePrimaryConstructor() =
        parent
            ?.takeIf { it.elementType == CLASS }
            ?.findChildByType(PRIMARY_CONSTRUCTOR)
            ?.textContains('\n') == true

    private fun visitValueArgument(node: ASTNode) {
        if (codeStyle == ktlint_official) {
            // Deviate from standard IntelliJ IDEA formatting to allow formatting below:
            //     val foo = foo(
            //         parameterName =
            //             "The quick brown fox "
            //                .plus("jumps ")
            //                .plus("over the lazy dog"),
            //     )
            startIndentContext(
                fromAstNode = node,
                lastChildIndent = "",
            )
        }
    }

    private fun visitSecondaryConstructor(node: ASTNode) {
        node
            .findChildByType(CONSTRUCTOR_DELEGATION_CALL)
            ?.let { constructorDelegationCall ->
                val fromAstNode = node.skipLeadingWhitespaceCommentsAndAnnotations()
                val nextToAstNode =
                    startIndentContext(
                        fromAstNode = constructorDelegationCall,
                    ).prevCodeLeaf()

                // Leading annotations and comments should be indented at same level as constructor itself
                if (fromAstNode != node.nextLeaf) {
                    startIndentContext(
                        fromAstNode = node,
                        toAstNode = nextToAstNode,
                        childIndent = "",
                    )
                }
            }
    }

    private fun visitIf(node: ASTNode) {
        var nextToAstNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(ELSE)
            ?.let { fromAstNode ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = fromAstNode,
                        toAstNode = nextToAstNode,
                    ).prevCodeLeaf()
            }

        node
            .findChildByType(THEN)
            ?.lastChildLeafOrSelf20
            ?.nextLeaf
            ?.let { nodeAfterThenBlock ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = nodeAfterThenBlock,
                        toAstNode = nextToAstNode,
                        childIndent = "",
                    ).prevCodeLeaf()
            }
        node
            .findChildByType(RPAR)
            ?.nextCodeLeaf
            ?.let { nodeAfterConditionBlock ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = nodeAfterConditionBlock,
                        toAstNode = nextToAstNode,
                    ).prevCodeLeaf()
            }
        // No indent for the RPAR
        startIndentContext(
            fromAstNode = node,
            toAstNode = nextToAstNode,
            lastChildIndent = "",
        )
    }

    private fun visitLbrace(node: ASTNode) {
        // Outer indent context
        val rbrace =
            requireNotNull(
                node.nextSibling { it.elementType == RBRACE },
            ) { "Can not find matching rbrace" }
        startIndentContext(
            fromAstNode = node,
            toAstNode = rbrace,
            firstChildIndent = "",
            lastChildIndent = "",
        )

        // Inner indent context in reversed order
        node
            .parent
            ?.takeIf { it.elementType == FUNCTION_LITERAL }
            ?.findChildByType(ARROW)
            ?.let { arrow ->
                startIndentContext(
                    fromAstNode = arrow,
                    toAstNode = rbrace,
                    lastChildIndent = "",
                )
                startIndentContext(
                    fromAstNode = node,
                    toAstNode = arrow.prevCodeLeaf!!,
                    childIndent = arrow.calculateIndentOfFunctionLiteralParameters(),
                )
            }
    }

    private fun ASTNode.calculateIndentOfFunctionLiteralParameters() =
        if (isFirstParameterOfFunctionLiteralPrecededByNewLine()) {
            if (codeStyle == ktlint_official) {
                // Indent with single indent as defined in Kotlin Coding conventions
                indentConfig.indent
            } else {
                // Comply with default IDEA formatting although it is not compliant with Kotlin Coding conventions
                // val fieldExample =
                //      LongNameClass {
                //              paramA,
                //              paramB,
                //              paramC ->
                //          ClassB(paramA, paramB, paramC)
                //      }
                indentConfig.indent.repeat(2)
            }
        } else {
            // Allow default IntelliJ IDEA formatting:
            // val fieldExample =
            //     LongNameClass { paramA,
            //                     paramB,
            //                     paramC ->
            //         ClassB(paramA, paramB, paramC)
            //     }
            // val fieldExample =
            //     someFunction(
            //         1,
            //         2,
            //     ) { paramA,
            //         paramB,
            //         paramC ->
            //         ClassB(paramA, paramB, paramC)
            //     }
            this
                .takeIf { it.isPartOf(CALL_EXPRESSION) }
                ?.parent
                ?.leaves(false)
                ?.takeWhile { !it.isWhiteSpaceWithNewline20 }
                ?.sumOf { it.textLength }
                ?.plus(2) // need to add spaces to compensate for "{ "
                ?.let { length -> " ".repeat(length) }
                ?: indentConfig.indent.repeat(2)
        }

    private fun ASTNode.isFirstParameterOfFunctionLiteralPrecededByNewLine() =
        findParentByType(FUNCTION_LITERAL)
            ?.findChildByType(VALUE_PARAMETER_LIST)
            ?.prevSibling { it.textContains('\n') } != null

    private fun visitLparBeforeCondition(node: ASTNode) {
        startIndentContext(
            // Allow to pickup whitespace before condition
            fromAstNode = requireNotNull(node.nextLeaf),
            // Ignore whitespace after condition but before rpar
            toAstNode = requireNotNull(node.nextCodeSibling20).lastChildLeafOrSelf20,
            nodeIndent = currentIndent() + indentConfig.indent,
            childIndent = "",
        )
    }

    private fun visitValueParameter(node: ASTNode) {
        // Inner indent contexts in reversed order
        var nextToAstNode: ASTNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(EQ)
            ?.let { fromAstNode ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = fromAstNode,
                        toAstNode = nextToAstNode,
                    ).prevCodeLeaf()
            }

        if (codeStyle == ktlint_official) {
            // Deviate from standard IntelliJ IDEA formatting to allow formatting below:
            //     fun process(
            //         aVariableWithAVeryLongName:
            //             TypeWithAVeryLongNameThatDoesNotFitOnSameLineAsTheVariableName
            //     ): List<Output>
            node
                .findChildByType(COLON)
                ?.let { fromAstNode ->
                    nextToAstNode =
                        startIndentContext(
                            fromAstNode = fromAstNode,
                            toAstNode = nextToAstNode,
                        ).prevCodeLeaf()
                }
        }

        // Leading annotations and comments should be indented at same level as constructor itself
        val fromAstNode = node.skipLeadingWhitespaceCommentsAndAnnotations()
        if (fromAstNode != node.firstChildNode &&
            node.prevSibling { it.isWhiteSpaceWithNewline20 } == null &&
            node == node.parent?.findChildByType(VALUE_PARAMETER)
        ) {
            startIndentContext(
                fromAstNode = fromAstNode,
                toAstNode = nextToAstNode,
            ).fromASTNode.prevLeaf { !it.isWhiteSpace20 }!!
        } else {
            startIndentContext(
                fromAstNode = node,
                toAstNode = nextToAstNode,
                childIndent = "",
            )
        }
    }

    private fun visitFun(node: ASTNode) {
        // Inner indent contexts in reversed order
        var nextToAstNode: ASTNode = node.lastChildLeafOrSelf20
        val eqOrBlock =
            node.findChildByType(EQ)
                ?: node.findChildByType(BLOCK)
        eqOrBlock?.let {
            nextToAstNode =
                startIndentContext(
                    fromAstNode = eqOrBlock,
                    toAstNode = nextToAstNode,
                ).prevCodeLeaf()
        }

        node
            .findChildByType(WHERE_KEYWORD)
            ?.let { where ->
                val typeConstraintList =
                    requireNotNull(
                        where.nextCodeSibling20,
                    ) { "Can not find code sibling after WHERE in FUN" }
                require(typeConstraintList.elementType == TYPE_CONSTRAINT_LIST) {
                    "Code sibling after WHERE in CLASS is not a TYPE_CONSTRAINT_LIST"
                }
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = where.getPrecedingLeadingCommentsAndWhitespaces(),
                        toAstNode = typeConstraintList.lastChildLeafOrSelf20,
                        childIndent =
                            " ".repeat(
                                maxOf(0, where.column - 1 - node.indentWithoutNewlinePrefix.length),
                            ),
                    ).prevCodeLeaf()
            }

        node
            .findChildByType(TYPE_REFERENCE)
            ?.let { typeReference ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = typeReference.getPrecedingLeadingCommentsAndWhitespaces(),
                        toAstNode = nextToAstNode,
                    ).prevCodeLeaf()
            }

        // Leading annotations and comments should be indented at same level as function itself
        startIndentContext(
            fromAstNode = node,
            toAstNode = nextToAstNode,
            childIndent = "",
        )
    }

    private fun visitClass(node: ASTNode) {
        // Inner indent contexts in reversed order
        var nextToAstNode: ASTNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(WHERE_KEYWORD)
            ?.let { where ->
                val typeConstraintList =
                    requireNotNull(
                        where.nextCodeSibling20,
                    ) { "Can not find code sibling after WHERE in CLASS" }
                require(typeConstraintList.elementType == TYPE_CONSTRAINT_LIST) {
                    "Code sibling after WHERE in CLASS is not a TYPE_CONSTRAINT_LIST"
                }
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = where.getPrecedingLeadingCommentsAndWhitespaces(),
                        toAstNode = typeConstraintList.lastChildLeafOrSelf20,
                    ).prevCodeLeaf()
            }

        val primaryConstructor = node.findChildByType(PRIMARY_CONSTRUCTOR)
        val containsConstructorKeyword = primaryConstructor?.findChildByType(CONSTRUCTOR_KEYWORD) != null
        if (codeStyle == ktlint_official && primaryConstructor != null && containsConstructorKeyword) {
            nextToAstNode =
                startIndentContext(
                    fromAstNode = primaryConstructor.getPrecedingLeadingCommentsAndWhitespaces(),
                    toAstNode = nextToAstNode,
//                    activated = true,
                ).prevCodeLeaf()
        } else {
            node
                .findChildByType(SUPER_TYPE_LIST)
                ?.let { superTypeList ->
                    nextToAstNode =
                        startIndentContext(
                            fromAstNode = superTypeList.getPrecedingLeadingCommentsAndWhitespaces(),
                            toAstNode = superTypeList.lastChildLeafOrSelf20,
                        ).prevCodeLeaf()
                }
        }

        // Leading annotations and comments should be indented at same level as class itself
        startIndentContext(
            fromAstNode = node,
            toAstNode = nextToAstNode,
            childIndent = "",
        )
    }

    private fun visitObjectDeclaration(node: ASTNode) {
        // Inner indent contexts in reversed order
        var nextToAstNode: ASTNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(SUPER_TYPE_LIST)
            ?.let { superTypeList ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = superTypeList.getPrecedingLeadingCommentsAndWhitespaces(),
                        toAstNode = superTypeList.lastChildLeafOrSelf20,
                    ).prevCodeLeaf()
            }

        // Leading annotations and comments should be indented at same level as class itself
        startIndentContext(
            fromAstNode = node,
            toAstNode = nextToAstNode,
            childIndent = "",
        )
    }

    private fun visitBinaryExpression(node: ASTNode) {
        if (isPartOfBinaryExpressionWrappedInCondition(node)) {
            // Complex binary expression are nested in such a way that the indent context of the condition
            // wrapper is not the last node on the stack
            val conditionIndentContext =
                indentContextStack.last { it.fromASTNode.elementType != BINARY_EXPRESSION }
            // Create new indent context for the remainder (operator and right-hand side) of the binary expression
            startIndentContext(
                fromAstNode = node.findChildByType(OPERATION_REFERENCE)!!,
                toAstNode = node.lastChildLeafOrSelf20,
                nodeIndent = conditionIndentContext.nodeIndent,
                childIndent = conditionIndentContext.childIndent,
            )
            startIndentContext(node.firstChildNode)
        } else if (node.parent?.elementType != BINARY_EXPRESSION ||
            node.findChildByType(OPERATION_REFERENCE)?.firstChildNode?.elementType == ELVIS
        ) {
            startIndentContext(node)
        }
    }

    private fun visitIdentifierInProperty(node: ASTNode) {
        startIndentContext(
            fromAstNode = node,
            toAstNode = node.parent!!.lastChildLeafOrSelf20,
        )
    }

    private fun visitWhen(node: ASTNode) {
        var nextToASTNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(LPAR)
            ?.let { lpar ->
                nextToASTNode =
                    startIndentContext(
                        fromAstNode = lpar,
                        toAstNode = node.findChildByType(RPAR)!!,
                        lastChildIndent = "",
                    ).prevCodeLeaf()
            }
        startIndentContext(
            fromAstNode = node,
            toAstNode = nextToASTNode,
        )
    }

    private fun visitWhenEntry(node: ASTNode) {
        node
            .findChildByType(ARROW)
            ?.let { arrow ->
                arrow
                    .prevSibling { !it.isPartOfComment20 }
                    .let { prevSibling ->
                        if (indentWhenArrowOnNewLine && prevSibling != null && prevSibling.isWhiteSpaceWithNewline20) {
                            if (arrow.nextCodeSibling20?.elementType == BLOCK && codeStyle != ktlint_official) {
                                // Uglify the indentation to below to keep compatible with default formatting Intellij IDEA
                                //     val foo =
                                //        when (bar()) {
                                //            is Bar1
                                //                -> {
                                //                "bar1"
                                //            }
                                //        }
                                startIndentContext(
                                    fromAstNode = prevSibling,
                                    toAstNode = node.lastChildLeafOrSelf20,
                                    firstChildIndent = indentConfig.indent,
                                    childIndent = "",
                                )
                            } else {
                                // Reformat to below. This is not compatible with default IDEA formatting. But the closing brace is now at
                                // least aligned consistently.
                                //     val foo =
                                //        when (bar()) {
                                //            is Bar1
                                //                -> {
                                //                    "bar1"
                                //                }
                                //        }
                                startIndentContext(
                                    fromAstNode = arrow.nextLeaf!!,
                                    toAstNode = node.lastChildLeafOrSelf20,
                                )
                                startIndentContext(
                                    fromAstNode = node,
                                    toAstNode = prevSibling.prevLeaf!!,
                                    childIndent = "",
                                )
                            }
                        } else {
                            startIndentContext(
                                fromAstNode = arrow.nextLeaf!!,
                                toAstNode = node.lastChildLeafOrSelf20,
                            )
                            startIndentContext(
                                fromAstNode = node,
                                toAstNode = arrow,
                                childIndent = "",
                            )
                        }
                    }
            }
    }

    private fun visitWhereKeywordBeforeTypeConstraintList(node: ASTNode) {
        node
            .prevLeaf
            .takeUnless { it.isWhiteSpaceWithNewline20 }
            ?.takeIf { !indentContextStack.peekLast().activated }
            ?.let {
                val lastIndentContext = indentContextStack.removeLast()
                indentContextStack.addLast(
                    lastIndentContext.copy(activated = true),
                )
            }

        startIndentContext(
            fromAstNode = node,
            toAstNode = node.nextCodeSibling20?.lastChildLeafOrSelf20!!,
            childIndent = TYPE_CONSTRAINT_CONTINUATION_INDENT,
        )
    }

    private fun visitKdoc(node: ASTNode) {
        node
            .findChildByType(KDOC_START)
            ?.nextLeaf
            ?.let { fromAstNode ->
                startIndentContext(
                    fromAstNode = fromAstNode,
                    toAstNode = node.lastChildLeafOrSelf20,
                    childIndent = KDOC_CONTINUATION_INDENT,
                )
            }
    }

    private fun visitPropertyAccessor(node: ASTNode) {
        var nextToASTNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(EQ)
            ?.let { fromAstNode ->
                nextToASTNode =
                    startIndentContext(
                        fromAstNode = fromAstNode,
                        toAstNode = node.lastChildLeafOrSelf20,
                    ).prevCodeLeaf()
            }
        // No indent on preceding annotations and comments
        startIndentContext(
            fromAstNode = node,
            toAstNode = nextToASTNode,
            childIndent = "",
        )
    }

    private fun visitConditionalLoop(node: ASTNode) {
        // Inner indent contexts in reversed order
        node
            .findChildByType(BODY)
            ?.takeIf { it.nextCodeLeaf?.elementType != LBRACE }
            ?.let { rpar ->
                startIndentContext(
                    fromAstNode = rpar,
                    toAstNode = node.lastChildLeafOrSelf20,
                )
            }
        node
            .findChildByType(CONDITION)
            ?.let { fromAstNode ->
                startIndentContext(fromAstNode)
            }
    }

    private fun visitLBracket(node: ASTNode) {
        node
            .parent
            ?.takeUnless {
                // Should be resolved in IntelliJ IDEA default formatter:
                // https://youtrack.jetbrains.com/issue/KTIJ-14859/Too-little-indentation-inside-the-brackets-in-multiple-annotations-with-the-same-target
                it.elementType == ANNOTATION
            }?.findChildByType(RBRACKET)
            ?.let { rbracket ->
                startIndentContext(
                    fromAstNode = node,
                    toAstNode = rbracket,
                    firstChildIndent = "",
                    lastChildIndent = "",
                )
            }
    }

    private fun visitNullableType(node: ASTNode) {
        // Inner indent contexts in reversed order
        var nextToAstNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(RPAR)
            ?.let { fromAstNode ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = fromAstNode,
                        toAstNode = nextToAstNode,
                        childIndent = "",
                    ).prevCodeLeaf()
            }
        startIndentContext(
            fromAstNode = node,
            toAstNode = nextToAstNode,
        )
    }

    private fun visitDestructuringDeclaration(node: ASTNode) {
        // Inner indent contexts in reversed order
        var nextToAstNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(EQ)
            ?.let { eq ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = eq,
                        toAstNode = nextToAstNode,
                    ).prevCodeLeaf()
            }

        node
            .findChildByType(RPAR)
            ?.let {
                startIndentContext(
                    fromAstNode = node,
                    toAstNode = nextToAstNode,
                    lastChildIndent = "",
                )
            }
    }

    private fun visitTryCatchFinally(node: ASTNode) {
        // Inner indent contexts in reversed order
        var nextToAstNode = node.lastChildLeafOrSelf20
        node
            .findChildByType(FINALLY)
            ?.let { finally ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = finally,
                        toAstNode = nextToAstNode,
                        childIndent = "",
                    ).prevCodeLeaf()
            }

        node
            .findChildByType(CATCH)
            ?.let { catch ->
                nextToAstNode =
                    startIndentContext(
                        fromAstNode = catch,
                        toAstNode = nextToAstNode,
                        childIndent = "",
                    ).prevCodeLeaf()
            }

        startIndentContext(
            fromAstNode = node,
            toAstNode = nextToAstNode,
            lastChildIndent = "",
        )
    }

    private fun ASTNode.skipLeadingWhitespaceCommentsAndAnnotations(): ASTNode {
        require(elementType == SECONDARY_CONSTRUCTOR || elementType == VALUE_PARAMETER)
        return findChildByType(MODIFIER_LIST)
            ?.let { modifierList ->
                modifierList
                    .children20
                    .firstOrNull { it.isCode && it.elementType != ANNOTATION_ENTRY }
                    ?: modifierList.nextCodeSibling20
            }
            ?: children20.firstOrNull { it.isCode }
            ?: this
    }

    private fun ASTNode.getPrecedingLeadingCommentsAndWhitespaces(): ASTNode {
        var fromAstNode: ASTNode? = this
        while (fromAstNode?.prevLeaf != null &&
            (fromAstNode.prevLeaf.isWhiteSpace20 || fromAstNode.prevLeaf?.isPartOfComment20 == true)
        ) {
            fromAstNode = fromAstNode.prevLeaf
        }
        return fromAstNode!!
    }

    private fun isPartOfBinaryExpressionWrappedInCondition(node: ASTNode) =
        node
            .parents()
            .takeWhile { it.elementType == BINARY_EXPRESSION || it.elementType == CONDITION }
            .lastOrNull()
            ?.elementType == CONDITION

    private fun currentIndent() =
        indentContextStack
            .peekLast()
            .indent()

    private fun startIndentContext(
        fromAstNode: ASTNode,
        toAstNode: ASTNode = fromAstNode.lastChildLeafOrSelf20,
        nodeIndent: String = currentIndent(),
        childIndent: String = indentConfig.indent,
        firstChildIndent: String = childIndent,
        lastChildIndent: String = childIndent,
        activated: Boolean = false,
    ): IndentContext =
        IndentContext(
            fromASTNode = fromAstNode,
            toASTNode = toAstNode,
            nodeIndent = nodeIndent,
            firstChildIndent = firstChildIndent,
            childIndent = childIndent,
            lastChildIndent = lastChildIndent,
            activated = activated,
        ).also { newIndentContext ->
            LOGGER.trace {
                val nodeIndentLevel = indentConfig.indentLevelFrom(newIndentContext.nodeIndent)
                val childIndentLevel = indentConfig.indentLevelFrom(newIndentContext.childIndent)
                "Create new indent context (same as parent) with level ($nodeIndentLevel, $childIndentLevel) for " +
                    "${fromAstNode.elementType}: ${newIndentContext.nodes}"
            }
            indentContextStack.addLast(newIndentContext)
        }

    override fun afterVisitChildNodes(
        node: ASTNode,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> AutocorrectDecision,
    ) {
        while (indentContextStack.peekLast()?.toASTNode == node) {
            LOGGER.trace {
                val indentContext = indentContextStack.peekLast()
                val nodeIndentLevel = indentConfig.indentLevelFrom(indentContext.nodeIndent)
                val childIndentLevel = indentConfig.indentLevelFrom(indentContext.childIndent)
                "Remove indent context with level ($nodeIndentLevel, $childIndentLevel) for ${indentContext.fromASTNode.elementType}: " +
                    indentContext.nodes
            }
            indentContextStack
                .removeLast()
                .also {
                    LOGGER.trace {
                        val indentContext = indentContextStack.peekLast()
                        val nodeIndentLevel = indentConfig.indentLevelFrom(indentContext.nodeIndent)
                        val childIndentLevel = indentConfig.indentLevelFrom(indentContext.childIndent)
                        "Last indent context with level ($nodeIndentLevel, $childIndentLevel) for " +
                            "${indentContext.fromASTNode.elementType}: ${indentContext.nodes}"
                    }
                }
        }
    }

    override fun afterLastNode() {
        require(indentContextStack.isEmpty()) {
            indentContextStack
                .joinToString(prefix = "Stack should be empty:\n\t", separator = "\n\t") { it.toString() }
        }
    }

    private fun visitNewLineIndentation(
        node: ASTNode,
        emitAndApprove: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> AutocorrectDecision,
    ) {
        if (node.ignoreIndent()) {
            return
        }

        val normalizedNodeIndent = node.normalizedIndent(emitAndApprove)
        val expectedIndentation = node.expectedIndent()
        val text = node.text
        val nodeIndent = text.substringAfterLast("\n")
        if (nodeIndent != normalizedNodeIndent || normalizedNodeIndent != expectedIndentation) {
            val autoCorrect =
                if (normalizedNodeIndent != expectedIndentation) {
                    emitAndApprove(
                        node.startOffset + text.length - nodeIndent.length,
                        "Unexpected indentation (${normalizedNodeIndent.length}) (should be ${expectedIndentation.length})",
                        true,
                    ) == AutocorrectDecision.ALLOW_AUTOCORRECT
                } else {
                    // Indentation was at correct level but contained invalid indent characters. This violation has already
                    // been emitted.
                    true
                }
            LOGGER.trace {
                "Line $line: ${if (!autoCorrect) "would have " else ""} changed indentation to ${expectedIndentation.length} " +
                    "(from ${normalizedNodeIndent.length}) for ${node.elementType}: ${node.textWithEscapedTabAndNewline()}"
            }
            if (autoCorrect) {
                node.replaceTextWith(
                    text.substringBeforeLast("\n") + "\n" + expectedIndentation,
                )
            }
        } else {
            node.processedButNoIndentationChangedNeeded()
        }
    }

    private fun ASTNode.ignoreIndent(): Boolean {
        val nextLeaf = nextLeaf
        if (text.endsWith("\n") && nextLeaf.isStartOfRawStringLiteral()) {
            processedButNoIndentationChangedNeeded()
            return true // raw strings (""") are allowed at column 0
        }

        nextLeaf
            ?.takeIf { it.isPartOf(TokenSets.COMMENTS) }
            ?.let { comment ->
                if (text.endsWith("\n")) {
                    processedButNoIndentationChangedNeeded()
                    return true // comments are allowed at column 0
                }
                if (comment.textContains('\n') && comment.elementType == BLOCK_COMMENT) {
                    // FIXME: while we cannot assume any kind of layout inside a block comment,
                    // `/*` and `*/` can still be indented
                    processedButNoIndentationChangedNeeded()
                    return true
                }
            }
        return false
    }

    private fun ASTNode?.isStartOfRawStringLiteral(): Boolean = this != null && this.elementType == OPEN_QUOTE && this.text == "\"\"\""

    private fun ASTNode.processedButNoIndentationChangedNeeded() =
        LOGGER.trace { "No indentation change required for $elementType: ${textWithEscapedTabAndNewline()}" }

    private fun ASTNode.expectedIndent(): String {
        val lastIndexContext = indentContextStack.peekLast()
        val nextLeaf = nextLeaf
        val adjustedChildIndent =
            when {
                this == lastIndexContext.fromASTNode.firstChildLeafOrSelf20 ||
                    nextLeaf == lastIndexContext.fromASTNode.firstChildLeafOrSelf20 -> {
                    lastIndexContext.firstChildIndent
                }

                this == lastIndexContext.toASTNode ||
                    nextLeaf == lastIndexContext.toASTNode -> {
                    lastIndexContext.lastChildIndent
                }

                else -> {
                    lastIndexContext.childIndent
                }
            }
        return lastIndexContext.nodeIndent + adjustedChildIndent
    }

    private fun ASTNode.normalizedIndent(
        emitAndApprove: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> AutocorrectDecision,
    ): String {
        val nodeIndent = text.substringAfterLast("\n")
        return when (indentConfig.indentStyle) {
            SPACE -> {
                if ('\t' in nodeIndent) {
                    emitAndApprove(
                        startOffset + text.length - nodeIndent.length,
                        "Unexpected tab character(s)",
                        true,
                    ).ifAutocorrectAllowed {
                        // Ignore approval and fix invalid indent character always
                        indentConfig.toNormalizedIndent(nodeIndent)
                    } ?: nodeIndent
                } else {
                    nodeIndent
                }
            }

            TAB -> {
                val acceptableTrailingSpaces = acceptableTrailingSpaces()
                val nodeIndentWithoutAcceptableTrailingSpaces = nodeIndent.removeSuffix(acceptableTrailingSpaces)
                if (' ' in nodeIndentWithoutAcceptableTrailingSpaces) {
                    emitAndApprove(
                        startOffset + text.length - nodeIndent.length,
                        "Unexpected space character(s)",
                        true,
                    ).ifAutocorrectAllowed {
                        indentConfig
                            .toNormalizedIndent(nodeIndentWithoutAcceptableTrailingSpaces)
                            .plus(acceptableTrailingSpaces)
                    } ?: nodeIndent
                } else {
                    nodeIndent
                }
            }
        }
    }

    private fun visitWhiteSpaceBeforeClosingQuote(
        node: ASTNode,
        emitAndApprove: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> AutocorrectDecision,
    ) {
        if (!this::stringTemplateIndenter.isInitialized) {
            stringTemplateIndenter = StringTemplateIndenter(codeStyle, indentConfig)
        }
        stringTemplateIndenter.visitClosingQuotes(currentIndent(), node.parent!!, emitAndApprove)
    }

    private fun ASTNode?.isElvisOperator() =
        this != null &&
            elementType == OPERATION_REFERENCE &&
            firstChildNode?.elementType == ELVIS

    private fun ASTNode.acceptableTrailingSpaces(): String {
        require(isWhiteSpace20)
        val acceptableTrailingSpaces =
            when (nextLeaf?.elementType) {
                KDOC_LEADING_ASTERISK, KDOC_END -> {
                    // The indentation of a KDoc comment contains a space as the last character regardless of the indentation
                    // style (tabs or spaces) except for the starting line of the KDoc comment
                    KDOC_CONTINUATION_INDENT
                }

                TYPE_CONSTRAINT -> {
                    // 6 spaces (length of "where" keyword plus a separator space) to indent type constraints as below:
                    //    where A1 : RecyclerView.Adapter<V1>,
                    //          A1 : ComposableAdapter.ViewTypeProvider,
                    TYPE_CONSTRAINT_CONTINUATION_INDENT
                }

                else -> {
                    ""
                }
            }
        val nodeIndent = text.substringAfterLast("\n")
        return if (nodeIndent.endsWith(acceptableTrailingSpaces)) {
            return acceptableTrailingSpaces
        } else {
            ""
        }
    }

    private fun startNoIndentZone(node: ASTNode) =
        IndentContext(
            fromASTNode = node,
            nodeIndent = "",
            firstChildIndent = "",
            childIndent = "",
            lastChildIndent = "",
            activated = true,
        )

    private fun ASTNode.isPrecededByComment() = prevSibling { !it.isWhiteSpace20 }?.isPartOfComment20 == true

    public companion object {
        private const val KDOC_CONTINUATION_INDENT = " "
        private const val TYPE_CONSTRAINT_CONTINUATION_INDENT = "      " // Length of keyword "where" plus separating space
        private val CHAINABLE_EXPRESSION = setOf(DOT_QUALIFIED_EXPRESSION, SAFE_ACCESS_EXPRESSION)

        public val INDENT_WHEN_ARROW_ON_NEW_LINE: EditorConfigProperty<Boolean> =
            EditorConfigProperty(
                type =
                    PropertyType.LowerCasingPropertyType(
                        "ij_kotlin_indent_before_arrow_on_new_line",
                        "Indent the arrow in a when-entry if the arrow starts on a new line.",
                        PropertyValueParser.BOOLEAN_VALUE_PARSER,
                        setOf("true", "false"),
                    ),
                // Up until (and including) Intellij IDEA version `2024.1.6` the arrow on a newline was not indented. In version `2024.2`
                // the default behavior was changed to true. Disable by default to keep backward compatibility with older ktlint and IDEA
                // versions.
                defaultValue = false,
            )
    }

    private data class IndentContext(
        /**
         * The node on which the indent context starts.
         */
        val fromASTNode: ASTNode,
        /**
         * The node at which the indent context ends. If null, then the context ends at the last child leaf of the node
         * on which the indent context starts.
         */
        val toASTNode: ASTNode = fromASTNode.lastChildLeafOrSelf20,
        /**
         * Cumulative indentation for the node. Normally this should be equal to a multiple of the
         * 'indentConfig.indentStyle' to ensure a consistent indentation style.
         */
        val nodeIndent: String,
        /**
         * Additional indentation for first child node. Normally this should be equal to the 'indentConfig.indent' to
         * ensure a consistent indentation style. In very limited cases when the default indentation is set to 'tab' it
         * is still needed to adjust the last indentation using spaces.
         */
        val firstChildIndent: String,
        /**
         * Additional indentation for child nodes. Normally this should be equal to the 'indentConfig.indent' to ensure
         * a consistent indentation style. In very limited cases when the default indentation is set to 'tab' it is
         * still needed to adjust the last indentation using spaces.
         */
        val childIndent: String,
        /**
         * Additional indentation for last child node. Normally this should be equal to the 'indentConfig.indent' to
         * ensure a consistent indentation style. In very limited cases when the default indentation is set to 'tab' it
         * is still needed to adjust the last indentation using spaces.
         */
        val lastChildIndent: String,
        /**
         * True when the indentation level of this context is activated
         */
        val activated: Boolean = false,
    ) {
        val nodes: String
            get() =
                fromASTNode
                    .prevLeaf // The 'fromAstNode' itself needs to be returned by '.leaves()' call as well
                    ?.leaves()
                    .orEmpty()
                    .takeWhile {
                        // The 'toAstNode' itself needs to be included as well
                        it != toASTNode.nextLeaf
                    }.joinToString(separator = "") { it.text }
                    .textWithEscapedTabAndNewline()

        fun indent() =
            if (activated) {
                nodeIndent + childIndent
            } else {
                nodeIndent
            }

        fun prevCodeLeaf() = fromASTNode.prevCodeLeaf!!
    }
}

private fun ASTNode.textWithEscapedTabAndNewline() = text.textWithEscapedTabAndNewline()

private fun String.textWithEscapedTabAndNewline(): String {
    val (prefix, suffix) =
        if (this.all { it.isWhitespace() }) {
            Pair("[", "]")
        } else {
            Pair("", "")
        }
    return prefix
        .plus(
            this
                .replace("\t", "\\t")
                .replace("\n", "\\n"),
        ).plus(suffix)
}

private class StringTemplateIndenter(
    private val codeStyle: CodeStyleValue,
    private val indentConfig: IndentConfig,
) {
    fun visitClosingQuotes(
        expectedIndent: String,
        node: ASTNode,
        emitAndApprove: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> AutocorrectDecision,
    ) {
        require(node.elementType == STRING_TEMPLATE)
        node
            .takeIf { it.isFollowedByTrimIndent() || it.isFollowedByTrimMargin() }
            ?.takeIf { it.isMultiLine() }
            ?.let { _ ->
                if (node.containsMixedIndentationCharacters()) {
                    // It can not be determined with certainty how mixed indentation characters should be interpreted.
                    // The trimIndent function handles tabs and spaces equally (one tabs equals one space) while the user
                    // might expect that the tab size in the indentation is more than one space.
                    emitAndApprove(
                        node.startOffset,
                        "Indentation of multiline string should not contain both tab(s) and space(s)",
                        false,
                    )
                    return
                }

                val prevLeaf = node.prevLeaf
                val correctedExpectedIndent =
                    if (codeStyle == ktlint_official && node.isRawStringLiteralReturnInFunctionBodyBlock()) {
                        // Allow:
                        //   fun foo(): String {
                        //       return """
                        //           some text
                        //           """.trimIndent
                        //   }
                        node
                            .indentWithoutNewlinePrefix
                            .plus(indentConfig.indent)
                    } else if (codeStyle == ktlint_official && node.isRawStringLiteralFunctionBodyExpression()) {
                        // Allow:
                        //   fun foo(
                        //       bar: String
                        //   ) = """
                        //       $bar
                        //       """.trimIndent
                        node
                            .indentWithoutNewlinePrefix
                            .plus(indentConfig.indent)
                    } else if (prevLeaf?.text == "\n") {
                        // In case the opening quotes are placed at the start of the line, then the closing quotes
                        // should have no indent as well.
                        ""
                    } else {
                        expectedIndent
                    }
                node
                    .children20
                    .filter { it.isIndentBeforeClosingQuote() }
                    .forEach {
                        if (it.prevLeaf?.text == "\n") {
                            val (actualIndent, actualContent) = it.text.splitIndentAt(it.text.length)
                            if (actualIndent != correctedExpectedIndent) {
                                // It is a deliberate choice not to fix the indents inside the string literal except the line which only
                                // contains the closing quotes. See 'string-template-indent` rule for fixing the content of the string
                                // template itself
                                emitAndApprove(it.startOffset, "Unexpected indent of multiline string closing quotes", true)
                                    .ifAutocorrectAllowed {
                                        if (it.firstChildNode == null) {
                                            (it as LeafPsiElement).rawInsertBeforeMe(
                                                LeafPsiElement(REGULAR_STRING_PART, correctedExpectedIndent),
                                            )
                                        } else {
                                            it.firstChildNode.replaceTextWith(correctedExpectedIndent + actualContent)
                                        }
                                    }
                            }
                        }
                    }
            }
    }

    private fun ASTNode.isRawStringLiteralFunctionBodyExpression() =
        (!prevLeaf.isWhiteSpace20 || prevLeaf?.text == " ") &&
            FUN ==
            prevCodeLeaf
                .takeIf { it?.elementType == EQ }
                ?.parent
                ?.elementType

    private fun ASTNode.isRawStringLiteralReturnInFunctionBodyBlock() = RETURN_KEYWORD == prevCodeLeaf?.elementType

    private fun ASTNode.isFollowedByTrimIndent() = isFollowedBy("trimIndent()")

    private fun ASTNode.isFollowedByTrimMargin() = isFollowedBy("trimMargin()")

    private fun ASTNode.isFollowedBy(callExpressionName: String) =
        this
            .also { require(it.elementType == STRING_TEMPLATE) }
            .nextSibling { it.elementType != DOT }
            .let { it?.elementType == CALL_EXPRESSION && it.text == callExpressionName }

    private fun ASTNode.isMultiLine(): Boolean =
        children20
            .filter { it.elementType == LITERAL_STRING_TEMPLATE_ENTRY }
            .any { it.text == "\n" }

    private fun ASTNode.containsMixedIndentationCharacters(): Boolean {
        assert(this.isMultiLine())
        val nonBlankLines =
            this
                .text
                .split("\n")
                .filterNot { it.startsWith("\"\"\"") }
                .filterNot { it.endsWith("\"\"\"") }
                .filterNot { it.isBlank() }
        val prefixLength = nonBlankLines.minOfOrNull { it.indentLength() } ?: 0
        val distinctIndentCharacters =
            nonBlankLines
                .joinToString(separator = "") {
                    it.splitIndentAt(prefixLength).first
                }.toCharArray()
                .distinct()
                .count()
        return distinctIndentCharacters > 1
    }

    private fun ASTNode.isIndentBeforeClosingQuote() =
        elementType == CLOSING_QUOTE || (text.isBlank() && nextCodeSibling20?.elementType == CLOSING_QUOTE)

    private fun String.indentLength() = indexOfFirst { !it.isWhitespace() }.let { if (it == -1) length else it }

    /**
     * Splits the string at the given index or at the first non-white space character before that index. The returned pair
     * consists of the indentation and the second part contains the remainder. Note that the second part still can start
     * with whitespace characters in case the original strings starts with more white space characters than the requested
     * split index.
     */
    private fun String.splitIndentAt(index: Int): Pair<String, String> {
        assert(index >= 0)
        if (this == "\n") {
            return Pair("", "")
        }
        val firstNonWhitespaceIndex =
            indexOfFirst { !it.isWhitespace() }.let {
                if (it == -1) {
                    this.length
                } else {
                    it
                }
            }
        val safeIndex = kotlin.math.min(firstNonWhitespaceIndex, index)
        return Pair(
            first = this.take(safeIndex),
            second = this.substring(safeIndex),
        )
    }
}

public val INDENTATION_RULE_ID: RuleId = IndentationRule().ruleId
