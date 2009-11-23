package editorfindbar.api;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Composite;

/**
 * This is the interface for Find Bar decorator.
 * 
 * @see FindBarDecoratorFactory
 * 
 * @author schitale
 *
 */
public interface IFindBarDecorator {
	
	/**
	 * This should be called from <code>createPartControl(Composite parent)<code>.
	 * 
	 * <pre>
	 * public void createPartControl(Composite parent) {
     *     Composite findBarComposite = getfindBarDecorator().createFindBarComposite(parent, getStatusLineManager());
     *     super.createPartControl(findBarComposite);
     *     ...
     * }
     * </pre>
     * 
	 * @param parent The parent composite
	 * @return The composite configured for parenting Find Bar
	 */
	Composite createFindBarComposite(Composite parent);
	
	/**
	 * This creates the Find Bar.
	 * 
	 * @param sourceViewer 
	 */
	void createFindBar(ISourceViewer sourceViewer);
	
	/**
	 * This hooks up the actions and command handlers. This should be called from:
	 * 
	 * <pre>
	 * protected void createActions() {
	 *     super.createActions();
     *     getfindBarDecorator().createActions();
     * }
     * </pre>
	 * 
	 */
	void createActions();
}
