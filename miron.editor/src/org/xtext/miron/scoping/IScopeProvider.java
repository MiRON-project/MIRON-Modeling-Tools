package org.xtext.miron.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

public interface IScopeProvider {

    /**
     * Returns a scope for the given context. The scope
     * provides access to the compatible visible EObjects
     * for a given reference.
     *
     * @param context the element from which an element shall be
     *        referenced
     * @param reference the reference to be used to filter the
     *        elements.
     * @return {@link IScope} representing the inner most
     *         {@link IScope} for the passed context and reference.
     *         Note for implementors: The result may not be
     *         <code>null</code>. Return
     *         <code>IScope.NULLSCOPE</code> instead.
     */
    IScope getScope(EObject context, EReference reference);
	
}
