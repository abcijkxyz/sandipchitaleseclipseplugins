package editorfindbar.api;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.ui.texteditor.ITextEditor;

import editorfindbar.impl.FindBarDecorator;

/**
 * This is a factory for FindBarDecorator.
 * <p>
 * The typical usage is as follows:
 * <pre>
 * public void createPartControl(Composite parent) {
 *     Composite findBarComposite = getfindBarDecorator().createFindBarComposite(parent);
 *     super.createPartControl(findBarComposite);
 *     getfindBarDecorator().createFindBar(getSourceViewer());
 * }
 * 
 * protected void createActions() {
 *     super.createActions();
 *     getfindBarDecorator().createActions();
 * }
 * 
 * private IFindBarDecorator findBarDecorator;
 * private IFindBarDecorator getfindBarDecorator() {
 * 	if (findBarDecorator == null) {
 * 		findBarDecorator = FindBarDecoratorFactory.createFindBarDecorator(this, getStatusLineManager());
 * 	}
 * 	return findBarDecorator;
 * }
 * </pre>
 * @author schitale
 *
 */
public class FindBarDecoratorFactory {
	public static IFindBarDecorator createFindBarDecorator(ITextEditor textEditor,
			IStatusLineManager statusLineManager) {
		return new FindBarDecorator(textEditor, statusLineManager);
	}
}