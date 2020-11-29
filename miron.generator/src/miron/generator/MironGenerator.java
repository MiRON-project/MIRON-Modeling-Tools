package miron.generator;

import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Injector;

import miron.generator.mzn.MironMznGenerator;
import miron.generator.tools.MironBtWeaver;
import miron.generator.tools.MironVpSampler;
import miron.generator.tools.MironVpSampler.SamplerOptions;
import miron.metamodel.datatypes.MironModel;
import roqme.generator.GenerationHelper;
import miron.editor.ui.internal.EditorActivator;


public class MironGenerator {
	
	public static final MironGenerator INSTANCE = new MironGenerator();
	
	public final static String MIRON_FILE_EXT = "miron";
	public final static String EXTENDED_BT_FILE_EXT = "xml";
	public final static String BT_FILE_EXT = "bt";
	public final static String DZN_FILE_EXT = "dzn";
	public final static String MZN_FILE_EXT = "mzn";
	public final static String MZN_IO_FILE_EXT = "io";
	public final static int NUM_X_POINTS = 200;
	public final static String DEFAULT_TEXT_EDITOR_ID = "org.eclipse.ui.DefaultTextEditor";
	public final static String BT_EDITOR_ID = "org.xtext.behaviortree.BehaviorTree";
	
	private final Injector INJECTOR = EditorActivator.getInstance().getInjector(
			EditorActivator.ORG_XTEXT_MIRON_MIRON);

	
	public void generateBehaviorTree(IFile selectedFile) {

		if(selectedFile.getFileExtension().equalsIgnoreCase(MIRON_FILE_EXT)) {
		
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			
			String selectedFilePath = selectedFile.getLocationURI().toString();
			
			IFolder outputFolder = createFolder("output", selectedFile.getProject());
			IFile outputFile = outputFolder.getFile(selectedFile.getName() 
					.replace("." + MIRON_FILE_EXT, ".ext." + BT_FILE_EXT));

			XtextResourceSet resourceSet = INJECTOR.getInstance(XtextResourceSet.class);	

			try {
				Resource mironResource = resourceSet.getResource(
					    URI.createURI(selectedFilePath), true);
				
				EcoreUtil.resolveAll(mironResource);
					
				MironModel mironModel = (MironModel) mironResource.getContents().get(0);
					
				Resource outputBtResource = resourceSet.createResource(
						URI.createURI(outputFile.getLocationURI().toString()));	
				outputBtResource.getContents()
						.add((new MironBtWeaver()).process(mironModel));
					
				EcoreUtil.resolveAll(resourceSet);
				outputBtResource.save(new HashMap<Object, Object>());
				refresh(outputFolder);
						
				// We had to generate the output with extension "BT" otherwise the format would be wrong 
				// In the following, we change the output file extension to XML
						
				String outputFileName = outputFile.getName()
						.replace(".ext." + BT_FILE_EXT, ".ext." + EXTENDED_BT_FILE_EXT);
						
				// Does the XML output file exist? If so, we delete it
				IFile destinationFile = outputFolder.getFile(outputFileName);
				if(destinationFile.exists()) {
					destinationFile.delete(true, new NullProgressMonitor());
				}
				// Move the BT file to the XML file
				outputFile.move(
						new Path(outputFileName), true, new NullProgressMonitor());
						
				refresh(outputFolder);
				openFileInEditor(outputFolder, outputFileName, true, BT_EDITOR_ID);
			} 
			catch (Exception e) {
				MessageDialog.openError(window.getShell(), "Generation process", 
						"The generation of the Extended Behavior Tree has failed");
				e.printStackTrace();
			}
		}			
	}
	
