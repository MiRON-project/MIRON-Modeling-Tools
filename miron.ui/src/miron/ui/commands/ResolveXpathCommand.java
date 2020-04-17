package miron.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;

import miron.generator.MironGenerator;


public class ResolveXpathCommand extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {			
			System.out.println("ResolveXpathCommand !!!!!!! ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected boolean isSelectionAFile() {
		IStructuredSelection selection =
				(IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getSelection();
		
		return selection.size()>0 && (selection.getFirstElement() instanceof IFile);
	}
	
	protected boolean isSelectionAFolder() {
		IStructuredSelection selection =
				(IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getSelection();
		
		return selection.size()>0 && (selection.getFirstElement() instanceof IFolder);
	}
	
	protected boolean isSelectionAProject() {
		IStructuredSelection selection =
				(IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getSelection();
		
		return selection.size()>0 && (selection.getFirstElement() instanceof IProject);
	}
	
	protected IFile getSelectedFile() {
		IFile result = null;
		IStructuredSelection selection =
				(IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getSelection();
		
		if(selection.size()>0 && (selection.getFirstElement() instanceof IFile))
			result = (IFile)selection.getFirstElement();
		
		return result;
	}
	
	protected IFolder getSelectedFolder() {
		IFolder result = null;
		IStructuredSelection selection =
				(IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getSelection();
		
		if(selection.size()>0 && (selection.getFirstElement() instanceof IFolder))
			result = (IFolder)selection.getFirstElement();
		
		return result;
	}
	
	protected IProject getSelectedProject() {
		IProject result = null;
		IStructuredSelection selection =
				(IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getSelection();
		
		if(selection.size()>0 && (selection.getFirstElement() instanceof IProject))
			result = (IProject)selection.getFirstElement();
		
		return result;
	}
	
	protected IResource getSelectedResource() {
		IResource result = null;
		IStructuredSelection selection =
				(IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getSelection();
		
		if(selection.size()>0 && (selection.getFirstElement() instanceof IResource))
			result = (IResource)selection.getFirstElement();
		
		return result;
	}

}
