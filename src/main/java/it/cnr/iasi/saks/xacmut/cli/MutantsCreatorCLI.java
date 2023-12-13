package it.cnr.iasi.saks.xacmut.cli;

import it.cnr.isti.sedc.xacml.mutator.generator.XacmlMutantGenerator;
import it.cnr.isti.sedc.xacml.mutator.gui.MutantsGeneratorMainGui;
import it.cnr.isti.sedc.xacml.mutator.util.Util;
import java.io.File;

import javax.swing.JCheckBox;

import org.w3c.dom.Node;

import org.mockito.Mockito;

/* 
 * This file is part of the XACMUT-CLI project.
 * 
 * XACMUT-CLI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * XACMUT-CLI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with GROUCHO.  If not, see <https://www.gnu.org/licenses/>
 *
 */
public class MutantsCreatorCLI {

	private static Node goldPolicyAsDom;
	private MutantsGeneratorMainGui mainFrameGui;
	
	private static final String DEFAULT_POLICIES_LOCATION = "." + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "policies";

	private MutantsGeneratorMainGui createMockedGUI() {
		MutantsGeneratorMainGui mockedGUI = Mockito.mock(MutantsGeneratorMainGui.class);

		JCheckBox mockedFlaggedCheckBox = Mockito.mock(JCheckBox.class);
		Mockito.when(mockedFlaggedCheckBox.isSelected()).thenReturn(true);
		JCheckBox mockedUnflaggedCheckBox = Mockito.mock(JCheckBox.class);
		Mockito.when(mockedUnflaggedCheckBox.isSelected()).thenReturn(false);

		Mockito.when(mockedGUI.getCpcaCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPsttCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPstfCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getCrcaCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPttCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPtfCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getCreCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRttCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRtfCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRctCheckBox()).thenReturn(mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRcfCheckBox()).thenReturn(mockedFlaggedCheckBox);

		return mockedGUI;
	}

	public static void main(String[] args) {
		System.out.println("Launching CLI ... ");

		MutantsCreatorCLI cli = new MutantsCreatorCLI();

		MutantsGeneratorMainGui gui = cli.createMockedGUI();

		if (gui.getCpcaCheckBox().isSelected()) {
			System.out.println("Selected");
		} else {
			System.out.println("Unselected");
		}

//		File xacmlPoliciesFile = new File("." + File.separator + "policies");
		File xacmlPoliciesFile = new File(DEFAULT_POLICIES_LOCATION);
		System.out.println(xacmlPoliciesFile.getAbsolutePath());
		File[] contentDir = xacmlPoliciesFile.listFiles();

		for (int i = 0; i < contentDir.length; ++i) {
			File goldPolicyFile = contentDir[i];
			if (goldPolicyFile.isFile()) {
				System.out.println(goldPolicyFile.getAbsolutePath());
				goldPolicyAsDom = Util.getFileAsDom(goldPolicyFile);
				if (goldPolicyAsDom != null) {
					XacmlMutantGenerator mutantsGenerator = new XacmlMutantGenerator(goldPolicyAsDom, goldPolicyFile, gui);
//					XacmlMutantGenerator mutantsGenerator = new XacmlMutantGenerator(goldPolicyAsDom, goldPolicyFile);
					mutantsGenerator.generates();
				}
			}
		}
		System.out.println("... done!");
	}
}