	public void generateMinizinc(IFile selectedFile) {
		
		if(selectedFile.getFileExtension().equalsIgnoreCase(MIRON_FILE_EXT)) {
			
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			
			String selectedFilePath = selectedFile.getLocationURI().toString();
			
			IFolder outputFolder = createFolder("output", selectedFile.getProject());
			IFile outputFile = outputFolder.getFile(selectedFile.getName()
					.replace("." + MIRON_FILE_EXT, "." + DZN_FILE_EXT));
			
			XtextResourceSet resourceSet = INJECTOR.getInstance(XtextResourceSet.class);
			
			try {
				Resource mironResource = resourceSet.getResource(
						URI.createURI(selectedFilePath), true);
			
				EcoreUtil.resolveAll(mironResource);

				MironModel mironModel = (MironModel) mironResource.getContents().get(0);
				
				// DZN file generation
				MironVpSampler sampler = new MironVpSampler(
						SamplerOptions.OPT_OUTPUT_FILEPATH, outputFile.getLocation().toString(),
						SamplerOptions.OPT_NUM_X_POINTS, String.valueOf(NUM_X_POINTS));
				sampler.process(mironModel);
							
				// MSN file generation
				GenerationHelper.generate(new MironMznGenerator(), resourceSet, outputFolder);
							
				refresh(outputFolder);	
				MessageDialog.openInformation(window.getShell(), "Generation process", 
						"The MiniZinc models has been generated successfully");
			} 
			catch (Exception e) {
				MessageDialog.openError(window.getShell(), "Generation process", 
						"The MiniZinc generation has failed");
				e.printStackTrace();
			}						
		}
	}
	
	
	private IFolder createFolder(String name, IResource destination) {
		IFolder folder = null;
		
		try {
			IProgressMonitor progressMonitor = new NullProgressMonitor();

			if(destination != null) {
				if(destination.getType() == IFolder.FOLDER) {
					folder = ((IFolder)destination).getFolder(name);
				}
				else if(destination.getType() == IProject.PROJECT) {
					folder = ((IProject)destination).getFolder(name);
				}

				if(folder != null && !folder.exists()) {
					folder.create(true, true, progressMonitor);
				}
				//folder.setDerived(true, progressMonitor);
			}
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
		return folder;
	}
	
	private void refresh(IResource resource) {
		
		IResource resToUpdate = resource != null ? resource 
				: ResourcesPlugin.getWorkspace().getRoot();

		try {
			// If the resource is a project, we close and open it because
			// sometimes it is not enough refreshing it
			if(resToUpdate instanceof IProject) {
				IProgressMonitor monitor = new NullProgressMonitor();
				((IProject) resToUpdate).close(monitor);
				((IProject) resToUpdate).open(monitor);
			}
			resToUpdate.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void openFileInEditor(IResource resource, String fileName, boolean triggerFormatter, String editorId) {
	
		IResource resourceToOpen = resource.getType() == IResource.PROJECT ? 
				((IProject) resource).findMember(fileName) :
				resource.getType() == IResource.FOLDER ?
				((IFolder) resource).findMember(fileName) : null;

		if(resourceToOpen != null && resourceToOpen.getType() == IResource.FILE) {
			IFile fileToOpen = (IFile) resourceToOpen;
			
			// Get the active page
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			
			IEditorDescriptor editorDesc = null;
			if(editorId != null && !editorId.isEmpty()) {
				// Find editor using the passed editor id, if it does not exist then select the default text editor
				if((editorDesc = PlatformUI.getWorkbench().getEditorRegistry().findEditor(editorId)) == null) {
					editorDesc = PlatformUI.getWorkbench().getEditorRegistry().findEditor(DEFAULT_TEXT_EDITOR_ID);
				}
			}
			else {
				// Figure out the default editor for the file type based on extension
				editorDesc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(fileToOpen.getName());
			}
		
			if(editorDesc != null) {
				try {
					IEditorPart editor = page.openEditor(new FileEditorInput(fileToOpen), editorDesc.getId());
					
					if(triggerFormatter) {
						((SourceViewer)((XtextEditor) editor).getInternalSourceViewer()).doOperation(ISourceViewer.FORMAT);
						page.saveEditor(editor, false);
					}
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


