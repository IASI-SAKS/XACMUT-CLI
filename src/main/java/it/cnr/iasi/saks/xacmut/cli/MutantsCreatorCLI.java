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
package it.cnr.iasi.saks.xacmut.cli;

import it.cnr.iasi.saks.xacmut.mutator.generator.MutantGeneratorWrapper;
import it.cnr.isti.sedc.xacml.mutator.generator.MutantGenerator;
import it.cnr.isti.sedc.xacml.mutator.generator.XacmlMutantGenerator;
import it.cnr.isti.sedc.xacml.mutator.gui.MutantsGeneratorMainClass;
import it.cnr.isti.sedc.xacml.mutator.gui.MutantsGeneratorMainGui;
import it.cnr.isti.sedc.xacml.mutator.util.Util;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;

import org.w3c.dom.Node;

import org.mockito.Mockito;

public class MutantsCreatorCLI {

	private JCheckBox mockedFlaggedCheckBox;
	private JCheckBox mockedUnflaggedCheckBox;
	private JProgressBar mockedProgressBar;
	private JButton mockedButton;

	private static Node goldPolicyAsDom;

	private static final String DEFAULT_POLICIES_LOCATION = "." + File.separator + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator + "policies";

	public MutantsCreatorCLI() {
		this.mockedFlaggedCheckBox = Mockito.mock(JCheckBox.class);
		Mockito.when(this.mockedFlaggedCheckBox.isSelected()).thenReturn(true);
		this.mockedUnflaggedCheckBox = Mockito.mock(JCheckBox.class);
		Mockito.when(this.mockedUnflaggedCheckBox.isSelected()).thenReturn(false);

		this.mockedProgressBar = Mockito.mock(JProgressBar.class);
		this.mockedButton = Mockito.mock(JButton.class);
		
	}

	/**
	 * This version of the GUI supports only few mutation operators:
	 * <ul>
	 * <li>CPCA</li>
	 * <li>PSTT</li>
	 * <li>PSTF</li>
	 * <li>CRCA</li>
	 * <li>PTT</li>
	 * <li>PTF</li>
	 * <li>CRE</li>
	 * <li>RTT</li>
	 * <li>RTF</li>
	 * <li>RCT</li>
	 * <li>RCF</li>
	 * </ul>
	 * 
	 * @return a Mocked version of the GUI where few mutation operators are available
	 */
	private MutantsGeneratorMainGui createMockedGUI_MutantsGeneratorMainGui() {
		MutantsGeneratorMainGui mockedGUI = Mockito.mock(MutantsGeneratorMainGui.class);

		Mockito.when(mockedGUI.getCpcaCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPsttCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPstfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getCrcaCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPttCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPtfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getCreCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRttCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRtfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRctCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRcfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);

		return mockedGUI;
	}

	/**
	 * This version of the GUI supports all the mutation operators:
	 * <ul>
	 * <li>CPCA</li>
	 * <li>PSTT</li>
	 * <li>PSTF</li>
	 * <li>CRCA</li>
	 * <li>PTT</li>
	 * <li>PTF</li>
	 * <li>CRE</li>
	 * <li>RTT</li>
	 * <li>RTF</li>
	 * <li>RCT</li>
	 * <li>RCF</li>
	 * <li>RER</li>
	 * <li>RPT</li>
	 * <li>ANR</li>
	 * <li>RUF</li>
	 * <li>AUF</li>
	 * <li>CLF</li>
	 * <li>ANF</li>
	 * <li>RNF</li>
	 * <li>CCF</li>
	 * <li>FPR</li>
	 * <li>FDR</li>
	 * <li>CNOF</li>
	 * </ul>
	 * 
	 * @return a Mocked version of the GUI where all the supported mutation
	 *         operators are enabled
	 */
	private MutantsGeneratorMainClass createMockedGUI_MutantsGeneratorMainClass() {
		MutantsGeneratorMainClass mockedGUI = Mockito.mock(MutantsGeneratorMainClass.class);

		Mockito.when(mockedGUI.getCpcaCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPsttCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPstfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getCrcaCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPttCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getPtfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getCreCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRttCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRtfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRctCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRcfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);

		Mockito.when(mockedGUI.getRerCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRptCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getAnrCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRufCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getAufCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getClfCheckBox5()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getAnfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getRnfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getCcfCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getFprCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getFdrCheckBox()).thenReturn(this.mockedFlaggedCheckBox);
		Mockito.when(mockedGUI.getCnofCheckBox()).thenReturn(this.mockedFlaggedCheckBox);

		Mockito.when(mockedGUI.getjProgressBar()).thenReturn(this.mockedProgressBar);
		Mockito.when(mockedGUI.getExecuteFaultDetectionButton()).thenReturn(this.mockedButton);

		return mockedGUI;
	}

	public static void main(String[] args) {
		System.out.println("Launching CLI ... ");

		MutantsCreatorCLI cli = new MutantsCreatorCLI();

//		MutantsGeneratorMainGui guiSmall = cli.createMockedGUI_MutantsGeneratorMainGui();
		MutantsGeneratorMainClass gui = cli.createMockedGUI_MutantsGeneratorMainClass();

		File xacmlPoliciesFile = new File(DEFAULT_POLICIES_LOCATION);
		System.out.println(xacmlPoliciesFile.getAbsolutePath());
		File[] contentDir = xacmlPoliciesFile.listFiles();

		for (int i = 0; i < contentDir.length; ++i) {
			File goldPolicyFile = contentDir[i];
			if (goldPolicyFile.isFile()) {
				System.out.println(goldPolicyFile.getAbsolutePath());
				goldPolicyAsDom = Util.getFileAsDom(goldPolicyFile);
				if (goldPolicyAsDom != null) {
//******************************************************					
//******************************************************
					MutantGeneratorWrapper mutantsGenerator = new MutantGeneratorWrapper(goldPolicyAsDom, goldPolicyFile, gui);
					mutantsGenerator.executeTheMutation();
					System.out.println("... done: "+ goldPolicyFile.getAbsolutePath());
//******************************************************										
//					XacmlMutantGenerator mutantsGeneratorSmall = new XacmlMutantGenerator(goldPolicyAsDom, goldPolicyFile, guiSmall);
//					XacmlMutantGenerator mutantsGeneratorSmall = new XacmlMutantGenerator(goldPolicyAsDom, goldPolicyFile);
//					mutantsGeneratorSmall.generates();
//******************************************************					
//******************************************************
				}
			}
		}
		System.out.println("... done!");
	}
}
