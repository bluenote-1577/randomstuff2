package ca.ece.ubc.cpen221.mp5.antlrStuff;

import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;



//will process the string into tokens, parse them and evaluate them.
//will create an extended formulabaselistener for the relevant methods.
//
public class FormulaFactory {
	public static void main(String args[]){
		FormulaFactory.parse("in(Telegraph Ave) && "
				+ "(category(Chinese) || category(Italian)) && price(1..2)");
	}

	public static Formula parse(String string) {
		// Create a stream of tokens using the lexer.
		CharStream stream = new ANTLRInputStream(string);
		FormulaLexer lexer = new FormulaLexer(stream);
		lexer.reportErrorsAsExceptions();
		TokenStream tokens = new CommonTokenStream(lexer);

		// Feed the tokens into the parser.
		FormulaParser parser = new FormulaParser(tokens);
		parser.reportErrorsAsExceptions();

		// Generate the parse tree using the starter rule.
		ParseTree tree = parser.orExpr(); // "root" is the starter rule.

		// Finally, construct a Document value by walking over the parse tree.
		ParseTreeWalker walker = new ParseTreeWalker();
		FormulaListener_FormulaCreator listener = new FormulaListener_FormulaCreator();
		walker.walk(listener, tree);
		
		((RuleContext)tree).inspect(parser);

		//new ParseTreeWalker().walk(new FormulaListener_PrintEverything(), tree);
		// return the Document value that the listener created
		//return listener.getFormula();
		return listener.getFormula();
	}

	private static class FormulaListener_FormulaCreator extends FormulaBaseListener {
		private Stack<Formula> stack = new Stack<Formula>();
		
		@Override
		public void exitAndExpr(FormulaParser.AndExprContext ctx){
			
		}
		
		@Override
		public void exitOrExpr(FormulaParser.OrExprContext ctx){
			
		}
		@Override
		public void exitAtom(FormulaParser.AtomContext ctx){
			if(ctx.name() != null){
				String string = new String(ctx.name().STRING().toString());
				stack.push(new Atom(AtomTypes.NAME , string));
			}
			
			else if(ctx.rating() != null){
				String string = new String(ctx.rating().RANGE().toString());
			//for testing	System.out.println(string);
				stack.push(new Atom(AtomTypes.RATING , string));
			}
			
		}
		
		public Formula getFormula(){
			return stack.pop();
		}
		
	}

	private static class FormulaListener_PrintEverything extends FormulaBaseListener {
		@Override
		public void enterOrExpr(FormulaParser.OrExprContext ctx) {
			System.out.println("entering orExpr " + ctx.getText());
		}

		@Override
		public void exitOrExpr(FormulaParser.OrExprContext ctx) {
			System.out.println("exiting orExpr " + ctx.getText());
		}

		@Override
		public void enterAndExpr(FormulaParser.AndExprContext ctx){
			System.out.println("entering AndExpr " + ctx.getText());
		}
		@Override
		public void exitAndExpr(FormulaParser.AndExprContext ctx){
			System.out.println("exiting AndExpr " + ctx.getText());
		}

	}

}
