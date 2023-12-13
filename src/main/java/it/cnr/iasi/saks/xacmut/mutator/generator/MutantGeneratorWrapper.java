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
 * along with XACMUT-CLI.  If not, see <https://www.gnu.org/licenses/>
 *
 */
package it.cnr.iasi.saks.xacmut.mutator.generator;

import java.io.File;

import org.w3c.dom.Node;

import it.cnr.isti.sedc.xacml.mutator.generator.MutantGenerator;
import it.cnr.isti.sedc.xacml.mutator.gui.MutantsGeneratorMainClass;

public class MutantGeneratorWrapper extends MutantGenerator {

	public MutantGeneratorWrapper(Node goldPolicyAsDom, File goldPolicyFile, MutantsGeneratorMainClass mutantsGeneratorMainClass) {
		super(goldPolicyAsDom, goldPolicyFile, mutantsGeneratorMainClass);
	}
	
	@Override
	protected Void doInBackground() {
		try {
			super.doInBackground();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return null;		
	}

	public void executeTheMutation() {
		try {
			this.doInBackground();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void done() {
		System.err.println("... possibly there is nothing to do here in this Wrapper.");
	}


}
